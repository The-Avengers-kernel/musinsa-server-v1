package com.avengers.musinsa.domain.order.mapper;

import com.avengers.musinsa.domain.order.dto.response.OrderDto;
import com.avengers.musinsa.mapper.OrderMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@ActiveProfiles("test")
class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    @DisplayName("getOrderItemInfoTest - orderId로 주문 상품 조회")
    void getOrderItemInfoTest() {
        // Given
        Long orderId = 20001L;

        // When
        List<OrderDto.OrderItemInfoTest> result = orderMapper.getOrderItemInfoTest(orderId);

        // Then
        System.out.println("조회된 아이템 개수: " + result.size());

        if (!result.isEmpty()) {
            OrderDto.OrderItemInfoTest firstItem = result.get(0);
            System.out.println("첫 번째 아이템: " + firstItem.toString());

            // 필수 필드 검증
            assertNotNull(firstItem.getProductId(), "productId는 null이 아니어야 합니다");
            assertNotNull(firstItem.getOrderId(), "orderId는 null이 아니어야 합니다");
            assertEquals(orderId, firstItem.getOrderId(), "조회한 orderId와 일치해야 합니다");
        } else {
            System.out.println("orderId " + orderId + "에 해당하는 order_items가 없습니다.");
        }

        // 리스트는 null이 아니어야 함 (비어있어도 됨)
        assertNotNull(result);
    }

    @Test
    @DisplayName("findOrderItems - orderId로 주문 상품 상세 조회")
    void findOrderItems() {
        // Given
        Long orderId = 20001L;

        // When
        List<OrderDto.OrderItemInfo> result = orderMapper.findOrderItems(orderId);

        // Then
        System.out.println("조회된 아이템 개수: " + result.size());

        if (!result.isEmpty()) {
            OrderDto.OrderItemInfo firstItem = result.get(0);
            System.out.println("첫 번째 아이템: " + firstItem.toString());

            // 필수 필드 검증
            assertNotNull(firstItem.getProductId(), "productId는 null이 아니어야 합니다");
            assertNotNull(firstItem.getBrandId(), "brandId는 null이 아니어야 합니다");
        } else {
            System.out.println("orderId " + orderId + "에 해당하는 order_items가 없습니다.");
        }

        // 리스트는 null이 아니어야 함
        assertNotNull(result);
    }

    @Test
    @DisplayName("데이터베이스 연결 및 쿼리 실행 테스트")
    void testDatabaseConnection() {
        // 존재하지 않는 orderId로 테스트
        Long nonExistentOrderId = 99999L;

        List<OrderDto.OrderItemInfoTest> result = orderMapper.getOrderItemInfoTest(nonExistentOrderId);

        // 빈 리스트가 반환되어야 함
        assertNotNull(result);
        assertTrue(result.isEmpty(), "존재하지 않는 orderId에 대해서는 빈 리스트가 반환되어야 합니다");
    }
}