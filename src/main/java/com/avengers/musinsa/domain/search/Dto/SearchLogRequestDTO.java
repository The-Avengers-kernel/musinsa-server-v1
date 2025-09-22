package com.avengers.musinsa.domain.search.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


@AllArgsConstructor
@Getter
@Setter
public class SearchLogRequestDTO {
    private String searchText;
    private long userId;
    private Integer searchCount;
}
