package com.avengers.musinsa.order;

public class PaymentCompanyDiscountPrices {

    private Long paymentCompanyDiscountPriceId;

    private PaymentBenefits paymentBenefit;

    private Integer DiscountPrice;

    public Integer getDiscountPrice() {
        return DiscountPrice;
    }

    public PaymentBenefits getPaymentBenefit() {
        return paymentBenefit;
    }

    public Long getPaymentCompanyDiscountPriceId() {
        return paymentCompanyDiscountPriceId;
    }
}
