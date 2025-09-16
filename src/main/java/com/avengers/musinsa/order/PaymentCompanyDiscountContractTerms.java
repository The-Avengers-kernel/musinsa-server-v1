package com.avengers.musinsa.order;

import lombok.Getter;

@Getter
public class PaymentCompanyDiscountContractTerms {
    private Long paymentCompanyDiscountContractTermId;

    private PaymentBenefits paymentBenefit;
    private Long paymentBenefitId;

    private Integer contractTermPrice;
}
