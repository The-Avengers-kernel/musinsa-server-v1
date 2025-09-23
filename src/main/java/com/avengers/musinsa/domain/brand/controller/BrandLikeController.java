package com.avengers.musinsa.domain.brand.controller;
import com.avengers.musinsa.domain.brand.dto.response.BrandLikeResponse;
import com.avengers.musinsa.domain.brand.service.BrandService;
import com.avengers.musinsa.domain.user.auth.jwt.TokenProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BrandLikeController {
    private final BrandService brandService;
    private final TokenProviderService tokenProviderService;

    //브랜드 최초 좋아요 하기 (레코드 추가)
    @PostMapping("/brands/{brandId}/liked")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public BrandLikeResponse addBrandLikedByUser(@PathVariable Long brandId, @CookieValue(value = "Authorization", required = false) String authorizationHeader) {
        if (authorizationHeader == null || authorizationHeader.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authorization token is missing");
        } else {
            Long userId = tokenProviderService.getUserIdFromToken(authorizationHeader);
            System.out.println("userId = " + userId);
            return brandService.addBrandLikedByUser(userId, brandId);
        }
    }
    //이미 좋아요한 브랜드 좋아요 하기/취소하기 (patch)
    /*@PatchMapping("/brands/{brandId}/liked")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public BrandLikeResponse updateBrandLikedByUser(@PathVariable Long brandId, @CookieValue(value = "Authorization", required = false) String authorizationHeader) {
        if (authorizationHeader == null || authorizationHeader.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authorization token is missing");
        } else {
            Long userId = tokenProviderService.getUserIdFromToken(authorizationHeader);
            System.out.println("userId = " + userId);
            return brandService.switchBrandLike(userId, brandId);
        }
    }*/
    @PatchMapping("/{user_id}/brands/{brandId}/liked")
    public BrandLikeResponse updateBrandLikedByUser(@PathVariable Long brandId, @PathVariable("user_id")Long userId) {
            return brandService.switchBrandLike(userId, brandId);

    }
}



