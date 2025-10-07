package com.avengers.musinsa.order.service;


import com.avengers.musinsa.domain.order.dto.request.OrderCreateRequest;
import com.avengers.musinsa.domain.order.dto.request.OrderCreateRequest.ProductLine;
import com.avengers.musinsa.domain.order.repository.OrderRepository;
import com.avengers.musinsa.domain.order.service.OrderService;
import com.avengers.musinsa.domain.product.dto.response.ProductVariantDto;
import com.avengers.musinsa.domain.product.repository.ProductVariantRepository;
import com.avengers.musinsa.domain.product.service.ProductVariantService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.*;

@SpringBootTest
@Transactional
//@Sql(scripts = "/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class OrderServicePerformanceTest{

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductVariantService productVariantService;

    @Autowired
    private ProductVariantRepository productVariantRepository;
    @Test
    @DisplayName("장바구니에서 주문 - 1000번 반복 시 createOrder와 createOrderItems 총 시간 측정")
    void measureCartOrderMethodExecutionTimes() {
        int iterations = 10000;

        long totalCreateOrderTime = 0;
        long totalCreateOrderItemsTime = 0;

        double totalOrderStart = System.currentTimeMillis();

        for (int i = 0; i < iterations; i++) {
            Long userId = 1L;

            // 장바구니에서 주문하는 경우의 request 생성
            OrderCreateRequest request = createCartOrderRequest(userId);

            // Shipment 생성 (측정 제외)
            Long shippingId = orderRepository.createShipment(request);

            // ★ createOrder 메서드 시간 측정
            long orderStart = System.currentTimeMillis();
            orderRepository.createOrder(userId, shippingId, request.getPayment());
            long orderEnd = System.currentTimeMillis();
            totalCreateOrderTime += (orderEnd - orderStart);

            Long orderId = request.getPayment().getOrderId();

            // ★ createOrderItems + 재고감소 시간 측정
            for (ProductLine orderProduct : request.getProduct()) {
                long itemStart = System.currentTimeMillis();

                // createOrderItems
                orderRepository.createOrderItems(orderId, orderProduct, request.getCouponId());

                // 재고 감소
                productVariantRepository.decrementStock(orderProduct.getVariantId(), orderProduct.getQuantity());

                long itemEnd = System.currentTimeMillis();
                totalCreateOrderItemsTime += (itemEnd - itemStart);
            }
        }

        double totalOrderEnd = System.currentTimeMillis();

        System.out.println("\n========== 장바구니 주문 1000번 반복 측정 결과 ==========");
        System.out.println("createOrder 총 시간: " + totalCreateOrderTime + "ms");
        System.out.println();
        System.out.println("createOrderItems + 재고감소 총 시간: " + totalCreateOrderItemsTime + "ms");
        System.out.println();
        System.out.println("totalOrderTime + 주문처리 총 시간: " + (totalOrderEnd - totalOrderStart) + "ms");
        System.out.println("========================================================\n");
    }

    private OrderCreateRequest createCartOrderRequest(Long userId) {
        OrderCreateRequest request = new OrderCreateRequest();
        request.setUserId(userId);
        request.setAddressId(1L);
        request.setCouponId(null);

        // Shipping 정보
        OrderCreateRequest.Shipping shipping = new OrderCreateRequest.Shipping();
        shipping.setRecipientName("홍길동");
        shipping.setRecipientPhone("010-1234-5678");
        shipping.setRecipientAddress("서울시 강남구 테헤란로 123");
        shipping.setShippingDirectRequest("문 앞에 놓아주세요");
        shipping.setPostalCode("12345");
        request.setShipping(shipping);

        // Payment 정보
        OrderCreateRequest.Payment payment = new OrderCreateRequest.Payment();
        payment.setTotalAmount(100000);
        payment.setDiscountAmount(0);
        payment.setUserOfReward(0);
        payment.setDeliveryFee(3000);
        payment.setPaymentMethodId(1L);
        request.setPayment(payment);

        // 실제 DB의 cart_item에서 product 정보 조회
        // cartItemIds [1, 3, 5]에 해당하는 상품들을 가져온다고 가정
        List<ProductLine> products = new ArrayList<>();

        // 실제로는 CartRepository에서 조회해야 하지만,
        // 테스트를 위해 직접 ProductLine 생성
        List<Long> cartItemIds = Arrays.asList(1L, 3L, 5L, 10L, 11L, 13L, 15L, 16L,18L, 20L);

        for (Long cartItemId : cartItemIds) {
            // 실제 구현에서는 cartRepository.findById(cartItemId)로 조회
            // 여기서는 테스트를 위해 임의의 상품 데이터 생성
            ProductLine productLine = new ProductLine();
            productLine.setProductId(59999L); // 실제 DB에 존재하는 product_id
            productLine.setVariantId(3L); // 나중에 조회해서 설정
            productLine.setFinalPrice(30000);
            productLine.setOptionName("Red / S"); // 실제 옵션명으로 변경 필요
            productLine.setDiscountRate(0);
            productLine.setQuantity(3);
            productLine.setProductDiscountAmount(0);

            products.add(productLine);
        }

        request.setProduct(products);

        // Variant 조회 및 설정
        for (ProductLine productLine : products) {
            ProductVariantDto variant = productVariantService.findProductVariantByOptionName(
                    productLine.getProductId(),
                    productLine.getOptionName()
            );

            if (variant != null) {
                productLine.setVariantId(variant.getProductVariantId());
                productLine.setOrderItemSize(variant.getSizeValue());
                productLine.setColor(variant.getColorValue());

                Map<String, String> options = new HashMap<>();
                options.put("size", variant.getSizeValue());
                options.put("color", variant.getColorValue());
                productLine.setOptions(options);
            }
        }

        return request;
    }
}