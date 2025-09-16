package com.avengers.musinsa.shipments;

//배송비정책
public class ShippingFeePolicies {
    private Integer shippingFeePolicyId;
    private ShippingFees shippingFeeId;
    private ShippingConditions shippingConditionsId;
    private Brand brandId;

    public Integer getShippingFeePolicyId() {
        return shippingFeePolicyId;
    }

    public ShippingFees getShippingFeeId() {
        return shippingFeeId;
    }

    public ShippingConditions getShippingConditionsId() {
        return shippingConditionsId;
    }

    public Brand getBrandId() {
        return brandId;
    }
}
