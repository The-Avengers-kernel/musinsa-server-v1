package com.avengers.musinsa.order;

public class PaymentCompanyDiscountContractTerms {

    private Long paymentCompanyDiscountContractTermId;

    private PaymentBenefits paymentBenefit;

    private Integer contractTermPrice;

    public Integer getContractTermPrice() {
        return contractTermPrice;
    }

    public PaymentBenefits getPaymentBenefit() {
        return paymentBenefit;
    }

    public Long getPaymentCompanyDiscountContractTermId() {
        return paymentCompanyDiscountContractTermId;
    }
}
