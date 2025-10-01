package com.avengers.musinsa.domain.review.dto.Request;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestCreateReview {
    private String content;
    private String purchaseOption;
    private Integer rating;
}
