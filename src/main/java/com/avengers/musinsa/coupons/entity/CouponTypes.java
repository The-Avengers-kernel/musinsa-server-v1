package com.avengers.musinsa.coupons.entity;

import com.avengers.musinsa.user.entity.Users;
import lombok.Getter;

//쿠폰타입
@Getter
public class CouponTypes {
    private Integer couponTypeId;

    private Coupons coupon;
    private Long couponId;

    private Users user;
    private Long userId;

    private String typeCode;
    private String typeName;
    private String applyScope;
    private String discountType;

}
