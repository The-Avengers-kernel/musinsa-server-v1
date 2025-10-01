package com.avengers.musinsa.test;

import com.avengers.musinsa.domain.order.dto.request.OrderPageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class OrderTestController {

    @PostMapping("/orders-page-debug")
    public ResponseEntity<Map<String, Object>> debugOrderPageRequest(
            @RequestBody OrderPageRequest request,
            @CookieValue(value = "Authorization", required = false) String authorization) {

        Map<String, Object> result = new HashMap<>();

        System.out.println("=== Order Page Request Debug ===");
        System.out.println("Request: " + request);
        System.out.println("Authorization Cookie: " + authorization);
        System.out.println("Request Type: " + request.getType());
        System.out.println("Product ID: " + request.getProductId());
        System.out.println("Quantity: " + request.getQuantity());
        System.out.println("Product Variant ID: " + request.getProductVariantId());
        System.out.println("Option Name: " + request.getOptionName());
        System.out.println("Cart Item IDs: " + request.getCartItemIds());

        result.put("success", true);
        result.put("receivedData", request);
        result.put("authorizationCookie", authorization);

        if (authorization == null || authorization.isEmpty()) {
            result.put("error", "Authorization cookie is missing or empty");
            return ResponseEntity.badRequest().body(result);
        }

        return ResponseEntity.ok(result);
    }
}