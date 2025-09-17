package com.avengers.musinsa.domain.order.entity;

import lombok.Getter;

@Getter
public class PaymentBenefits {
    private Long paymentBenefitId;

    private PaymentMethods paymentMethod;
    private Long paymentMethodId;

    private String benefitType;
}
