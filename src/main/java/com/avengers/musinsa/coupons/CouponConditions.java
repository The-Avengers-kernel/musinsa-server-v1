package com.avengers.musinsa.coupons;

import lombok.Getter;

//쿠폰 조건
@Getter
public class CouponConditions {
    private Integer couponConditionId;
    private UserGrades gradeId;
    private User userId;
    private Coupons couponId;
    private Integer conditionType;
    private Integer minPurchaseAmount;
    private Integer minQuantity;
    private Integer minProductCount;
}
