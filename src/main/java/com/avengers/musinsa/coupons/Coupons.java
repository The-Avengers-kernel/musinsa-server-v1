package com.avengers.musinsa.coupons;

import lombok.Getter;

import java.util.Date;

//쿠폰
@Getter
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

}
