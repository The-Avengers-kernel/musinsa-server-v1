package com.avengers.musinsa.coupons;

import com.avengers.musinsa.brand.Brands;
import com.avengers.musinsa.domain.user.entity.Users;
import lombok.Getter;

import java.util.Date;

//쿠폰
@Getter
public class Coupons {
    private Integer couponId;

    private Users user;
    private Long userId;

    private Brands brand;
    private Long brandId;

    private String couponName;
    private String couponCode;
    private String description;
    private Date startDate;
    private Date endDate;
    private char isStackable;

}
