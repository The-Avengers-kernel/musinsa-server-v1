package com.avengers.musinsa.coupons;

import com.avengers.musinsa.domain.user.entity.Users;
import lombok.Getter;

//쿠폰 할인규칙
@Getter
public class CouponDiscountRules {
    private Integer couponDiscountRuleId;

    private Coupons coupon;
    private Long couponId;

    private Users user;
    private Long userId;

    private Integer discountPercent;
    private Integer discountAmount;
    private Integer maxDiscountAmount;


}
