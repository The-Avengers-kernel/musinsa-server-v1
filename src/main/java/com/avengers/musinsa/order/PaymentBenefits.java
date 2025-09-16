package com.avengers.musinsa.order;

import lombok.Getter;

@Getter
public class PaymentBenefits {
    private Long paymentBenefitId;
    private PaymentMethods paymentMethod;
    private String benefitType;
}
