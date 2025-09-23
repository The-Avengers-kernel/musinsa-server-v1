package com.avengers.musinsa.domain.user.service;

import com.avengers.musinsa.domain.product.service.ProductService;
import com.avengers.musinsa.domain.user.dto.*;
import com.avengers.musinsa.domain.user.repository.CartRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avengers.musinsa.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductService productService;
    private final CartMapper cartMapper;


    // 상품 상세 화면에서 장바구니 추가 POST Request
    @Transactional
    public void addProductUserCart(Long userId, AddCartRequest request) {
        // 3. 핵심 비즈니스 로직: 상품 존재 여부 확인
        CartItemDto existingItem = cartRepository.findCartItemByVariantId(userId, request.getProductVariantId());

        if (existingItem != null) {
            // 4. 상품이 이미 있으면: 수량 업데이트
            int newQuantity = existingItem.getQuantity() + request.getQuantity();
            cartRepository.updateCartItemQuantity(existingItem.getCartId(), newQuantity);
        } else {
            // 5. 상품이 없으면: 새로 추가
            cartRepository.insertNewCartItem(userId, request);
        }
    }

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

public List<ProductsInCartInfoResponse> updateProductOption(Long userId, Long productId,
                                                            ProductOptionUpdateRequest productOptionUpdateRequest) {
    // 해당 상품의 변경되는 옵션과 값 담기
    Map<Integer, String> productOptions = new HashMap<>();
    for (int i = 0; i < productOptionUpdateRequest.getOptionGroups().size(); i++) {
        productOptions.put(productOptionUpdateRequest.getOptionGroups().get(i).getOptionTypeId(),
                productOptionUpdateRequest.getOptionGroups().get(i).getOptionValue());
    }

    // 변경하려는 재고 값
    Integer updateQuantity = productOptionUpdateRequest.getQuantity();

    // 변경하고자 하는 상품 옵션 명과 해당 상품의 남은 재고 가져오기
    ProductOptionInfo productOptionInfo = cartRepository.productOptionInfo(userId, productId, productOptions);

    // 변경하려는 재고값이 남은 재고보다 클 경우 예외처리
    Integer availableQuantity = productOptionInfo.getQuantity();
    if (updateQuantity > availableQuantity) {
        String message = "최대 " + availableQuantity + "개의 상품만 구매할 수 있습니다.";
        throw new ResponseStatusException(HttpStatus.CONFLICT, "QUANTITY_4091" + message);
    }

    // 외의 경우 장바구니의 해당 상품 옵션 변경
    cartRepository.updateProductOption(userId, productId, productOptionInfo.getOptionName(), updateQuantity);

    // 장바구니 상품 목록 반환
    return getProductsInCart(userId);
}
}
