package com.avengers.musinsa.domain.order.service;

import com.avengers.musinsa.async.AsyncOrderHelper;
import com.avengers.musinsa.domain.order.dto.response.UserInfoDTO;

import com.avengers.musinsa.domain.order.dto.request.OrderCreateRequest;
import com.avengers.musinsa.domain.order.dto.request.OrderCreateRequest.ProductLine;
import com.avengers.musinsa.domain.order.dto.response.OrderCreateResponse;
import com.avengers.musinsa.domain.order.repository.OrderRepository;

import java.util.HashMap;
import java.util.List;
import com.avengers.musinsa.domain.order.dto.response.*;
import com.avengers.musinsa.domain.order.entity.Order;
import com.avengers.musinsa.domain.order.repository.OrderRepository;
import com.avengers.musinsa.domain.product.dto.response.ProductVariantDto;
import com.avengers.musinsa.domain.product.repository.ProductVariantRepository;
import com.avengers.musinsa.domain.shipments.dto.ShippingAddressOrderDTO;
import com.avengers.musinsa.domain.user.dto.UserResponseDto;
import com.avengers.musinsa.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductVariantRepository productVariantRepository;
    private final AsyncOrderHelper asyncOrderHelper;

    //주문자 기본정보 조회
    public UserInfoDTO getUserInfo(Long userId) {
        return orderRepository.getUserInfo(userId);
    }


    //주문하기
    @Transactional
    public OrderCreateResponse createOrder(Long userId, OrderCreateRequest request) {
        // 1. Variant 조회 및 설정
        setVariantInfo(request);

        // 2. 주문 생성
        Long shippingId = orderRepository.createShipment(request);
        orderRepository.createOrder(userId, shippingId, request.getPayment());
        Long orderId = request.getPayment().getOrderId();

        // 3. 주문 상품 배치 저장
        orderRepository.batchCreateOrderItems(orderId, request.getProduct(), request.getCouponId());

//        List<OrderCreateRequest.ProductLine> orderProducts = request.getProduct();
//        for (ProductLine orderProduct : orderProducts) {
//
//            orderRepository.createOrderItems(orderId, orderProduct, request.getCouponId());
//
//            // 재고 감소
//            productVariantRepository.decrementStock(orderProduct.getVariantId(), orderProduct.getQuantity());
//
//        }

        // 4. 재고 감소
        productVariantRepository.batchDecrementStock(request.getProduct());

        return new OrderCreateResponse(orderId);
    }

//    private void setVariantInfo(OrderCreateRequest request) {
//        for (ProductLine productLine : request.getProduct()) {
//            ProductVariantDto variant = productVariantRepository.findProductVariantByOptionName(
//                    productLine.getProductId(),
//                    productLine.getOptionName()
//            );
//
//            if (variant == null) {
//                throw new IllegalArgumentException("상품 옵션을 찾을 수 없습니다.");
//            }
//
//            productLine.setVariantId(variant.getProductVariantId());
//            productLine.setOrderItemSize(variant.getSizeValue());
//            productLine.setColor(variant.getColorValue());
//
//            Map<String, String> options = new HashMap<>();
//            options.put("size", variant.getSizeValue());
//            options.put("color", variant.getColorValue());
//            productLine.setOptions(options);
//        }
//    }

    private void setVariantInfo(OrderCreateRequest request) {
        // 배치 조회
        List<ProductVariantDto> variants = productVariantRepository.findProductVariantsByOptionNames(request.getProduct());

        // Map으로 변환 (productId + optionName을 키로)
        Map<String, ProductVariantDto> variantMap = new HashMap<>();
        for (ProductVariantDto variant : variants) {
            String key = variant.getProductId() + "_" + variant.getVariantName();
            variantMap.put(key, variant);
        }

        // 각 상품에 variant 정보 설정
        for (ProductLine productLine : request.getProduct()) {
            String key = productLine.getProductId() + "_" + productLine.getOptionName();
            ProductVariantDto variant = variantMap.get(key);

            if (variant == null) {
                throw new IllegalArgumentException("상품 옵션을 찾을 수 없습니다.");
            }

            productLine.setVariantId(variant.getProductVariantId());
            productLine.setOrderItemSize(variant.getSizeValue());
            productLine.setColor(variant.getColorValue());

            Map<String, String> options = new HashMap<>();
            options.put("size", variant.getSizeValue());
            options.put("color", variant.getColorValue());
            productLine.setOptions(options);
        }
    }
    public OrderSummaryResponse.OrderSummaryDto getCompletionOrderSummary(Long orderId, Long userId) {

        // order 정보 가져오기 - orderCode, orderDate, 가격정보(총 금액, 할인 금액, 배송비, 최종금액)
        Order order = orderRepository.getOrder(orderId);

        System.out.println(order.getRecipientName());
        System.out.println(order.getRecipientPhone());
        System.out.println(order.getPostalCode());
        System.out.println(order.getRecipientAddress());

        // 회원 정보 가져오기(이름, 이메일, 전화번호) - Buyer(이름, 이메일, 폰번호)
        UserResponseDto.UserNameAndEmailAndMobileDto userNameAndEmailAndMobile = userRepository.findUserNameAndEmailAndMobileById(
                userId);

        //주문한 상품 목록 가져오기
        List<OrderDto.OrderItemInfo> orderItems = orderRepository.findOrderItems(orderId);

        //수령인 가져오기
        ShippingAddressDto.shippingAddressDto shippingAddressDto = ShippingAddressDto.shippingAddressDto.builder()
                .recipientName(order.getRecipientName())
                .phone(order.getRecipientPhone())
                .postCode(order.getPostalCode())
                .address(order.getRecipientAddress())
                .build();

        //가격 설정
        PriceInfoDto.priceInfoDto priceInfoDto = PriceInfoDto.priceInfoDto.builder()
                .finalPrice(order.getFinalPrice())
                .orderDiscountAmount(order.getOrderDiscountAmount())
                .shippingFee(order.getShippingFee())
                .totalPrice(order.getTotalPrice())
                .build();

        //반환 Dto 설정
        OrderSummaryResponse.OrderSummaryDto completionOrderSummaryResponse = OrderSummaryResponse.OrderSummaryDto.builder()
                .orderCode(order.getOrderCode())
                .orderDateTime(order.getOrderDateTime())
                .buyerDto(userNameAndEmailAndMobile)
                .orderItemsDto(orderItems)
                .shippingAddressDto(shippingAddressDto)
                .priceInfoDto(priceInfoDto)
                .build();

        return completionOrderSummaryResponse;
    }

    //배송지 목록 조회
    public List<ShippingAddressOrderDTO> getShippingAddressesUserId(Long userId) {
        return orderRepository.getShippingAddressesUserId(userId);
    }

}

