//package com.avengers.musinsa.domain.shipments.controller;
//
//import com.avengers.musinsa.domain.shipments.dto.ShippingAddressOrderDTO;
//import com.avengers.musinsa.domain.shipments.service.ShippingAddressService;
//import com.avengers.musinsa.domain.user.auth.jwt.JWTUtil;
//import com.avengers.musinsa.domain.user.auth.jwt.TokenProviderService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1")
//public class ShippingAddressController {
//    private final ShippingAddressService shippingAddressService;
//    private final TokenProviderService tokenProviderService;
//    private final JWTUtil jWTUtil;
//
//    // 배송지 목록 조회 (userId를 PathVariable로 받도록 수정)
//    @GetMapping("/orders/address-list")
//    public ResponseEntity<List<ShippingAddressOrderDTO>> getShippingAddressesUserId(
//            @RequestHeader(value = "Authorization", required = false) String authorizationHeader) {
//
//        Long userId = null;
//        try {
//            // 토큰 검증 (필요한 경우)
//            if (authorizationHeader != null && !authorizationHeader.isEmpty()) {
//                userId = tokenProviderService.getUserIdFromToken(authorizationHeader);
//
//            }
//
//            List<ShippingAddressOrderDTO> shippingAddresses =
//                    shippingAddressService.getShippingAddressesUserId(userId);
//
//            return ResponseEntity.ok(shippingAddresses);
//
//        } catch (Exception e) {
//            return ResponseEntity.status(500).build();
//        }
//    }
//}
