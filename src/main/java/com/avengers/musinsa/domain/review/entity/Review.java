package com.avengers.musinsa.domain.review.entity;

import com.avengers.musinsa.domain.product.entity.Products;
import com.avengers.musinsa.domain.user.entity.User;
import lombok.Getter;

@Getter
public class Reviews {
    private Long reviewId;

    private Products product;
    private Long productId;

    private User user;
    private Long userId;

    private String nickname;
    private String content;
    private String purchaseOptions;
    private Integer helpCount;
}
