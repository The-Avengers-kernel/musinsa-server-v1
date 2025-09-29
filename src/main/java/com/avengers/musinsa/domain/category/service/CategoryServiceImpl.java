package com.avengers.musinsa.domain.category.service;

import com.avengers.musinsa.domain.category.dto.response.CategoryProductResponse;
import com.avengers.musinsa.domain.category.respository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    // 의존성 주입
    private final CategoryRepository categoryRepository;


    @Override
    public List<CategoryProductResponse> getCategoryProductList(Long parentCategoryId) {
        return categoryRepository.getCategoryProductList(parentCategoryId);
    }
}
