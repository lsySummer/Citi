package edu.nju.service.CategoryAndProduct;

/**
 * Created by Sun YuHao on 2016/8/26.
 */
public interface Category {
    Category getBiggerCategory();
    String getCategoryName();
    String getChineseName();
    String getUnit();
    boolean equals(Category category);
    boolean equals(String categoryName);
    Integer getSubTypeIndex();
    boolean belongTo(String category);
    boolean belongTo(Category category);
}
