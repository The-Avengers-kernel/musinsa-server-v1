package com.avengers.musinsa.domain.search.Service;

import com.avengers.musinsa.domain.search.Response.RecentSearchesResponseDto;
import com.avengers.musinsa.mapper.getRecentSearchesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecentSearchService {
    private final getRecentSearchesMapper getRecentSearchesMapper;

    public List<RecentSearchesResponseDto>  getRecentSearches(Long userId) {
        return getRecentSearchesMapper.getRecentSearches(userId);
    }


}
