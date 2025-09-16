package com.avengers.musinsa.user;

import java.sql.Timestamp;

public class UserMileageHistory {
    private Integer userMileageId;

    private User userId;

    private OrderItems orderItemId;

    private UserMileageType userMileageTypeId;

    private Integer amount;

    private String transactionType;

    private Timestamp earnedAt;

    private Timestamp expiresAt;

    public Integer getUserMileageId() {
        return userMileageId;
    }

    public User getUserId() {
        return userId;
    }

    public OrderItems getOrderItemId() {
        return orderItemId;
    }

    public UserMileageType getUserMileageTypeId() {
        return userMileageTypeId;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public Timestamp getEarnedAt() {
        return earnedAt;
    }

    public Timestamp getExpiresAt() {
        return expiresAt;
    }
}
