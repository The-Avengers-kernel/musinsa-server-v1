package com.avengers.musinsa.coupons;

import lombok.Getter;

//쿠폰 할인규칙
@Getter
public class CouponDiscountRules {
    private Integer couponDiscountRuleId;
    private Coupons couponId;
    private User userId;
    private  Integer discountPercent;
    private  Integer discountAmount;
    private Integer maxDiscountAmt;


}
