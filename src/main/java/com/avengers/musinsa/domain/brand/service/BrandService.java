package com.avengers.musinsa.domain.brand.service;

import com.avengers.musinsa.domain.brand.dto.BrandDto;
import com.avengers.musinsa.domain.brand.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;

    //최근 방문한 브랜드 조회
    public List<BrandDto> getRecentVisitBrands(Long userId) {
        //null 검증
        if(userId == null) {
            throw new IllegalArgumentException("userId is null");
        }

        return brandRepository.selectRecentVisitedBrands(userId);
    }


}
