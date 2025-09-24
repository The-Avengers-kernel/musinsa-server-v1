package com.avengers.musinsa.domain.order.controller;


import com.avengers.musinsa.domain.order.dto.UserInfoDTO;
import com.avengers.musinsa.domain.order.dto.request.OrderCreateRequest;
import com.avengers.musinsa.domain.order.dto.response.OrderCreateResponse;
import com.avengers.musinsa.domain.order.dto.response.OrderSummaryResponse;
import com.avengers.musinsa.domain.order.dto.response.UserInfoDTO;
import com.avengers.musinsa.domain.order.service.OrderService;
import com.avengers.musinsa.domain.shipments.dto.ShippingAddressOrderDTO;
import com.avengers.musinsa.domain.user.auth.jwt.TokenProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/user-info/{userId}")
    public ResponseEntity<UserInfoDTO> getUserInfo(@PathVariable Long userId) {
        UserInfoDTO userInfo = orderService.getUserInfo(userId);

        return ResponseEntity.ok(userInfo);
    }

    //주문하기
    @PostMapping("/{userId}/order")
    public ResponseEntity<OrderCreateResponse> createOrder(@PathVariable Long userId,
                                                           @RequestBody OrderCreateRequest orderCreateRequest) {
        OrderCreateResponse orderCreateResponse = orderService.createOrder(userId, orderCreateRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(orderCreateResponse);

      // 주문 완료 화면 조회
    @GetMapping("/{orderId}/completion/summary")
    public ResponseEntity<OrderSummaryResponse.OrderSummaryDto> getCompletionOrderSummary(@PathVariable Long orderId, @CookieValue(value = "Authorization") String authorization) {
        Long userId = tokenProviderService.getUserIdFromToken(authorization);
        OrderSummaryResponse.OrderSummaryDto orderSummaryInfo = orderService.getCompletionOrderSummary(orderId, userId);

        return ResponseEntity.ok(orderSummaryInfo);
    }

    //배송지 목록 조회
    @GetMapping("/address-list/{userId}")
    public ResponseEntity<List<ShippingAddressOrderDTO>> getShippingAddressesUserId(@PathVariable Long userId) {
        List<ShippingAddressOrderDTO> shippingAddresses = orderService.getShippingAddressesUserId(userId);

        return ResponseEntity.ok(shippingAddresses);

    }
}
