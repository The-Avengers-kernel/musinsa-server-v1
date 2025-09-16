package com.avengers.musinsa.coupons;

import lombok.Getter;

//쿠폰타입
@Getter
public class CouponTypes {
    private Integer couponTypeId;
    private Coupons couponId;
    private User userId;
    private String typeCode;
    private String typeName;
    private String applyScope;
    private String discountType;

}
