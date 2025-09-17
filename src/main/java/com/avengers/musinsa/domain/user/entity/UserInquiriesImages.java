package com.avengers.musinsa.domain.user.entity;

import lombok.Getter;

@Getter
public class UserInquiriesImages {
    private Integer userInquiryImageId;

    private UserInquiries userInquiry;
    private Long userInquiryId;

    private String imageUrl;
}

