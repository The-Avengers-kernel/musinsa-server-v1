package com.avengers.musinsa.domain.order.entity;

import lombok.Getter;

@Getter
public class PaymentCompanies {
    private Long paymentCompanyId;

    private PaymentBenefits paymentBenefit;
    private Long paymentBenefitId;

    private String name;
}
