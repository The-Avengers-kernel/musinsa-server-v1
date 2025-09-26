<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %><!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MUSINSA - 무신사</title>
    <%@ include file="header.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css" />
    <style>
        body {
            font-family: 'Noto Sans KR', sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 30px 20px;
        }

        .section {
            margin-bottom: 50px;
            background: white;
            border-radius: 8px;
            padding: 20px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }

        .section-title {
            font-size: 20px;
            font-weight: bold;
            margin-top: 0px;
            margin-bottom: 5px;
            color: #333;
        }

        .section-subtitle {
            font-size: 14px;
            color: #666;
            margin-top: 5px;
            margin-bottom: 15px;
        }

        /* Swiper 완전 간격 제거 */
        .swiper {
            width: 100%;
            height: auto;
            position: relative;
            overflow: hidden;
        }

        .swiper-wrapper {
            margin: 0 !important;
            padding: 0 !important;
        }

        .swiper-slide {
            margin: 0 !important;
            padding: 0 !important;
            border: none !important;
            box-sizing: border-box;
            flex-shrink: 0;
        }

        /* 모든 nth-child 마진 완전 제거 */
        .swiper-slide:nth-child(n) {
            margin-right: 0 !important;
            margin-left: 0 !important;
            padding-right: 0 !important;
            padding-left: 0 !important;
        }

        .product-card {
            cursor: pointer;
            margin: 0;
            padding: 0;
            border: none;
            margin-bottom: 20px;

        }

        .product-card:hover {
            transform: none;
        }

        .product-image {
            width: 100%;
            height: 240px; /* 이미지 크기 작게 조정 */
            background-color: #e9ecef;
            margin: 0 0 8px 0;
            display: flex;
            align-items: center;
            justify-content: center;
            color: #e9ecef;
            font-size: 14px;
            overflow: hidden;
            position: relative;
            border: none;
            border-radius: 0;
        }

        .product-image img {
            margin-top: 0px;
            width: 100%;
            height: 100%;
            object-fit: cover;
            display: block;
        }

        .product-image.placeholder {
            background-color: #f0f0f0;
        }

        .product-brand {
            font-size: 11px;
            color: #666;
            margin-bottom: 4px;
        }

        .product-name {
            font-size: 12px;
            font-weight: 500;
            margin-bottom: 2px;
            margin-right: 6px;
            line-height: 1.3;
            word-break: break-word;
            overflow-wrap: break-word;
            hyphens: auto;
        }

        .product-price {
            display: flex;
            align-items: center;
            gap: 6px;
            flex-wrap: wrap;
        }

        .discount-rate {
            color: #e74c3c;
            font-weight: bold;
            font-size: 12px;
        }

        .current-price {
            font-weight: bold;
            font-size: 12px;
        }

        .original-price {
            font-size: 10px;
            color: #999;
            text-decoration: line-through;
        }

        /* Navigation 버튼 스타일 */
        .swiper-button-next,
        .swiper-button-prev {
            color: #000000;
            width: 30px;
            height: 30px;
        }

        /* 반응형 - 5.5개 상품 기준으로 조정 */
        @media (max-width: 1200px) {
            .swiper-slide {
                width: 22.22% !important; /* 4.5개 상품 */
            }
        }

        @media (max-width: 768px) {
            .swiper-slide {
                width: 45% !important; /* 2.2개 상품 */
            }
            .product-image {
                height: 180px;
            }
        }

        @media (max-width: 480px) {
            .swiper-slide {
                width: 90% !important; /* 1.1개 상품 */
            }
            .product-image {
                height: 160px;
            }
        }
    </style>
