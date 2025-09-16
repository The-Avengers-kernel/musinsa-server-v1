package com.avengers.musinsa.review;

import lombok.Getter;

@Getter
public class Comments {
    private Long commentId;
    private Reviews review;
    private String nickName;
    private String content;
    }
}
