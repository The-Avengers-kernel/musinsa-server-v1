package com.avengers.musinsa.domain.product.entity;

import lombok.Getter;

@Getter
public class ProductCategories {
    private Integer productCategoryId;

    private ProductCategories parentProductCategory;
    private Long parentProductCategoryId;

    private String categoryName;
    private String categoryImage;
    private Integer level;
}
