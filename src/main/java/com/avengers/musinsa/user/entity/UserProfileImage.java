package com.avengers.musinsa.user.entity;

import lombok.Getter;

@Getter
public class UserProfileImage {
    private Integer userProfileImageId;

    private Users user;
    private Long userId;

    private String profileImageUrl;
}
