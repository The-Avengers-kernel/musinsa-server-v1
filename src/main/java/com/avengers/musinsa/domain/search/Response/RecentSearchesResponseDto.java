package com.avengers.musinsa.domain.search.Response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecentSearchesResponseDto {
    //전체 응답
    private Long userId;
    private List<RecentItemDto> recentSearches;
}
