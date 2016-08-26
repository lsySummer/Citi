package edu.nju.service.SearchService;

import edu.nju.model.CategoryIndex;
import edu.nju.service.BaseService.BaseFunctionServiceAdaptor;
import edu.nju.service.CategoryAndProduct.Product;
import edu.nju.service.CategoryAndProduct.ProductFactory;
import edu.nju.service.Exceptions.NoSuchProductException;
import edu.nju.service.CategoryAndProduct.Category;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import edu.nju.vo.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        Category category = ProductCategoryManager.getCategoryByID(ID);
        int index = ProductCategoryManager.getProductItemIndex(ID);

        List list = getUserService().getCommonDao().find("FROM Product" + category + " product WHERE product.id=" + index);
        return ProductFactory.createProduct(list.get(0), category.getCategoryName());
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
                    chosenList.add(ProductFactory.createProduct(product, categoryName));
                }
            }
        }

        return chosenList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> searchProductsByKey(String keyWord) {
        try {
            List<Product> productList = new ArrayList<>();
            List<Integer> list = getUserService().getCommonDao().find("SELECT id FROM NameToId nameToId WHERE nameToId.name LIKE %" +
            keyWord + "%");

            for (Integer id : list) {
                productList.add(getProductByID(id));
            }

            return productList;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public HistoryDataVO getHistoryDataVO(Long productId) {
        return null;
    }

    @Override
    public ProductDetailVO getProductDetailVO(Long productID) {
        return null;
    }

    @Override
    public ProjectVO getProjectVO(Long projectID) {
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
            productList.add(ProductFactory.createProduct(object, category.getCategoryName()));
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
            productList.add(ProductFactory.createProduct(object, category.getCategoryName()));
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
}
