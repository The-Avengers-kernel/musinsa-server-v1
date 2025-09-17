package com.avengers.musinsa.domain.brand.entity;

import com.avengers.musinsa.domain.product.entity.Products;
import lombok.Getter;

@Getter
public class ProductHasEvents {
    private Products product;
    private Long brandId;

    private EventHashTags eventHashTagId;
}
