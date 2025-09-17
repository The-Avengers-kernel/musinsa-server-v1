package com.avengers.musinsa.review;

import lombok.Getter;

@Getter
public class Comments {
    private Long commentId;

    private Reviews review;
    private Long reviewId;

    private String nickName;
    private String content;
}

