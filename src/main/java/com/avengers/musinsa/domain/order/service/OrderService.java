package com.avengers.musinsa.domain.order.service;

import com.avengers.musinsa.domain.order.dto.response.*;
import com.avengers.musinsa.domain.order.entity.Order;
import com.avengers.musinsa.domain.order.repository.OrderRepository;
import com.avengers.musinsa.domain.shipments.dto.ShippingAddressOrderDTO;
import com.avengers.musinsa.domain.user.dto.UserResponseDto;
import com.avengers.musinsa.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    //주문자 기본정보 조회
    public UserInfoDTO getUserInfo(Long userId) {
       return orderRepository.getUserInfo(userId);
    }

    public OrderSummaryResponse.OrderSummaryDto getCompletionOrderSummary(Long orderId, Long userId) {

        // order 정보 가져오기 - orderCode, orderDate, 가격정보(총 금액, 할인 금액, 배송비, 최종금액)
        Order order = orderRepository.getOrder(orderId);

        // 회원 정보 가져오기(이름, 이메일, 전화번호) - Buyer(이름, 이메일, 폰번호)
        UserResponseDto.UserNameAndEmailAndMobileDto userNameAndEmailAndMobile = userRepository.findUserNameAndEmailAndMobileById(userId);


        //주문한 상품 목록 가져오기
        List<OrderDto.OrderItemInfo> orderItems = orderRepository.findOrderItems(orderId);

        //수령인 가져오기
        ShippingAddressDto.shippingAddressDto shippingAddressDto = ShippingAddressDto.shippingAddressDto.builder()
                .recipientName(order.getRecipientName())
                .phone(order.getRecipientPhone())
                .postCode(order.getPostCode())
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
