package edu.nju.service.CategoryAndProduct;

/**
 * Created by Sun YuHao on 2016/8/26.
 */
public interface Category {
    Category getBiggerCategory();
    String getCategoryName();
    String getUnit();
    boolean equals(String categoryName);
    Integer getSubTypeIndex();
}
