package edu.nju.service.CategoryAndProduct;

/**
 * Created by Sun YuHao on 2016/8/26.
 */
public class CategoryImpl implements Category {
    private Category biggerCategory;
    private String categoryName;
    private String ChineseName;
    private Integer subTypeIndex;

    public CategoryImpl(String categoryName, Category biggerCategory, Integer subTypeIndex, String chineseName) {
        this.biggerCategory = biggerCategory;
        this.categoryName = categoryName;
        this.subTypeIndex = subTypeIndex;
        this.ChineseName = chineseName;
    }

    @Override
    public Category getBiggerCategory() {
        if (biggerCategory == null) {
            return this;
        }
        else {
            return biggerCategory;
        }
    }

    @Override
    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String getUnit() {
        return ProductCategoryManager.getUnit(categoryName);
    }

    @Override
    public boolean equals(String categoryName) {
        return getCategoryName().equals(categoryName);
    }

    @Override
    public boolean equals(Category category) {
        return this.categoryName.equals(category.getCategoryName());
    }

    @Override
    public Integer getSubTypeIndex() {
        return subTypeIndex;
    }

    @Override
    public String toString() {
        return categoryName;
    }

    @Override
    public boolean belongTo(String category) {
        return getBiggerCategory().equals(category);
    }

    @Override
    public boolean belongTo(Category category) {
        return getBiggerCategory().equals(category);
    }

    @Override
    public String getChineseName() {
        return ChineseName;
    }
}
