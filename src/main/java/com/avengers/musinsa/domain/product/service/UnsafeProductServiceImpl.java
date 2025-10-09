//package com.avengers.musinsa.domain.product.service;
//
//import com.avengers.musinsa.domain.product.dto.response.*;
//import com.avengers.musinsa.domain.product.entity.Gender;
//import com.avengers.musinsa.domain.product.repository.ProductRepository;
//import com.avengers.musinsa.domain.user.dto.ProductsInCartInfoResponse;
//import com.avengers.musinsa.mapper.ProductMapper;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Map;
//
//@Slf4j
////@Service
//@RequiredArgsConstructor
//public class UnsafeProductServiceImpl implements ProductService {
//
//    private final ProductRepository productRepository;
//    private final ProductMapper productMapper;
//
//    @Transactional
//    @Override
//    public ProductLikeResponse ProductLikeToggle(Long userId, Long productId) {
//        UserProductStatus status = productRepository.getUserProductStatus(userId, productId);
//
//        if (status == null) {
//            productRepository.insertUserProductLike(userId, productId);
//
//            // 🔥 READ-MODIFY-WRITE 패턴 (Unsafe!)
//            Long currentLikes = productMapper.getProductLikeCnt(productId);
//
//            Long newLikes = currentLikes + 1;
//            productMapper.setProductLikeCnt(productId, newLikes);
//
//            return productRepository.getIsLikedProduct(userId, productId);
//        }
//        else {
//            Integer currentLiked = status.getLiked();
//            productRepository.switchProductLike(userId, productId);
//
//            Long currentLikes = productMapper.getProductLikeCnt(productId);
//
//            Long newLikes;
//            if (currentLiked != null && currentLiked == 1) {
//                newLikes = currentLikes - 1;
//            } else {
//                newLikes = currentLikes + 1;
//            }
//
//            productMapper.setProductLikeCnt(productId, newLikes);
//
//            return productRepository.getIsLikedProduct(userId, productId);
//        }
//    }
//
//    // 나머지 메서드들은 에러 방지용 (실제로는 사용 안 함)
//    @Override
//    public ProductDetailResponse getProductById(Long productId, Long userId) {
//        return null;
//    }
//
//    @Override
//    public List<ProductVariantDetailDto> getProductVariants(Long productId) {
//        return null;
//    }
//
//    @Override
//    public List<RecommendationResponse> getRecommendationProductList(Gender gender, Long userId) {
//        return null;
//    }
//
//    @Override
//    public Map<Long, List<ProductsInCartInfoResponse.OptionGroup>> getGroupsByProductIds(List<Long> productIds) {
//        return null;
//    }
//
//    @Override
//    public List<ProductReviewsResponse> getProductReviews(Long productId) {
//        return null;
//    }
//
//    @Override
//    public void createProductReview(Long productId, Long userId, com.avengers.musinsa.domain.review.dto.Request.RequestReview requestReview) {
//    }
//
//    @Override
//    public void updateProductReview(Long reviewId, com.avengers.musinsa.domain.review.dto.Request.RequestReview requestReview) {
//    }
//
//    @Override
//    public void deleteProductReview(Long reviewId) {
//    }
//
//    @Override
//    public Object getProductDetailSizeList(Long productId, Long userId) {
//        return null;
//    }
//
//    @Override
//    public ProductDetailDescriptionResponse getProductDetailDescription(Long productId) {
//        return null;
//    }
//
//    @Override
//    public List<ProductByCategoryResponse> getProductsByCategory(Long categoryId, Long userId, String sortBy) {
//        return null;
//    }
//
//    @Override
//    public ProductCategoryListResponse getProductCategories(Long productId) {
//        return null;
//    }
//
//    @Override
//    public com.avengers.musinsa.domain.product.dto.search.SearchResponse searchProducts(String keyword, Long userId, String sortBy) {
//        return null;
//    }
//}