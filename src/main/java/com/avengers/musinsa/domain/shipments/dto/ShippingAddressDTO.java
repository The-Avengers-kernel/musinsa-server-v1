package com.avengers.musinsa.domain.shipments.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class ShippingAddressDTO {

    private Integer shippingId;
    private String recipientName;
    private String recipientPhone;
    private String recipientAddress;
    private Integer postalCode;
    private String detailedAddress;
}
