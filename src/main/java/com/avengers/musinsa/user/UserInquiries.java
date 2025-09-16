package com.avengers.musinsa.user;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class UserInquiries {
    private Integer userInquiriesId;

    private Users user;
    private Long userId;

    private String title;
    private String content;
    private String inquiriesStatus;
    private String inquiryNumber;
    private Timestamp responseCompletedAt;
}
