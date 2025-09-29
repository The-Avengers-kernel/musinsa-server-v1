package com.avengers.musinsa.domain.category.respository;

import com.avengers.musinsa.domain.category.dto.response.CategoryProductResponse;

import java.util.List;

public interface CategoryRepository {
    List<CategoryProductResponse> getCategoryProductList(Long parentCategoryId);
}
