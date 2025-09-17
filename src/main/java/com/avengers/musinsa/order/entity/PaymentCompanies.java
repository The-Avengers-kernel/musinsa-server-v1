package com.avengers.musinsa.order.entity;

import lombok.Getter;

@Getter
public class PaymentCompanies {
    private Long paymentCompanyId;

    private PaymentBenefits paymentBenefit;
    private Long paymentBenefitId;

    private String name;
}
