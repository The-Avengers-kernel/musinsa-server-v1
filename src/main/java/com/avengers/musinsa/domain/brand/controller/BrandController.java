package com.avengers.musinsa.domain.brand.controller;

import com.avengers.musinsa.domain.brand.dto.response.BrandResponse;
import com.avengers.musinsa.domain.brand.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    //카테고리 - 브랜드 목록 전체 조회
    @GetMapping("/brands")
    public List<BrandResponse> categoryBrands() {
        return brandService.getBrandList();
    }

    @GetMapping("/letter/{brand-first-letter}/brands")
    public List<BrandResponse> getCategoryBrandsByFirstLetter(
            @PathVariable("brand-first-letter") String brandFirstLetter) {
        return brandService.getCategoryBrandsByFirstLetter(brandFirstLetter);
    }

    //카테고리 - 카테고리 별로 브랜드 목록 조회
    @GetMapping("/{brandCategoryId}/brands")
    public List<BrandResponse> getBrandsByCategory(@PathVariable Long brandCategoryId) {
        return brandService.getBrandsByCategoryId(brandCategoryId);
    }
}

