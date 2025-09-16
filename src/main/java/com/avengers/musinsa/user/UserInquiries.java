package com.avengers.musinsa.user;

import java.sql.Timestamp;

public class UserInquiries {
    private Integer userInquiriesId;

    private User userId;

    private String title;

    private String content;

    private String inquiriesStatus;

    private String inquiryNumber;

    private Timestamp responseCompletedAt;

    public Integer getUserInquiriesId() {
        return userInquiriesId;
    }

    public User getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getInquiriesStatus() {
        return inquiriesStatus;
    }

    public String getInquiryNumber() {
        return inquiryNumber;
    }

    public Timestamp getResponseCompletedAt() {
        return responseCompletedAt;
    }
}
