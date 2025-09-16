package com.avengers.musinsa.review;

public class Comments {

    private Long commentId;

    private Reviews review;

    private String nickName;

    private String content;

    public Long getCommentId() {
        return commentId;
    }

    public String getContent() {
        return content;
    }

    public String getNickName() {
        return nickName;
    }

    public Reviews getReview() {
        return review;
    }
}
