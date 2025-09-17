package com.avengers.musinsa.domain.product.entity;

import lombok.Getter;

@Getter
public class ProductInquiryImages {
    private Integer productInquiryImageId;

    private ProductInquiries productInquiry;
    private Long productInquiryId;

    private String ImageUrl;
}
