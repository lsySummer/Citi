package edu.nju.service.SearchService;

import edu.nju.model.*;
import edu.nju.service.BaseService.BaseFunctionServiceAdaptor;
import edu.nju.service.CategoryAndProduct.Product;
import edu.nju.service.CategoryAndProduct.ProductFactory;
import edu.nju.service.ExceptionsAndError.NoSuchProductException;
import edu.nju.service.CategoryAndProduct.Category;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.Utils.UnitTransformation;
import edu.nju.vo.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public class SearchServiceImpl extends BaseFunctionServiceAdaptor implements SearchService {

    @Override
    public Product getProductByName(String productName) throws NoSuchProductException {
        List list = getUserService().getCommonDao().find("SELECT id FROM NameToId nameToId WHERE nameToId.name=" + productName);
        if (list == null || list.size() == 0) {
            throw  new NoSuchProductException(productName);
        }

        Integer id = (Integer) list.get(0);
        return getProductByID(id);
    }

    @Override
    public Product getProductByID(Integer ID) throws NoSuchProductException {
        Category biggerCategory = ProductCategoryManager.getCategoryByID(ID);
        int index = ProductCategoryManager.getProductItemIndex(ID);

        List list = getUserService().getCommonDao().find("FROM Product" + biggerCategory + " product WHERE product.id=" + index);
        if (list == null || list.size() == 0) {
            return null;
        }
        else {
            return ProductFactory.createProduct(list.get(0));
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
                productList = getUserService().getCommonDao().find("FROM Product" + category + " product");
            }
            else {
                productList = getUserService().getCommonDao().find("FROM Product" + category.getBiggerCategory() + " p WHERE p.category=" + category.getSubTypeIndex());
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
        try {
            List<Product> productList = new ArrayList<>();

            if (searchType == null) {
                List<Integer> list = getUserService().getCommonDao().find("SELECT id FROM NameToId nameToId WHERE nameToId.name LIKE %" +
                        keyWord + "%");

                for (Integer id : list) {
                    productList.add(getProductByID(id));
                }
            }
            else if (!searchType.equals(ProductCategoryManager.categoryBond)) {
                List<Integer> list = getUserService().getCommonDao().find("SELECT id FROM Product" + searchType +
                        " p WHERE p.name LIKE '%" +
                        keyWord + "%'");

                for (Integer id : list) {
                    int pid = ProductCategoryManager.generateProductID(id, searchType);
                    productList.add(getProductByID(pid));
                }
            }
            else {
                List<Integer> list = getUserService().getCommonDao().find("SELECT id FROM ProductBond p WHERE p.title LIKE '%" +
                        keyWord + "%'");

                for (Integer id : list) {
                    int pid = ProductCategoryManager.generateProductID(id, searchType);
                    productList.add(getProductByID(pid));
                }
            }

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
                return getUserService().getCommonDao().find("SELECT MIN(o." + word + ") FROM Product" + category + " o").get(0);
            }
            else {
                return getUserService().getCommonDao().find("SELECT MIN(o." + word + ") FROM Product" + category.getBiggerCategory() + " o WHERE o.category=" + category.getSubTypeIndex()).get(0);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> searchProductsByCondition(String type, String cond) {
        Category category = ProductCategoryManager.getCategoryByName(type);
        List list;

        if (!category.equals(ProductCategoryManager.categoryFund)) {
            list = getUserService().getCommonDao().find("FROM Product" + category + " p WHERE " + cond);
        }
        else {
            list = getUserService().getCommonDao().find("FROM Product" + category.getBiggerCategory() + " p WHERE p.category=" + category.getSubTypeIndex() + " AND " + cond);
        }

        List<Product> productList = new ArrayList<>();
        for (Object object : list) {
            productList.add(ProductFactory.createProduct(object));
        }

        return productList;
    }

    @Override
    public List<Product> getProductListByOrder(String type, String order) {
        Category category = ProductCategoryManager.getCategoryByName(type);
        List list;

        if (!category.equals(ProductCategoryManager.categoryFund)) {
            list = getUserService().getCommonDao().find("FROM Product" + category + " p ORDER BY " + order);
        }
        else {
            list = getUserService().getCommonDao().find("FROM Product" + category.getBiggerCategory() + " p WHERE p.category=" + category.getSubTypeIndex() + " ORDER BY " + order);
        }

        List<Product> productList = new ArrayList<>();

        for (Object object : list) {
            productList.add(ProductFactory.createProduct(object));
        }

        return productList;
    }

    @Override
    public CategoryIndex getCategoryIndex() {
        List list = getUserService().getCommonDao().find("SELECT TOP 1 FROM CategoryIndex c ORDER BY id DESC");
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
            return new Product[0];
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
    public List<String> getInstitutionNameList() {
        List<String> list = getUserService().getCommonDao().find("SELECT i.name FROM Institution i");
        if (list == null || list.size() == 0) {
            return null;
        }
        else {
            return list;
        }
    }

    @Override
    public List<Institution> getInstitutionList() {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<String> getInstitutionNameList(String category) {
        List<Integer> list = getUserService().getCommonDao().find("SELECT i.institutionId FROM InstitutionCategoryRelation i WHERE i.category='"
                + category + "'");

        if (list == null || list.size() == 0) {
            return null;
        }
        else {
            List<String> insList = new ArrayList<>();
            for (Integer ins_id : list) {
                String ins = (String)getUserService().getCommonDao().find("SELECT i.name FROM Institution i WHERE i.id=" + ins_id).get(0);
                insList.add(ins);
            }

            if (insList.size() == 0) {
                return null;
            }
            else {
                return insList;
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public double[] getHS_300ByTime() {
        List<Hs300> list = getUserService().getCommonDao().find("FROM Hs300 h ORDER by date");

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
}
