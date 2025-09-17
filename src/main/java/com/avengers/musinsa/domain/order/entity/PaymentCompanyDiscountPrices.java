package com.avengers.musinsa.domain.order.entity;

import lombok.Getter;

@Getter
public class PaymentCompanyDiscountPrices {
    private Long paymentCompanyDiscountPriceId;

    private PaymentBenefits paymentBenefit;
    private Long paymentBenefitId;

    private Integer DiscountPrice;
}
