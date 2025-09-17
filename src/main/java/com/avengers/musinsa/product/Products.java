package com.avengers.musinsa.product;

import com.avengers.musinsa.brand.Brands;
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
