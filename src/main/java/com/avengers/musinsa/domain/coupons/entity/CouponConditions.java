package com.avengers.musinsa.domain.coupons.entity;

import com.avengers.musinsa.domain.user.entity.UserGrades;
import com.avengers.musinsa.domain.user.entity.User;
import lombok.Getter;

//쿠폰 조건
@Getter
public class CouponConditions {
    private Integer couponConditionId;

    private UserGrades userGrade;
    private Long userGradeId;

    private User user;
    private Long userId;

    private Coupons coupon;
    private Long couponId;

    private Integer conditionType;
    private Integer minPurchaseAmount;
    private Integer minQuantity;
    private Integer minProductCount;
}
