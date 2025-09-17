package com.avengers.musinsa.domain.other.entity;

import com.avengers.musinsa.domain.user.entity.Users;
import java.sql.Timestamp;
import lombok.Getter;

@Getter
public class SearchLogs {
    private Long searchLogId;

    private Users user;
    private Long userId;

    private String searchText;
    private Timestamp searchDateTime;
    private Integer searchCount;
}
