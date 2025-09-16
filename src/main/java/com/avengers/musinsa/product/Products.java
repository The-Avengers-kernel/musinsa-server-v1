package com.avengers.musinsa.product;

import lombok.Getter;

import java.sql.Timestamp;
@Getter
public class Products {
    private Integer productId;
    private Brands brandId;
    private ProductCategory productCategoryId;
    private String productName;
    private String detailImagesUrl;
    private Integer price;
    private Integer productLikes;
    private Timestamp createdAt;
}
