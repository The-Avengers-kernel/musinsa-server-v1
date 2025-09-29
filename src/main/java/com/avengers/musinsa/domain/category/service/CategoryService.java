package com.avengers.musinsa.domain.category.service;

import com.avengers.musinsa.domain.category.dto.response.CategoryProductResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryProductResponse> getCategoryProductList(Long parentCategoryId);
}
