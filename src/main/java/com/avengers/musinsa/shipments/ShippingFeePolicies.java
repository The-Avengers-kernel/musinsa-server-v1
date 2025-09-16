package com.avengers.musinsa.shipments;

import lombok.Getter;

//배송비정책
@Getter
public class ShippingFeePolicies {
    private Integer shippingFeePolicyId;
    private ShippingFees shippingFeeId;
    private ShippingConditions shippingConditionsId;
    private Brand brandId;


}
