package com.avengers.musinsa.user.entity;

import com.avengers.musinsa.brand.entity.Brands;
import lombok.Getter;

@Getter
public class UserBrandLikes {
    private Long userBrandLikeId;

    private Brands brand;
    private Long brandId;

    private Users user;
    private Long userId;
}
