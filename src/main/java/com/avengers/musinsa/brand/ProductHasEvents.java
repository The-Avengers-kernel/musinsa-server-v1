package com.avengers.musinsa.brand;

import com.avengers.musinsa.product.Products;
import lombok.Getter;

@Getter
public class ProductHasEvents {
    private Products product;
    private Long brandId;

    private EventHashTags eventHashTagId;
}
