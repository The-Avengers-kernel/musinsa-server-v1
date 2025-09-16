package com.avengers.musinsa.coupons;

//쿠폰 할인규칙
public class CouponDiscountRules {
    private Integer couponDiscountRuleId;
    private Coupons couponId;
    private User userId;
    private  Integer discountPercent;
    private  Integer discountAmount;
    private Integer maxDiscountAmt;

    public Integer getCouponDiscountRuleId() {
        return couponDiscountRuleId;
    }

    public Coupons getCouponId() {
        return couponId;
    }

    public User getUserId() {
        return userId;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public Integer getMaxDiscountAmt() {
        return maxDiscountAmt;
    }
}
