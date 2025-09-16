package com.avengers.musinsa.order;

public class PaymentCompanies {

    private Long paymentCompanyId;

    private PaymentBenefits paymentBenefit;

    private String name;

    public String getName() {
        return name;
    }

    public PaymentBenefits getPaymentBenefit() {
        return paymentBenefit;
    }

    public Long getPaymentCompanyId() {
        return paymentCompanyId;
    }
}
