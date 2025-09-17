package com.avengers.musinsa.domain.product.entity;

import lombok.Getter;

@Getter
public class ProductImage {
    private Integer productImageId;

    private Product product;
    private Long productId;

    private String imageType;
    private String imageUrl;
}