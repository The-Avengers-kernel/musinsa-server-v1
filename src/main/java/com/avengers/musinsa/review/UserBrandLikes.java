package com.avengers.musinsa.review;

import com.avengers.musinsa.brand.Brands;
import com.avengers.musinsa.user.Users;
import lombok.Getter;

@Getter
public class UserBrandLikes {
    private Long userBrandLikeId;

    private Brands brand;
    private Long brandId;

    private Users user;
    private Long userId;
}
