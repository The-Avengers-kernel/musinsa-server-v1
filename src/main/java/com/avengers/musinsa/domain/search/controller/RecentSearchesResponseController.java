package com.avengers.musinsa.domain.search.controller;

import com.avengers.musinsa.domain.search.response.SearchKeywordResponseDTO;
import com.avengers.musinsa.domain.search.service.RecentSearchServiceImpl;
import com.avengers.musinsa.domain.user.auth.jwt.TokenProviderService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Collections;

@RestController
@RequestMapping("/api/v1/search")
@RequiredArgsConstructor
public class RecentSearchesResponseController {
    private final RecentSearchServiceImpl recentSearchService;
    private final TokenProviderService tokenProviderService;

    @GetMapping("/recent")
    public List<SearchKeywordResponseDTO> recentSearches(
            @CookieValue(value = "Authorization", required = false) String authorizationHeader
    ) {
        if (authorizationHeader == null || authorizationHeader.isBlank()) {
            return Collections.emptyList();
        }
        Long userId = tokenProviderService.getUserIdFromToken(authorizationHeader);
        return recentSearchService.getRecentSearches(userId);
    }
}
