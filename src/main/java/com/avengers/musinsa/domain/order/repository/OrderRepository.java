package com.avengers.musinsa.domain.order.repository;
import com.avengers.musinsa.domain.order.dto.response.OrderDto;
import com.avengers.musinsa.domain.order.dto.response.UserInfoDTO;
import com.avengers.musinsa.domain.order.entity.Order;
import com.avengers.musinsa.domain.shipments.dto.ShippingAddressOrderDTO;
import java.util.List;

public interface OrderRepository {
    public UserInfoDTO getUserInfo(Long userId);
    public Order getOrder(Long orderId);
    public List<OrderDto.OrderItemInfo> findOrderItems(Long orderId);
    List<ShippingAddressOrderDTO> getShippingAddressesUserId(Long userId);
  
    public void createOrderItems(Long orderId, ProductLine orderProduct) {
        orderMapper.createOrderItems(orderId, orderProduct);
    }
}
