package com.avengers.musinsa.domain.order.repository;

import com.avengers.musinsa.domain.order.dto.OrderCompletionInfoDto;
import com.avengers.musinsa.domain.order.dto.response.OrderDto;
import com.avengers.musinsa.domain.order.dto.response.UserInfoDTO;
import com.avengers.musinsa.domain.order.entity.Order;
import com.avengers.musinsa.domain.user.dto.UserResponseDto;
import com.avengers.musinsa.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.eclipse.tags.shaded.org.apache.bcel.generic.ARETURN;
import org.eclipse.tags.shaded.org.apache.bcel.generic.DRETURN;
import org.eclipse.tags.shaded.org.apache.bcel.generic.FRETURN;
import org.eclipse.tags.shaded.org.apache.bcel.generic.IRETURN;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository{
    private final OrderMapper orderMapper;

    //주문자 기본정보 조회
    public UserInfoDTO getUserInfo(Long userId){
        return this.orderMapper.getUserInfo(userId);
    }

    // 완료한 주문 정보 조회
    public Order getOrder(Long orderId) {
        System.out.println("order Id : " + orderId);
        return this.orderMapper.getOrder(orderId);
    }

    @Override
    public List<OrderDto.OrderItemInfo> findOrderItems(Long orderId) {
        return this.orderMapper.findOrderItems(orderId);
    }


}
