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
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @GetMapping("/categories/brands")
    public List<BrandResponse> categoryBrands() {
        return brandService.getBrandList();
    }

    @GetMapping("/categories/{brand-first-letter}/brands")
    public List<BrandResponse> getCategoryBrandsByFirstLetter(@PathVariable("brand-first-letter") char brandFirstLetter) {
        return brandService.getCategoryBrandsByFirstLetter(brandFirstLetter);
    }
}

