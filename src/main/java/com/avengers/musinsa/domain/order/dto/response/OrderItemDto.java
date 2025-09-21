package com.avengers.musinsa.domain.order.dto.response;

import org.apache.jasper.Options;

import javax.swing.text.html.Option;

public class OrderItemDto {
    private Long productId;
    private String productName;
    private String brandName;
    private Integer quantity;
    private Integer unitPrice;
    private Integer discountRate;
    private Integer discountAmount;
    private Integer totalPrice ;
    private OptionsDto options;
}
