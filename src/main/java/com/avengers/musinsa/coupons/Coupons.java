package com.avengers.musinsa.coupons;

import java.util.Date;

//쿠폰
public class Coupons {
    private Integer couponId;
    private User userId;
    private Brands brandId;
    private String couponName;
    private String couponCode;
    private String description;
    private Date startDate;
    private Date endDate;
    private char isStackable;

    public Integer getCouponId() {
        return couponId;
    }

    public User getUserId() {
        return userId;
    }

    public Brands getBrandId() {
        return brandId;
    }

    public String getCouponName() {
        return couponName;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public char getIsStackable() {
        return isStackable;
    }
}
