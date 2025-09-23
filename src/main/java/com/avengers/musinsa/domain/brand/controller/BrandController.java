package com.avengers.musinsa.domain.brand.controller;

import com.avengers.musinsa.domain.brand.dto.response.BrandResponse;
import com.avengers.musinsa.domain.brand.entity.Brand;
import com.avengers.musinsa.domain.brand.service.BrandServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BrandController {
    private final BrandServiceImpl brandServiceImpl;

    //카테고리 - 브랜드 목록 전체 조회
    @GetMapping("/categories/brands")
    public List<BrandResponse> categoryBrands() {
        return brandServiceImpl.getBrandList();
    }

    @GetMapping("/categories/{brand-first-letter}/brands")
    public List<BrandResponse> getCategoryBrandsByFirstLetter(@PathVariable("brand-first-letter") char brandFirstLetter) {
        return brandServiceImpl.getCategoryBrandsByFirstLetter(brandFirstLetter);
    }
    //카테고리 - 카테고리 별로 브랜드 목록 조회
    @GetMapping("/categories/{brandCategoryId}/brands")
    public List<BrandResponse> getBrandsByCategory(@PathVariable Long brandCategoryId) {
        return brandServiceImpl.getBrandsByCategoryId(brandCategoryId);
    }

    @GetMapping("/get/brand/{brandName}")
    public List<BrandResponse> getBrand(@PathVariable String brandName){
        System.out.println(brandName);
        List<BrandResponse> brand = brandServiceImpl.findByBrandName(brandName);
        return brand;
    }
}

