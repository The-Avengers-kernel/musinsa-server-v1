package com.avengers.musinsa.product.entity;

import lombok.Getter;

@Getter
public class ProductImages {
    private Integer productImageId;

    private Products product;
    private Long productId;

    private String imageType;
    private String imageUrl;
}
