package com.avengers.musinsa.domain.category.controller;

import com.avengers.musinsa.domain.category.dto.response.CategoryProductResponse;
import com.avengers.musinsa.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // 이 클래스는 API용 컨트롤러라는 애너테이션
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class categoryController {

    private final CategoryService categoryService;

    // 상품 대중소 카테고리 가져오기
    @GetMapping("products")
    public List<CategoryProductResponse> categoryProducts(@RequestParam(required = false) Long parentCategoryId) {
        return categoryService.getCategoryProductList(parentCategoryId);
    }

    //브랜드 목록 전체 가져오기

    //브랜드 초성으로 조회
}
