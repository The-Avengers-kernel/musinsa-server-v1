package com.avengers.musinsa.domain.product.entity;

import lombok.Getter;

@Getter
public class ProductVariants {
    private Integer productVariantId;

    private Products product;
    private Long productId;

    private String skuCode;
    private String variantName;
    private Integer price;
    private Integer stockQuantity;
    private String sizeValue;
    private String colorValue;
    private String materialValue;
    private Integer extraPrice;
}
