package com.avengers.musinsa.domain.user.service;

import com.avengers.musinsa.domain.product.service.ProductService;
import com.avengers.musinsa.domain.user.dto.ProductsInCartInfoResponse;
import com.avengers.musinsa.domain.user.repository.CartRepository;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductService productService;

    public List<ProductsInCartInfoResponse> getProductsInCart(Long userId) {
        // 장바구니에 담은 상품 가져옴
        List<ProductsInCartInfoResponse> productsInCart = cartRepository.getProductsInCart(userId);

        // 장바구니에서 가져온 상품들의 ID를 리스트에 저장
        List<Long> productIds = productsInCart.stream().map(ProductsInCartInfoResponse::getProductId).toList();

        // 상품 ID들의 옵션 그룹 정보를 가져와 상품 ID 별로 Map에 저장
        Map<Long, List<ProductsInCartInfoResponse.OptionGroup>> groupsMap = productService
                .getGroupsByProductIds(productIds);

        for (var group : productsInCart) {
            group.attachGroups(groupsMap.getOrDefault(group.getProductId(),
                    List.of()));
        }

        return productsInCart;
    }
}
