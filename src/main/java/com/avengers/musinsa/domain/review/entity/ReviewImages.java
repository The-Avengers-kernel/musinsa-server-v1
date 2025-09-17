package com.avengers.musinsa.domain.review.entity;

import lombok.Getter;

@Getter
public class ReviewImages {
    private Long reviewImageId;

    private Reviews reviews;
    private Long reviewId;

    private String imagesUrl;
}
