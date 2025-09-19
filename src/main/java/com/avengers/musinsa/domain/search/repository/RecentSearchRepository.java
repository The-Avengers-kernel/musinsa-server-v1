package com.avengers.musinsa.domain.search.repository;

import com.avengers.musinsa.mapper.getRecentSearchesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor //필드를 초기화하는 생성자 코드를 자동으로 만들어주는 애너테이션
public class RecentSearchRepository {
    //getRecentSearchesMapper 주입
    private final getRecentSearchesMapper getRecentSearchesMapper;
}
