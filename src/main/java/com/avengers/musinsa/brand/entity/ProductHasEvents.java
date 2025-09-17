package com.avengers.musinsa.brand.entity;

import com.avengers.musinsa.product.entity.Products;
import lombok.Getter;

@Getter
public class ProductHasEvents {
    private Products product;
    private Long brandId;

    private EventHashTags eventHashTagId;
}
