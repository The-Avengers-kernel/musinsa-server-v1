package com.avengers.musinsa.domain.shipments.controller;

import com.avengers.musinsa.domain.shipments.dto.ShippingAddressDTO;
import com.avengers.musinsa.domain.shipments.service.ShippingAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ShippingAddressController {
    private final ShippingAddressService shippingAddressService;

    //배송지 목록 조회
    @RequestMapping("/shipping-addresses/{userId}")
    public ResponseEntity<List<ShippingAddressDTO>> getShippingAddresses(@PathVariable Long userId){
        List<ShippingAddressDTO> shippingAddresses = shippingAddressService.getShippingAddresses(userId);

        return ResponseEntity.ok(shippingAddresses);
    }


}
