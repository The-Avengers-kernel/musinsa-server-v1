package com.avengers.musinsa.domain.product.entity;

import lombok.Getter;

@Getter
public class ProductCategory {
    private Long productCategoryId;
    private Long parentProductCategoryId;
    private String categoryName;
    private String categoryImage;
    private Integer categoryLevel;
}