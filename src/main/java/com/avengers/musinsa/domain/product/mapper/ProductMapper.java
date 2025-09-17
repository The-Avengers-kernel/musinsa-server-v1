package com.avengers.musinsa.domain.product.mapper;

import com.avengers.musinsa.domain.product.dto.response.MaleRecommendationResponse;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    List<MaleRecommendationResponse> getRecommendationList();

}
