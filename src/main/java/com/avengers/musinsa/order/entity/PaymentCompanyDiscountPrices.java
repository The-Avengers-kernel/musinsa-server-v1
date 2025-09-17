package com.avengers.musinsa.order.entity;

import lombok.Getter;

@Getter
public class PaymentCompanyDiscountPrices {
    private Long paymentCompanyDiscountPriceId;

    private PaymentBenefits paymentBenefit;
    private Long paymentBenefitId;

    private Integer DiscountPrice;
}
