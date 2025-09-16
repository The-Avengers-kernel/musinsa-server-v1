package com.avengers.musinsa.shipments;

import com.avengers.musinsa.brand.Brands;
import lombok.Getter;

//배송비정책
@Getter
public class ShippingFeePolicies {
    private Integer shippingFeePolicyId;

    private ShippingFees shippingFee;
    private Long shippingFeeId;

    private ShippingFeeConditions shippingFeeCondition;
    private Long shippingFeeConditionId;

    private Brands brand;
    private Long brandId;

}
