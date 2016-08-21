package edu.nju.service.SearchService.ProductManager;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/8/14.
 */
public interface ProductFilter {
    boolean isChosen(Object product);
    List<String> getSearchScope();
}
