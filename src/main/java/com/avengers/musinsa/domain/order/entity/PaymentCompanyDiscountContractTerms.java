package com.avengers.musinsa.domain.order.entity;

import lombok.Getter;

@Getter
public class PaymentCompanyDiscountContractTerms {
    private Long paymentCompanyDiscountContractTermId;

    private PaymentBenefits paymentBenefit;
    private Long paymentBenefitId;

    private Integer contractTermPrice;
}
