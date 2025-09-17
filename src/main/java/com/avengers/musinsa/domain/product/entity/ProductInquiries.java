package com.avengers.musinsa.domain.product.entity;

import com.avengers.musinsa.domain.user.entity.Users;
import lombok.Getter;

@Getter
public class ProductInquiries {
    private Integer productInquiryId;

    private Products product;
    private Long productId;

    private Users user;
    private Long userId;


    private String inquiryType;
    private String title;
    private String answerState;
    private String nickName;
    private String content;
}
