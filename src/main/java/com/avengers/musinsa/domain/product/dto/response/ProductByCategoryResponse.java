package com.avengers.musinsa.domain.product.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductByCategoryResponse {
    private String productName;
    private String productImage;
    private String brandName;
    private Integer price;
    private Integer productLikes;
    private Double recommendationScore;
}




