package com.avengers.musinsa.domain.product.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductResponseDto {
    private final Long productId;
    private final String productName;
    private final int productLikeCnt;
    private final int price;

    private final Long brandId;
    private final String brandName;
    private final int brandLikeCnt;

    //private final Long productImageId;
    //private final String productImageUrl;

}
