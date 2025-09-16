package com.avengers.musinsa.user;

import lombok.Getter;

import java.sql.Timestamp;
@Getter
public class UserMileageHistory {
    private Integer userMileageId;
    private User userId;
    private OrderItems orderItemId;
    private UserMileageType userMileageTypeId;
    private Integer amount;
    private String transactionType;
    private Timestamp earnedAt;
    private Timestamp expiresAt;
}
