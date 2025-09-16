package com.avengers.musinsa.review;

public class Reviews {

    private Long reviewId;

    private Products product;

    private Users user;

    private String nickname;

    private String content;

    private String purchaseOptions;

    private Integer helpCount;

    public String getContent() {
        return content;
    }

    public Integer getHelpCount() {
        return helpCount;
    }

    public String getNickname() {
        return nickname;
    }

    public Products getProduct() {
        return product;
    }

    public String getPurchaseOptions() {
        return purchaseOptions;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public Users getUser() {
        return user;
    }
}
