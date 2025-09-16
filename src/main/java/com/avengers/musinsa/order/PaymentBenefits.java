package com.avengers.musinsa.order;

public class PaymentBenefits {

    private Long paymentBenefitId;

    private PaymentMethods paymentMethod;

    private String benefitType;

    public String getBenefitType() {
        return benefitType;
    }

    public Long getPaymentBenefitId() {
        return paymentBenefitId;
    }

    public PaymentMethods getPaymentMethod() {
        return paymentMethod;
    }
}
