package com.avengers.musinsa.domain.product.mapper;

import com.avengers.musinsa.mapper.ProductMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@ActiveProfiles("test")
class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;

    @BeforeEach
    void setUp() {

    }

    // c


    // r
    @Test
    @DisplayName("컬러가 출력 체크")
    void getProductByIdColors() {
        List<String> colors = productMapper.findProductOptionColors(1L);

        // 비어있지 않아야 한다
        assertNotNull(colors);
        assertFalse(colors.isEmpty());

        // 특정 값이 포함되어야 한다 (예: "red")
        assertTrue(colors.contains("red"));

        // 예상 결과와 정확히 일치하는지 확인
        assertEquals(List.of("blue", "red", "green", "yellow"), colors);
    }


    // u


    // d
    // 딜리트 없어서 만들지 않습니다

}