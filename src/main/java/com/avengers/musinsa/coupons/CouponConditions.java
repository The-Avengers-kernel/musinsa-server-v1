package com.avengers.musinsa.coupons;

//쿠폰 조건
public class CouponConditions {
    private Integer couponConditionId;
    private UserGrades gradeId;
    private User userId;
    private Coupons couponId;
    private Integer conditionType;
    private Integer minPurchaseAmount;
    private Integer minQuantity;
    private Integer minProductCount;

    public Integer getCouponConditionId() {
        return couponConditionId;
    }

    public UserGrades getGradeId() {
        return gradeId;
    }

    public User getUserId() {
        return userId;
    }

    public Coupons getCouponId() {
        return couponId;
    }

    public Integer getConditionType() {
        return conditionType;
    }

    public Integer getMinPurchaseAmount() {
        return minPurchaseAmount;
    }

    public Integer getMinQuantity() {
        return minQuantity;
    }

    public Integer getMinProductCount() {
        return minProductCount;
    }
}
