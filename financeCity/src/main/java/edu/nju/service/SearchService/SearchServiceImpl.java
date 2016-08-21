package edu.nju.service.SearchService;

import edu.nju.service.BaseService.BaseFunctionServiceAdaptor;
import edu.nju.service.Exceptions.NoSuchProductException;
import edu.nju.service.Exceptions.NotLoginException;
import edu.nju.service.POJO.Filter;
import edu.nju.service.POJO.Product;
import edu.nju.service.POJO.ProductBaseInfo;
import edu.nju.service.POJO.SearchConfig;
import edu.nju.service.SearchService.ProductManager.ProductCategoryManager;
import edu.nju.service.SearchService.ProductManager.ProductCategoryManagerImpl;
import edu.nju.service.SearchService.ProductManager.ProductFilter;
import edu.nju.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public class SearchServiceImpl extends BaseFunctionServiceAdaptor implements SearchService {
    private ProductCategoryManager productCategoryManager;

    public SearchServiceImpl() {
        productCategoryManager = ProductCategoryManagerImpl.getInstance();
    }

    @Override
    public Product getProductByName(String productName) throws NoSuchProductException {
        try {
            List list = getUserService().getUserDao().find("SELECT id FROM NameToId nameToId WHERE nameToId.name=" + productName);
            if (list == null || list.size() == 0) {
                throw  new NoSuchProductException(productName);
            }

            Integer id = (Integer) list.get(0);
            return getProductByID(id);
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            return null;
        }
    }

    @Override
    public Product getProductByID(Integer ID) throws NoSuchProductException {
        String category = productCategoryManager.getType(ID);
        int index = productCategoryManager.getProductItemIndex(ID);

        try {
            List list = getUserService().getUserDao().find("FROM Product" + category + " product WHERE product.id=" + index);
            return new Product(list.get(0), category);
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> searchProductByFilter(ProductFilter filter) {
        List<Product> chosenList = new ArrayList<>();
        List<String> searchScope = filter.getSearchScope();

        try {
            for (String category : searchScope) {
                List productList = getUserService().getUserDao().find("FROM Product" + category +
                " product");

                for (Object product: productList) {
                    if (filter.isChosen(product)) {
                        chosenList.add(new Product(product, category));
                    }
                }
            }

            return chosenList;
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> searchProductsByKey(String keyWord) {
        try {
            List<Product> productList = new ArrayList<>();
            List<Integer> list = getUserService().getUserDao().find("SELECT id FROM NameToId nameToId WHERE nameToId.name LIKE %" +
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
    public int generateProductID(String product_type, int index) {
        return productCategoryManager.generateProductID(index, product_type);
    }

    @Override
    public Object searchMin(String PO, String word) {
        try {
            return getUserService().getUserDao().find("SELECT MIN(o." + word + ") FROM PO o").get(0);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> searchProductsByCondition(String type, String cond) {
        try {
            List list = getUserService().getUserDao().find("FROM Product" + type +
                    " p WHERE " + cond);

            List<Product> productList = new ArrayList<>();
            for (Object object : list) {
                productList.add(new Product(object, type));
            }

            return productList;
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> getProductListByOrder(String type, String order) {
        try {
            List<Product> productList = new ArrayList<>();
            List list = getUserService().getUserDao().find("FROM Product" + type +
            " p ORDER BY " + order);

            for (Object object : list) {
                productList.add(new Product(object, type));
            }

            return productList;
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            return null;
        }
    }
}
