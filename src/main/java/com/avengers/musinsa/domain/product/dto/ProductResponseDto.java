package com.avengers.musinsa.domain.product.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductResponseDto {
    private final Long productId;
    private final String productName;
    private final int productLikeCnt;
    private final int price;

    private final Long brandId;
    private final String brandName;
    private final int brandLikeCnt;

    private final Long productImageId;
    private final String productImageUrl;

    @Builder
    public ProductResponseDto(Long productId, String productName, int productLikeCnt, int price,
                              Long brandId, String brandName, int brandLikeCnt,
                              Long productImageId, String productImageUrl) {
        this.productId = productId;
        this.productName = productName;
        this.productLikeCnt = productLikeCnt;
        this.price = price;
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandLikeCnt = brandLikeCnt;
        this.productImageId = productImageId;
        this.productImageUrl = productImageUrl;
    }
}
