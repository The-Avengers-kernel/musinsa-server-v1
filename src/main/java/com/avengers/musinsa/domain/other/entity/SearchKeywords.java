package com.avengers.musinsa.domain.other.entity;

import lombok.Getter;

@Getter
public class SearchKeywords {
    private Long searchKeywordId;
    private String keyword;
    private String keywordInitial;
    private Integer dailyCount;
    private Integer currentHourSearchCount;
    private Integer growthRate;
    private String isTrending;
}
