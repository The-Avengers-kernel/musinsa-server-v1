package com.avengers.musinsa.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewMeta {
    private Long productId;
    private Integer rating;
}
