package com.avengers.musinsa.product;

import lombok.Getter;

@Getter
public class ProductInquiries {
    private Integer productInquiryId;
    private Products productId;
    private User userId;
    private String inquiryType;
    private String title;
    private String answeState;
    private String nickName;
    private String content;
}
