package com.avengers.musinsa.review;

import java.sql.Timestamp;

public class ProductReviewStats {

    private Long ProductRatingStatId;

    private Reviews review;

    private Integer reviewCount;

    private Integer totalReviews;

    private Integer ratingAvg;

    // 여기 애매함 컬럼 이름은 집계일자임
    private Timestamp updateAt;

    public Long getProductRatingStatId() {
        return ProductRatingStatId;
    }

    public Integer getRatingAvg() {
        return ratingAvg;
    }

    public Reviews getReview() {
        return review;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public Integer getTotalReviews() {
        return totalReviews;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }
}
