package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.user.dto.ProductOptionInfo;
import com.avengers.musinsa.domain.user.dto.ProductsInCartInfoResponse;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {
    List<ProductsInCartInfoResponse> getProductsInCart(Long userId);

    ProductOptionInfo productOptionInfo(Long userId, Long productId, Map<Integer, String> productOptions);

    void updateProductOption(Long userId, Long productId, String productOptionName, Integer quantity);
}
