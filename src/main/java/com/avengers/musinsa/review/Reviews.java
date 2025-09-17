package com.avengers.musinsa.review;

import com.avengers.musinsa.product.Products;
import com.avengers.musinsa.user.Users;
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
