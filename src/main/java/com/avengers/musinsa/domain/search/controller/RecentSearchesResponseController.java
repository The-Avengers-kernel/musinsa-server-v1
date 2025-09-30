package com.avengers.musinsa.domain.search.controller;

import com.avengers.musinsa.domain.search.response.SearchKeywordResponseDTO;
import com.avengers.musinsa.domain.search.service.RecentSearchServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
@RequiredArgsConstructor
public class RecentSearchesResponseController {
    private final RecentSearchServiceImpl recentSearchService;

    @GetMapping("/recent")
    public List<SearchKeywordResponseDTO> recentSearches(@RequestParam Long userId) {
        return recentSearchService.getRecentSearches(userId);
    }
}