package com.avengers.musinsa.domain.order.dto.request;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderCreateRequest {
    private Long userId;
    private Long addressId;
    private Shipping shipping;
    private Payment payment;
    private List<ProductLine> product;

    @Getter
    @AllArgsConstructor
    public static class Shipping {
        private Integer scheduledDeliveryInformationId;
        private Integer deliveryRequestId;
        private Integer shippingStatusId;
        private String recipientName;
        private String recipientPhone;
        private String recipientAddress;
        private String recipientDetailAddress;
        private String shippingDirectRequest;
        private String postalCode;

        // ★ selectKey target
        @lombok.Setter
        private Long shippingId;
    }


    @Getter
    @AllArgsConstructor
    public static class Payment {
        private Integer totalAmount;
        private Integer discountAmount;
        private Integer userOfReward;
        private Integer deliveryFee;
        private Long paymentMethodId;

        @lombok.Setter
        private Long orderId;
    }


    @Getter
    @AllArgsConstructor
    public static class ProductLine {
        private Long productId;
        private Long variantId;
        private Map<String, String> options;
        private Integer price;
        private int quantity;
    }
}
