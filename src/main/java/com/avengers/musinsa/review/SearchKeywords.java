package com.avengers.musinsa.review;

public class SearchKeywords {

    private Long searchKeywordId;

    private String keyword;

    private String keywordInitial;

    private Integer dailyCount;

    private Integer currentHourSearchCount;

    private Integer growthRate;

    private String isTrending;

    public Integer getCurrentHourSearchCount() {
        return currentHourSearchCount;
    }

    public Integer getDailyCount() {
        return dailyCount;
    }

    public Integer getGrowthRate() {
        return growthRate;
    }

    public String getIsTrending() {
        return isTrending;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getKeywordInitial() {
        return keywordInitial;
    }

    public Long getSearchKeywordId() {
        return searchKeywordId;
    }
}
