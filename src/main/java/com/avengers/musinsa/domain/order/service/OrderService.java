package com.avengers.musinsa.domain.order.service;

import com.avengers.musinsa.domain.order.dto.response.*;
import com.avengers.musinsa.domain.order.entity.Order;
import com.avengers.musinsa.domain.order.repository.OrderRepository;
import com.avengers.musinsa.domain.user.dto.UserResponseDto;
import com.avengers.musinsa.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    //주문상품 리스트
    // 상품 하나하나 데이터베이스에서 가져오는 것.
    // 가져와서 상품 하나하나를 리스트에 담는다.
    // 가져온 상품에서 가격을 추출한다음. 해당 가격과 갯수를 곱해서 price 에 값을 누적
    // 최종 반환 객체에, 상품의 리스트와, 누적된 가격을 set 해줌


    public OrderProductResponse getOrderSheetProducts(List<Long> productIds) {
        List<OrderProductDTO> orderProducts = orderRepository.getOrderSheetProducts(productIds);

        // 상품 정보(이미지, 사이즈, 개수, 금액) 추출
        List<OrderProductDTO> orderProductList = new ArrayList<>();
        for (OrderProductDTO dto : orderProducts) {
            orderProductList.add(new OrderProductDTO(
                    dto.getProductId(),
                    dto.getProductName(),
                    dto.getBrand(),
                    dto.getProductImage(),
                    dto.getSize(),
                    dto.getColor(),
                    dto.getMaterial(),
                    dto.getUnitPrice(),
                    dto.getQuantity()
            ));
        }

        //총금액 계산
        Integer totalPrice = orderProductList.stream()
                .mapToInt(p -> p.getUnitPrice() * p.getQuantity())
                .sum();


        return new OrderProductResponse(orderProductList, totalPrice);

    }


}
