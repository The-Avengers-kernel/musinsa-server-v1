package com.avengers.musinsa.product;

import lombok.Getter;

@Getter
public class ProductCategories {
    private Integer productCategoryId;
    private ProductCategories parentProductCategoryId;
    private String categoryName;
    private String categoryImage;
    private Integer level;
}
