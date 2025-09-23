package com.avengers.musinsa.domain.search.Dto;

import lombok.*;

import java.util.List;

public class SearchSaveDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class searchKeywordLogSaveDto{
        private Long searchKeywordLogSaveId;
        private Long userId;
        private String searchText;

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class searchBrandLogSaveDto{
        private Long searchBrandLogSaveId;
        private Long userId;
        private Long brandId;
    }
}
