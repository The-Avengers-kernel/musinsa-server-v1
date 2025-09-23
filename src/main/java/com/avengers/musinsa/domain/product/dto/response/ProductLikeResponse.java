package com.avengers.musinsa.domain.product.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductLikeResponse {
    private Long productId;
    private Long userId;
    private boolean liked;
}
