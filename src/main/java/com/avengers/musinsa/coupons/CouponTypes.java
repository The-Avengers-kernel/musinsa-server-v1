package com.avengers.musinsa.coupons;

//쿠폰타입
public class CouponTypes {
    private Integer couponTypeId;
    private Coupons couponId;
    private User userId;
    private String typeCode;
    private String typeName;
    private String applyScope;
    private String discountType;

    public Integer getCouponTypeId() {
        return couponTypeId;
    }

    public Coupons getCouponId() {
        return couponId;
    }

    public User getUserId() {
        return userId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getApplyScope() {
        return applyScope;
    }

    public String getDiscountType() {
        return discountType;
    }
}
