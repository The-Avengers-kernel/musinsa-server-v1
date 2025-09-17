package com.avengers.musinsa.review.entity;

import com.avengers.musinsa.product.entity.Products;
import com.avengers.musinsa.user.entity.Users;
import lombok.Getter;

@Getter
public class Reviews {
    private Long reviewId;

    private Products product;
    private Long productId;

    private Users user;
    private Long userId;

    private String nickname;
    private String content;
    private String purchaseOptions;
    private Integer helpCount;
}
