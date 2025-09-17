package com.avengers.musinsa.product.entity;

import lombok.Getter;

@Getter
public class ProductConnectionTags {
    private Integer productConnectionTagId;

    private Products product;
    private Long productId;

    private String tagName;
}
