package com.avengers.musinsa.viewController;

import com.avengers.musinsa.domain.order.dto.request.OrderCreateRequest;
import com.avengers.musinsa.domain.order.dto.response.OrderCreateResponse;
import com.avengers.musinsa.domain.order.dto.response.OrderSummaryResponse;
import com.avengers.musinsa.domain.order.service.OrderService;
import com.avengers.musinsa.domain.product.dto.response.ProductVariantDto;
import com.avengers.musinsa.domain.product.service.ProductVariantService;
import com.avengers.musinsa.domain.user.auth.jwt.TokenProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderViewController {

    private final TokenProviderService tokenProviderService;
    private final OrderService orderService;
    private final ProductVariantService productVariantService;

    @PostMapping("/completion-order")
    public ResponseEntity<OrderCreateResponse> createOrder(@RequestBody OrderCreateRequest request,
                                                           @CookieValue(value = "Authorization", required = false) String authorization,
                                                           Model model){
        Long userId = tokenProviderService.getUserIdFromToken(authorization);

        //관련된 정보들 세팅
        request.setUserId(userId);

        // variantId 와 옵션 세팅
        for(OrderCreateRequest.ProductLine productLine : request.getProduct()){
            System.out.println("productId = " + productLine.getProductId() + " optionName = " + productLine.getOptionName());

            ProductVariantDto variant = productVariantService.findProductVariantByOptionName(
                    productLine.getProductId(),
                    productLine.getOptionName()
            );

            if (variant == null) {
                throw new IllegalArgumentException(
                    "상품 옵션을 찾을 수 없습니다. productId: " + productLine.getProductId() +
                    ", optionName: " + productLine.getOptionName()
                );
            }

            Long variantId = variant.getProductVariantId();
            productLine.setVariantId(variantId);

            // HashMap 생성 후 설정
            HashMap<String, String> options = new HashMap<>();
            options.put("size", variant.getSizeValue());
            productLine.setOrderItemSize(variant.getSizeValue());
            options.put("color", variant.getColorValue());
            productLine.setColor(variant.getColorValue());
            productLine.setOptions(options);  // ← 생성한 Map을 설정
        }

        OrderCreateResponse orderCreateResponse = orderService.createOrder(userId, request);
        System.out.println("생성된 주문 ID: " + orderCreateResponse.getOrderId());
        System.out.println("응답 객체: " + orderCreateResponse);

        return ResponseEntity.ok(orderCreateResponse);

    }


    @GetMapping("/order-complete/{orderId}")
    public String complete(@PathVariable Long orderId,
                           @CookieValue(value = "Authorization", required = false) String auth,
                           Model model) {
        System.out.println("리다이랙트가 됨");
        Long userId = tokenProviderService.getUserIdFromToken(auth);
        OrderSummaryResponse.OrderSummaryDto response = orderService.getCompletionOrderSummary(orderId, userId);
        model.addAttribute("orderData", response);
        return "order/orderCompletePage";
    }



}
