package com.avengers.musinsa.domain.order.controller;


import com.avengers.musinsa.domain.order.dto.response.OrderSummaryResponse;
import com.avengers.musinsa.domain.order.dto.response.UserInfoDTO;
import com.avengers.musinsa.domain.order.service.OrderService;
import com.avengers.musinsa.domain.shipments.dto.ShippingAddressDTO;
import com.avengers.musinsa.domain.user.auth.jwt.TokenProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;
    private final TokenProviderService tokenProviderService;

    //주문화면 접속??
    @GetMapping("/")
    public String orders() {
        return "order";
    }

    //주문자 기본정보 조회
    @GetMapping("/user-info/{userId}")
    public ResponseEntity<UserInfoDTO> getUserInfo(@PathVariable Long userId) {
        UserInfoDTO userInfo = orderService.getUserInfo(userId);

        return ResponseEntity.ok(userInfo);
    }

    // 주문 완료 화면 조회
    @GetMapping("/{orderId}/completion/summary")
    public ResponseEntity<OrderSummaryResponse.OrderSummaryDto> getCompletionOrderSummary(@PathVariable Long orderId, @CookieValue(value = "Authorization") String authorization) {
        Long userId = tokenProviderService.getUserIdFromToken(authorization);
        OrderSummaryResponse.OrderSummaryDto orderSummaryInfo = orderService.getCompletionOrderSummary(orderId, userId);

        return ResponseEntity.ok(orderSummaryInfo);
    }

    //배송지 목록 조회
    @GetMapping("/orders/shipping-addresses/{userId}")
    public ResponseEntity<List<ShippingAddressDTO>> getShippingAddresses(@PathVariable Long userId) {
        List<ShippingAddressDTO> shippingAddresses = orderService.getShippingAddresses(userId);

        return ResponseEntity.ok(shippingAddresses);


    }
}
