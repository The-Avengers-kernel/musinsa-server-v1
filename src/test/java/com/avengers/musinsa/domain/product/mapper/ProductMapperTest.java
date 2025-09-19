package com.avengers.musinsa.domain.product.mapper;

import com.avengers.musinsa.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest // 스프링 부트 전체 컨텍스트 로딩
@Transactional // 각 테스트가 끝나면 롤백(DB 깨끗하게 유지)
class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;
    //

    @Test
    void testFindAllProducts(){
        System.out.println(productMapper.findAllProducts());
    }
}