</head>
<body>
<main class="container">
    <!-- 하나의 컨테이너에 남성/여성 슬라이드 -->
    <section class="section">
        <h2 class="section-title">아이템 추천</h2>
        <p class="section-subtitle">스타일리시한 패션</p>

        <!-- 남성 아이템 -->
        <h3 class="sub-title">남성 아이템 추천</h3>
        <div class="swiper men-swiper">
            <div class="swiper-wrapper">
                <c:forEach var="product" items="${menProducts}">
                    <div class="swiper-slide">
                        <div class="product-card" onclick="location.href='/product/${product.id}'">
                            <div class="product-image">
                                <c:choose>
                                    <c:when test="${not empty product.imageUrl}">
                                        <img src="${product.imageUrl}" alt="${product.name}">
                                    </c:when>
                                    <c:otherwise>
                                        <div class="placeholder">이미지 없음</div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="product-brand">${product.brandName}</div>
                            <div class="product-name">${product.name}</div>
                            <div class="product-price">
                                <c:if test="${product.discountRate > 0}">
                                    <span class="discount-rate">${product.discountRate}%</span>
                                </c:if>
                                <span class="current-price">
                                    <fmt:formatNumber value="${product.currentPrice}" pattern="#,###"/>원
                                </span>
                                <c:if test="${product.originalPrice > product.currentPrice}">
                                    <span class="original-price">
                                        <fmt:formatNumber value="${product.originalPrice}" pattern="#,###"/>원
                                    </span>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="swiper-button-next"></div>
            <div class="swiper-button-prev"></div>
        </div>

        <!-- 여성 아이템 -->
        <h3 class="sub-title">여성 아이템 추천</h3>
        <div class="swiper men-swiper">
            <div class="swiper-wrapper">
                <c:forEach var="product" items="${womenProducts}">
                    <div class="swiper-slide">
                        <div class="product-card" onclick="location.href='/product/${product.id}'">
                            <div class="product-image">
                                <c:choose>
                                    <c:when test="${not empty product.imageUrl}">
                                        <img src="${product.imageUrl}" alt="${product.name}">
                                    </c:when>
                                    <c:otherwise>
                                        <div class="placeholder">이미지 없음</div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="product-brand">${product.brandName}</div>
                            <div class="product-name">${product.name}</div>
                            <div class="product-price">
                                <c:if test="${product.discountRate > 0}">
                                    <span class="discount-rate">${product.discountRate}%</span>
                                </c:if>
                                <span class="current-price">
                                    <fmt:formatNumber value="${product.currentPrice}" pattern="#,###"/>원
                                </span>
                                <c:if test="${product.originalPrice > product.currentPrice}">
                                    <span class="original-price">
                                        <fmt:formatNumber value="${product.originalPrice}" pattern="#,###"/>원
                                    </span>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="swiper-button-next"></div>
            <div class="swiper-button-prev"></div>
        </div>
    </section>
</main>

<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
<script>
    const menSwiper = new Swiper('.men-swiper', {
        slidesPerView: 5.5,   // 한 줄에 5.5개
        slidesPerGroup: 4,    // 슬라이드할 때 4개씩 이동
        spaceBetween: 0,
        speed: 600,
        loop: false,

        grid: {
            rows: 2,          // 2줄로 배치
            fill: 'row'
        },

        navigation: {
            nextEl: '.men-swiper .swiper-button-next',
            prevEl: '.men-swiper .swiper-button-prev',
        },

        breakpoints: {
            320: {
                slidesPerView: 1.1,
                slidesPerGroup: 2,
                grid: { rows: 2 }
            },
            480: {
                slidesPerView: 2.2,
                slidesPerGroup: 2,
                grid: { rows: 2 }
            },
            768: {
                slidesPerView: 3.2,
                slidesPerGroup: 3,
                grid: { rows: 2 }
            },
            1024: {
                slidesPerView: 4.5,
                slidesPerGroup: 4,
                grid: { rows: 2 }
            },
            1200: {
                slidesPerView: 5.5,
                slidesPerGroup: 4,  // 👉 여기 중요 (네 요구사항)
                grid: { rows: 2 }
            }
        }
    });

</script>

</body>
</html>