package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.user.dto.ProductsInCartInfoResponse;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {
    List<ProductsInCartInfoResponse> getProductsInCart(Long userId);

}
