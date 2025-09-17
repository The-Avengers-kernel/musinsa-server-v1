package com.avengers.musinsa.domain.coupons.entity;

import com.avengers.musinsa.domain.user.entity.User;
import lombok.Getter;

//쿠폰 할인규칙
@Getter
public class CouponDiscountRules {
    private Integer couponDiscountRuleId;

    private Coupons coupon;
    private Long couponId;

    private User user;
    private Long userId;

    private Integer discountPercent;
    private Integer discountAmount;
    private Integer maxDiscountAmount;


}
