package com.avengers.musinsa.product.entity;

import lombok.Getter;

@Getter
public class ProductOptionTypes {
    private Integer productOptionTypeId;

    private Products product;
    private Long productId;

    private OptionTypes optionType;
    private Long optionTypeId;

    private Integer displayOrder;
}
