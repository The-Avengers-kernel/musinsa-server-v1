package com.avengers.musinsa.order;

import lombok.Getter;

@Getter
public class PaymentCompanies {
    private Long paymentCompanyId;

    private PaymentBenefits paymentBenefit;
    private Long paymentBenefitId;

    private String name;
}
