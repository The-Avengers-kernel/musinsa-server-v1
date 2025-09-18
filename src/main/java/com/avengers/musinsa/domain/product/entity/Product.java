package com.avengers.musinsa.domain.product.entity;

import com.avengers.musinsa.domain.brand.entity.Brand;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Product {
    private Integer productId;

    private Brand brand;
    private Long brandId;

    private ProductCategory productCategory;
    private Long productCategoryId;

    private String productName;
    private String detailImageUrl;
    private Integer price;
    private Gender gender;
    private Integer productLikes;
    private Timestamp createdAt;
}