package com.avengers.musinsa.domain.category.respository;

import com.avengers.musinsa.domain.category.dto.response.CategoryProductResponse;
import com.avengers.musinsa.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 이 클래스는 데이터 접근 계층
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryProductResponse> getCategoryProductList(Long parentCategoryId) {
        return this.categoryMapper.getCategoryProductList(parentCategoryId);
    }

}
