package com.avengers.musinsa.domain.shipments.controller;

import com.avengers.musinsa.domain.shipments.dto.ShippingAddressOrderDTO;
import com.avengers.musinsa.domain.shipments.service.ShippingAddressService;
import com.avengers.musinsa.domain.user.auth.jwt.JWTUtil;
import com.avengers.musinsa.domain.user.auth.jwt.TokenProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ShippingAddressController {
    private final ShippingAddressService shippingAddressService;
    private final TokenProviderService tokenProviderService;
    private final JWTUtil jWTUtil;


    //배송지 목록 조회
    @RequestMapping("/shipping-addresses/{userId}")
    public ResponseEntity<List<ShippingAddressOrderDTO>> getShippingAddressesUserId(@RequestHeader("Authorization") String authorizationHeader){

        /*if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Authorization 헤더가 누락되었거나 형식이 올바르지 않습니다.");
        }*/
        String token = authorizationHeader.replace("Bearer ", "");

        Long userId = tokenProviderService.getUserIdFromToken(token);



        List<ShippingAddressOrderDTO> shippingAddresses = shippingAddressService.getShippingAddressesUserId(userId);

        return ResponseEntity.ok(shippingAddresses);
    }


}

