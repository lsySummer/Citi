package edu.nju.action;

import edu.nju.model.ProductFund;
import edu.nju.service.CategoryAndProduct.Category;
import edu.nju.service.CategoryAndProduct.Product;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.ExceptionsAndError.InvalidParametersException;
import edu.nju.service.POJO.ProductVOFactory;
import edu.nju.service.POJO.SearchFilterFactory;
import edu.nju.service.SearchService.ProductFilter;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.ServiceManagerImpl;
import edu.nju.vo.InstitutionListVO;
import edu.nju.vo.ProductDetailVO;
import edu.nju.vo.ProductsDetailVO;
import edu.nju.vo.SearchResultVO;

import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/9/3.
 */
public class AndroidSearchAction extends AndroidAction {
    public String findProductById() {
        Map map = getRequestMap();

        SearchService searchService = ServiceManagerImpl.getInstance().getSearchService();
        ProductDetailVO productDetailVO = new ProductDetailVO();

        try {
            int id = (Integer)map.get("productId");
            Product product = searchService.getProductByID(id);
            if (product != null) {
                ErrorManager.setError(productDetailVO, ErrorManager.errorNormal);
                productDetailVO.setType(product.getCategory().getChineseName());
                productDetailVO.setData(product.getProduct());

                setResult(productDetailVO);
                return SUCCESS;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        ErrorManager.setError(productDetailVO, ErrorManager.errorNoSuchProduct);
        setResult(productDetailVO);
        return SUCCESS;
    }

    public String getProductsByIds() {
        Map map = getRequestMap();

        SearchService searchService = ServiceManagerImpl.getInstance().getSearchService();
        ProductsDetailVO productsDetailVO = new ProductsDetailVO();

        try {
            String ids = (String) map.get("ids");
            String idList_s[] = ids.split(":");
            int[] list = new int[idList_s.length];
            for (int i = 0; i < idList_s.length; ++i) {
                int id_i = Integer.valueOf(idList_s[i]);
                list[i] = id_i;
            }

            Product[] products = searchService.getProductsByIds(list);
            if (products.length == 0) {
                ErrorManager.setError(productsDetailVO, ErrorManager.errorDataNotFound);
                setResult(productsDetailVO);

                return SUCCESS;
            }

            Object[] data = new Object[products.length];

            for (int i = 0; i < data.length; ++i) {
                data[i] = products[i].getProduct();
            }
            productsDetailVO.setData(data);

            productsDetailVO.setData(new Object[0]);
            ErrorManager.setError(productsDetailVO, ErrorManager.errorNormal);
            setResult(productsDetailVO);
        }
        catch (Exception e) {
            e.printStackTrace();
            ErrorManager.setError(productsDetailVO, ErrorManager.errorInvalidParameter);
            setResult(productsDetailVO);
        }

        return SUCCESS;
    }

    public String searchProducts() {
        Map map = getRequestMap();

        SearchService searchService = ServiceManagerImpl.getInstance().getSearchService();
        SearchResultVO searchResult = new SearchResultVO();

        try {
            String key = (String)map.get("keyword");
            String type = (String)map.get("type");
            Byte order = (Byte) map.get("order");
            String searchType;

            ProductFilter productFilter = SearchFilterFactory.createFilter(type, map);
            Category category = ProductCategoryManager.getCategoryByName(type);
            if (category == null) {
                searchType = null;
            }
            else {
                searchType = category.getBiggerCategory().getCategoryName();
            }

            List<Product> productList = searchService.searchProductsByKey(key, searchType);

            //set order
            if (type.equals(ProductCategoryManager.categoryFund) && order != null) {
                if (order == 1) {
                    productList.sort((p1, p2) -> ((ProductFund) p2.getProduct()).getYearlyRtnRate().compareTo(((ProductFund) p1.getProduct()).getYearlyRtnRate()));
                }
                else if (order == 2) {
                    productList.sort((p1, p2) -> ((ProductFund) p1.getProduct()).getYearlyRtnRate().compareTo(((ProductFund) p2.getProduct()).getYearlyRtnRate()));
                }
            }

            ProductVOFactory productVOFactory = new ProductVOFactory();
            if (productList != null) {
                for (Product product : productList) {
                    if (productFilter.isChosen(product.getProduct())) {
                        productVOFactory.addProduct(product);
                    }
                }
            }

            searchResult.setData(productVOFactory.getResultList(order));
            setResult(searchResult);
        }
        catch (Exception i) {
            i.printStackTrace();
            ErrorManager.setError(searchResult,ErrorManager.errorInvalidParameter);
            setResult(searchResult);
        }

        return SUCCESS;
    }

    public String getInstitutionList() {
        Map map = getRequestMap();
        InstitutionListVO institutionListVO = new InstitutionListVO();

        try {
            String category = (String)map.get("type");
            SearchService searchService = ServiceManagerImpl.getInstance().getSearchService();
            List<String> institutions = searchService.getInstitutionNameList(category);

            if (institutions == null) {
                ErrorManager.setError(institutionListVO, ErrorManager.errorDataNotFound);
            }
            else {
                institutionListVO.setInstitutions(institutions);
                ErrorManager.setError(institutionListVO, ErrorManager.errorNormal);
            }
        }
        catch (Exception e) {
            ErrorManager.setError(institutionListVO, ErrorManager.errorInvalidParameter);
        }

        setResult(institutionListVO);
        return SUCCESS;
    }

}
