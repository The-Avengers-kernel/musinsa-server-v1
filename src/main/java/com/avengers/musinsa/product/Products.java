package com.avengers.musinsa.product;

import java.sql.Timestamp;

public class Products {
    private Integer productId;

    private Brands brandId;

    private ProductCategory productCategoryId;

    private String productName;

    private String detailImagesUrl;

    private Integer price;

    private Integer productLikes;

    private Timestamp createdAt;

    public Integer getProductId() {
        return productId;
    }

    public Brands getBrandId() {
        return brandId;
    }

    public ProductCategory getProductCategoryId() {
        return productCategoryId;
    }

    public String getProductName() {
        return productName;
    }

    public String getDetailImagesUrl() {
        return detailImagesUrl;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getProductLikes() {
        return productLikes;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}
