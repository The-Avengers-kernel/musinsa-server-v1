package com.avengers.musinsa.domain.search.service;

import com.avengers.musinsa.domain.search.repository.RecentSearchRepository;
import com.avengers.musinsa.domain.search.response.SearchKeywordResponseDTO;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecentSearchServiceImpl implements RecentSearchService {

    private final RecentSearchRepository recentSearchRepository;

    @Override
    public List<SearchKeywordResponseDTO> getRecentSearches(Long userId) {
        List<SearchKeywordResponseDTO> searches = recentSearchRepository.findRecentSearches(userId);
        return searches != null ? searches : Collections.emptyList();
    }
}
