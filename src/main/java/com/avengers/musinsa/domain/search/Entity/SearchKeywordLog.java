package com.avengers.musinsa.domain.search.Entity;

import com.avengers.musinsa.domain.other.entity.SearchKeyword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchKeywordLog {
    private Long searchKeywordLogId;
    private String searchKeywordText;
    private Long userId;

}
