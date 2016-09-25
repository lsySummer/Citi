package edu.nju.service.SearchService;

import edu.nju.model.*;
import edu.nju.service.Cache.ProductCache;
import edu.nju.service.CategoryAndProduct.Product;
import edu.nju.service.CategoryAndProduct.ProductFactory;
import edu.nju.service.ExceptionsAndError.DataNotFoundException;
import edu.nju.service.ExceptionsAndError.NoSuchProductException;
import edu.nju.service.CategoryAndProduct.Category;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import edu.nju.service.POJO.NAVHistory;
import edu.nju.service.UserService.UserService;
import edu.nju.service.Utils.MethodUtils;
import edu.nju.service.Utils.ListUtils;
import edu.nju.service.Utils.UnitTransformation;
import edu.nju.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    UserService userService;

    private ProductCache productCache;

    static final int MAX_RESULT = 500;

    public SearchServiceImpl() {
        this.productCache = new ProductCache();
        productCache.setMaxCacheNum(10000);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getProductByName(String productName) throws NoSuchProductException {
        if (productCache.getCached(productName) != null) {
            return productCache.getCached(productName);
        }

        List<Integer> list = userService.getCommonDao().find("SELECT id FROM NameToId nameToId WHERE nameToId.name='" + productName + "'");
        if (list == null || list.size() == 0) {
            throw  new NoSuchProductException(productName);
        }

        if (list.size() == 0) {
            return null;
        }

        List<Product> productList = new ArrayList<>();
        for (Integer id : list) {
            productList.add(getProductByID(id));
        }

        productCache.cache(productName, productList, null);
        return productList;
    }

    @Override
    public Product getProductByID(Integer ID) throws NoSuchProductException {
        if (productCache.getCached(ID) != null) {
            return productCache.getCached(ID).get(0);
        }

        Category biggerCategory = ProductCategoryManager.getCategoryByID(ID).getBiggerCategory();
        int index = ProductCategoryManager.getProductItemIndex(ID);

        List list = userService.getCommonDao().find("FROM Product" + biggerCategory + " product WHERE product.id=" + index);
        if (list == null || list.size() == 0) {
            throw new NoSuchProductException(ID);
        }
        else {
            Product product =  ProductFactory.createProduct(list.get(0));
            if (!product.getID().equals(ID)) {
                throw new NoSuchProductException(ID);
            }
            else {
                productCache.cache(product.getID(), product, null);
                return product;
            }
        }
    }

    @Override
    public List<Product> searchProductByFilter(ProductFilter filter) {
        List<Product> chosenList = new ArrayList<>();
        List<String> searchScope = filter.getSearchScope();

        for (String categoryName : searchScope) {
            Category category = ProductCategoryManager.getCategoryByName(categoryName);
            List productList;
            if (!category.equals(ProductCategoryManager.categoryFund)) {
                productList = userService.getCommonDao().find("FROM Product" + category + " product");
            }
            else {
                productList = userService.getCommonDao().find("FROM Product" + category.getBiggerCategory() + " p WHERE p.category=" + category.getSubTypeIndex());
            }

            for (Object product: productList) {
                if (filter.isChosen(product)) {
                    chosenList.add(ProductFactory.createProduct(product));
                }
            }
        }

        return chosenList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> searchProductsByKey(String keyWord, String searchType) {
        String tag = "key:" + keyWord + "type:" + searchType;
        if (productCache.getCached(tag) != null) {
            return productCache.getCached(tag);
        }

        try {
            List<Product> productList = new ArrayList<>();
            if (keyWord == null) {
                keyWord = "";
            }

            if (searchType == null || searchType.equals("all")) {
                productList.addAll(searchProductsByKey(keyWord, ProductCategoryManager.categoryBank));
                productList.addAll(searchProductsByKey(keyWord, ProductCategoryManager.categoryBond));
                productList.addAll(searchProductsByKey(keyWord, ProductCategoryManager.categoryFund));
                productList.addAll(searchProductsByKey(keyWord, ProductCategoryManager.categoryInsurance));
            }
            else if (searchType.equals(ProductCategoryManager.categoryFund) ||
                    searchType.equals(ProductCategoryManager.categoryInsurance) ||
                    searchType.equals(ProductCategoryManager.categoryBank) ||
                    searchType.equals(ProductCategoryManager.categoryBond)) {
                List<Object> list = userService.getCommonDao().find("FROM Product" + searchType +
                        " p WHERE p.name LIKE '%" +
                        keyWord + "%'", MAX_RESULT);

                if (list != null && list.size() != 0) {
                    productList = ProductFactory.createProduct(list.toArray());
                }
            }

            productCache.cache(tag, productList, null);
            return productList;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public HistoryDataVO getHistoryDataVO(Integer productId) {
        return null;
    }

    @Override
    public ProductDetailVO getProductDetailVO(Integer productID) {
        return null;
    }

    @Override
    public ProjectVO getProjectVO(Integer projectID) {
        return null;
    }

    @Override
    public Object searchMin(String type, String word) {
        try {
            Category category = ProductCategoryManager.getCategoryByName(type);
            if (!category.equals(ProductCategoryManager.categoryFund)) {
                return userService.getCommonDao().find("SELECT MIN(o." + word + ") FROM Product" + category + " o").get(0);
            }
            else {
                return userService.getCommonDao().find("SELECT MIN(o." + word + ") FROM Product" + category.getBiggerCategory() + " o WHERE o.category=" + category.getSubTypeIndex()).get(0);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> searchProductsByCondition(String type, String cond) {
        String tag = "type:" + type + "cond:" + cond;
        if (productCache.getCached(tag) != null) {
            return productCache.getCached(tag);
        }

        Category category = ProductCategoryManager.getCategoryByName(type);
        if (category == null) {
            return new ArrayList<>();
        }

        List list;
        if (!category.belongTo(ProductCategoryManager.categoryFund)) {
            list = userService.getCommonDao().find("FROM Product" + category + " p WHERE " + cond);
        }
        else {
            list = userService.getCommonDao().find("FROM Product" + category.getBiggerCategory() + " p WHERE p.category=" + category.getSubTypeIndex() + " AND " + cond);
        }

        List<Product> productList = new ArrayList<>();
        if (list != null && list.size() != 0) {
            productList = ProductFactory.createProduct(list.toArray());
        }

        productCache.cache(tag, productList, null);
        return productList;
    }

    @Override
    public List<Product> getProductListByOrder(String type, String order) {
        String tag = "type:" + type + "order:" + order;
        if (productCache.getCached(tag) != null) {
            return productCache.getCached(tag);
        }

        Category category = ProductCategoryManager.getCategoryByName(type);
        List list;

        if (!category.belongTo(ProductCategoryManager.categoryFund)) {
            list = userService.getCommonDao().find("FROM Product" + category + " p ORDER BY " + order);
        }
        else {
            list = userService.getCommonDao().find("FROM Product" + category.getBiggerCategory() + " p WHERE p.category=" + category.getSubTypeIndex() + " ORDER BY " + order);
        }

        List<Product> productList = new ArrayList<>();
        if (list != null && list.size() != 0) {
            productList = ProductFactory.createProduct(list.toArray());
        }

        productCache.cache(tag, productList, null);
        return productList;
    }

    @Override
    public List<Product> searchProductsByConditionWithOrder(String type, String cond, String order) {
        String tag = "type:" + type + "cond:" + cond;
        if (productCache.getCached(tag) != null) {
            return productCache.getCached(tag);
        }

        Category category = ProductCategoryManager.getCategoryByName(type);
        List list;

        if (!category.belongTo(ProductCategoryManager.categoryFund)) {
            list = userService.getCommonDao().find("FROM Product" + category + " p WHERE " + cond + " ORDER BY " + order);
        }
        else {
            list = userService.getCommonDao().find("FROM Product" + category.getBiggerCategory() + " p WHERE p.category=" + category.getSubTypeIndex() + " AND " + cond + " ORDER BY " + order);
        }

        List<Product> productList = new ArrayList<>();
        if (list != null && list.size() != 0) {
            productList = ProductFactory.createProduct(list.toArray());
        }

        productCache.cache(tag, productList, null);
        return productList;
    }

    @Override
    public CategoryIndex getCategoryIndex() {
        List list = userService.getCommonDao().find("FROM CategoryIndex c ORDER BY id DESC", 1);
        if (list == null || list.size() == 0) {
            return null;
        }

        return (CategoryIndex)list.get(0);
    }

    @Override
    public Product[] getProductsByIds(int[] ids) {
        List<Product> list = new ArrayList<>();

        for (int id :ids) {
            try {
                Product product = getProductByID(id);
                if (product != null) {
                    list.add(product);
                }
            }
            catch (NoSuchProductException n) {
                n.printStackTrace();
            }
        }
        if (list.size() == 0) {
            return null;
        }
        else {
            return (Product[]) list.toArray();
        }
    }

    @Override
    public double getCost(int[] id, int[] amount) {
        if (id.length == 0 || id.length != amount.length) {
            return -1;
        }

        try {
            double cost = 0;
            Product[] products = getProductsByIds(id);

            for (int i = 0; i < products.length; ++i) {

                double one_cost = UnitTransformation.calcuCost(products[i], amount[i]);
                if (one_cost < 0) {
                    return -1;
                }
            }

            return cost;
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public NAVHistory[] getFundValueHistory(Integer id, Integer days) throws DataNotFoundException {
        if (days == null) {
            days = Integer.MAX_VALUE;
        }

        List<FundDailyHistory> list = userService.getCommonDao().
                find("FROM FundDailyHistory p WHERE p.fundId=" + id +" ORDER BY p.date DESC", days);

        if (list == null || list.size() == 0) {
            throw new DataNotFoundException("Fund History");
        }
        else {
            Collections.reverse(list);
            NAVHistory[] fundValueHistories = new NAVHistory[list.size()];

            for (int i = 0; i < list.size(); ++i) {
                fundValueHistories[i] = new NAVHistory();
                fundValueHistories[i].setNAV(list.get(i).getNav().doubleValue());
                fundValueHistories[i].setDate(list.get(i).getDate().toString());
            }

            return fundValueHistories;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public NAVHistory[] getBankValueHistory(Integer id, Integer days) throws DataNotFoundException {
        List<BankDailyHistory> list = userService.getCommonDao().find("FROM BankDailyHistory p WHERE p.bankId="+ id +" ORDER BY p.date DESC");
        if (days == null) {
            days = Integer.MAX_VALUE;
        }

        if (list == null) {
            throw new DataNotFoundException("Bank History");
        }
        else {
            Collections.reverse(list);
            NAVHistory[] bankValueHistory = new NAVHistory[list.size()];

            for (int i = 0; i < list.size() && i < days; ++i) {
                bankValueHistory[i] = new NAVHistory();
                bankValueHistory[i].setNAV(list.get(i).getNav().doubleValue());
                bankValueHistory[i].setDate(list.get(i).getDate().toString());
            }

            return bankValueHistory;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CategoryRtrWeeklyHistory> getCategoryRtrWeeklyHistory(Integer days) {
        List<CategoryRtrWeeklyHistory> list = (List<CategoryRtrWeeklyHistory>)userService.getCommonDao().
                find("FROM CategoryRtrWeeklyHistory c ORDER BY c.date DESC", 30);

        if (list == null || list.size() == 0) {
            return null;
        }
        deal_null(list);
        Collections.reverse(list);

        return list;
    }

    private void deal_null(List<CategoryRtrWeeklyHistory> list) {
        for (CategoryRtrWeeklyHistory categoryRtrWeeklyHistory : list) {
            setValue(categoryRtrWeeklyHistory, "Bank");
            setValue(categoryRtrWeeklyHistory, "Bond");
            setValue(categoryRtrWeeklyHistory, "StockFund");
            setValue(categoryRtrWeeklyHistory, "CurrencyFund");
            setValue(categoryRtrWeeklyHistory, "EtfFund");
            setValue(categoryRtrWeeklyHistory, "qdllFund");
            setValue(categoryRtrWeeklyHistory, "IndexFund");
        }
    }

    @SuppressWarnings("unchecked")
    void setValue(CategoryRtrWeeklyHistory categoryRtrWeeklyHistory, String fieldName) {
        try {
            Class cls = CategoryRtrWeeklyHistory.class;
            Method getter = MethodUtils.getGetter(CategoryRtrWeeklyHistory.class, fieldName);

            BigDecimal value = (BigDecimal)getter.invoke(categoryRtrWeeklyHistory);
            if (value == null) {
                Method setter = MethodUtils.getSetter(CategoryRtrWeeklyHistory.class, fieldName, BigDecimal.class);
                setter.invoke(categoryRtrWeeklyHistory, new BigDecimal(0));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<String> getInstitutionNameList(String category) {
        String searchType;

        if (category.equals(ProductCategoryManager.categoryFund) ||
                category.equals(ProductCategoryManager.categoryBank) ||
                category.equals(ProductCategoryManager.categoryInsurance)) {

            searchType = "Product" + category;

            List<String> list = userService.getCommonDao().find("SELECT p.institutionManage FROM " + searchType + " p");
            ListUtils.eliminateDumplicatedString(list);

            if (list.size() != 0) {
                return list;
            } else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public double[] getHS300Daily(int days) {
        List<Hs300Daily> list = userService.getCommonDao().find("FROM Hs300Daily h ORDER by date DESC", days);

        if (list.size() == 0) {
            return new double[0];
        }
        else {
            double[] ret = new double[list.size()];

            for (int i = 0; i < list.size(); ++i) {
                ret[i] = list.get(i).getHs300Return().doubleValue();
            }

            return ret;
        }
    }

    @Override
    public double[] getHS300Weekly(int weeks) {
        List<Hs300Weekly> list = userService.getCommonDao().find("FROM Hs300Weekly h ORDER by date DESC", weeks);

        if (list.size() == 0) {
            return new double[0];
        }
        else {
            double[] ret = new double[list.size()];

            for (int i = 0; i < list.size(); ++i) {
                ret[i] = list.get(i).getHs300Return().doubleValue();
            }

            return ret;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public CategoryMarketWeeklyHistory getCategoryMarket() {
        List<CategoryMarketWeeklyHistory> list = userService.getCommonDao().find("FROM CategoryMarketWeeklyHistory");

        if (list == null || list.size() == 0) {
            return null;
        }

        return list.get(0);
    }

    @Override
    public List<String> getBondYieldType() {
        return ProductCategoryManager.getBondInterestTypeList();
    }

    @Override
    public List<String> getBondStateType() {
        return ProductCategoryManager.getBondStateType();
    }

    @Override
    public List<String> getFundTargetType() {
        return ProductCategoryManager.getFundTypeCH();
    }

    @Override
    public List<String> getFundState() {
        return ProductCategoryManager.getFundStateType();
    }

    @Override
    public List<String> getBankYieldType() {
        return ProductCategoryManager.getBankYieldType();
    }
}