package com.avengers.musinsa.review;

import java.sql.Timestamp;

public class SearchLogs {

    private Long searchLogId;

    private Users user;

    private String searchText;

    private Timestamp searchDateTime;

    private Integer searchCount;

    public Integer getSearchCount() {
        return searchCount;
    }

    public Timestamp getSearchDateTime() {
        return searchDateTime;
    }

    public Long getSearchLogId() {
        return searchLogId;
    }

    public String getSearchText() {
        return searchText;
    }

    public Users getUser() {
        return user;
    }
}
