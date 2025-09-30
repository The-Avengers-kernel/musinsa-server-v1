package com.avengers.musinsa.domain.search.controller;

import com.avengers.musinsa.domain.search.dto.PopularKeywordResponseDTO;
import com.avengers.musinsa.domain.search.service.PopularKeywordServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/search")
@RequiredArgsConstructor
public class PopularKeywordController {
    private final PopularKeywordServiceImpl popularKeywordService;

    @GetMapping("/popular-keyword")
    public PopularKeywordResponseDTO findPopularKeyword(){
        return popularKeywordService.getTrendingKeywords();
    }

}