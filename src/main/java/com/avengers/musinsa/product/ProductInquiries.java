package com.avengers.musinsa.product;

public class ProductInquiries {
    private Integer productInquiryId;

    private Products productId;

    private User userId;

    private String inquiryType;

    private String title;

    private String answeState;

    private String nickName;

    private String content;

    public Integer getProductInquiryId() {
        return productInquiryId;
    }

    public Products getProductId() {
        return productId;
    }

    public User getUserId() {
        return userId;
    }

    public String getInquiryType() {
        return inquiryType;
    }

    public String getTitle() {
        return title;
    }

    public String getAnsweState() {
        return answeState;
    }

    public String getNickName() {
        return nickName;
    }

    public String getContent() {
        return content;
    }
}
