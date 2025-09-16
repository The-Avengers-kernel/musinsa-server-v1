package com.avengers.musinsa.product;

public class ProductCategories {
    private Integer productCategoryId;

    private ProductCategories parentProductCategoryId;

    private String categoryName;

    private String categoryImage;

    private Integer level;

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public ProductCategories getParentProductCategoryId() {
        return parentProductCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public Integer getLevel() {
        return level;
    }
}
