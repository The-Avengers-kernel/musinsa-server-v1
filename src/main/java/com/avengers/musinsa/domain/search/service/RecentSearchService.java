package com.avengers.musinsa.domain.search.service;

import com.avengers.musinsa.domain.search.response.SearchKeywordResponseDTO;
import com.avengers.musinsa.domain.search.repository.RecentSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecentSearchService {
    private final RecentSearchRepository recentSearchRepository;

    public List<SearchKeywordResponseDTO> getRecentSearches(Long userId) {
        return recentSearchRepository.findRecentSearches(userId);
    }
}
