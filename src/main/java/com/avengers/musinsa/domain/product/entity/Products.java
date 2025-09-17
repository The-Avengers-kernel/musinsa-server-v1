package com.avengers.musinsa.domain.product.entity;

import com.avengers.musinsa.domain.brand.entity.Brands;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Products {
    private Integer productId;

    private Brands brand;
    private Long brandId;

    private ProductCategories productCategory;
    private Long productCategoryId;

    private String productName;
    private String detailImageUrl;
    private Integer price;
    private Integer productLikes;
    private Timestamp createdAt;
}
