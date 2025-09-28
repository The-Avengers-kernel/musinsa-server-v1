<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MUSINSA - 무신사</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <%--헤더, 카테고리 연결--%>
    <%@ include file="header.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
    <%@ include file="category.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/category.css">

    <style>
        body {
            font-family: 'Noto Sans KR', -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }



        /* Main Content */
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 30px 20px;
        }

        .section {
            margin-bottom: 50px;
            background: white;
            border-radius: 8px;
            padding: 30px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }

        .section-title {
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 8px;
            color: #333;
        }

        .section-subtitle {
            font-size: 14px;
            color: #666;
            margin-bottom: 25px;
        }

        .product-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 25px;
        }

        .product-card {
            cursor: pointer;
        }

        .product-image {
            width: 100%;
            height: 250px;
            background-color: #e9ecef;
            border-radius: 8px;
            margin-bottom: 12px;
            display: flex;
            align-items: center;
            justify-content: center;
            color: #666;
            font-size: 14px;
        }

        .product-brand {
            font-size: 12px;
            color: #666;
            margin-bottom: 4px;
        }

        .product-name {
            font-size: 14px;
            font-weight: 500;
            margin-bottom: 8px;
            line-height: 1.3;
            height: 36px;
            overflow: hidden;
        }

        .product-price {
            display: flex;
            align-items: center;
            gap: 8px;
        }

        .discount-rate {
            color: #e74c3c;
            font-weight: bold;
            font-size: 14px;
        }

        .current-price {
            font-weight: bold;
            font-size: 14px;
        }

        /* Responsive */
        @media (max-width: 768px) {
            .sidebar {
                width: 100%;
                left: -100%;
            }
        }
    </style>
</head>
<body>

<!-- Main Content -->
<main class="container">
    <!-- 남성 아이템 추천 섹션 (순서 변경) -->
    <section class="section">
        <h2 class="section-title">남성 아이템 추천</h2>
        <p class="section-subtitle">스타일리시한 남성 패션</p>
        <div class="product-grid">
            <c:forEach var="product" items="${menProducts}" varStatus="status">
                <div class="product-card" onclick="location.href='/product/${product.id}'">
                    <img src="${product.imageUrl}" alt="${product.name}" class="product-image">
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
            </c:forEach>

            <!-- 샘플 데이터 (백엔드 연동 전까지) -->
            <c:if test="${empty menProducts}">
                <div class="product-card">
                    <div class="product-image">이미지</div>
                    <div class="product-brand">모던</div>
                    <div class="product-name">화이트 다트 진즈 (WASHED BLUE BLACK)</div>
                    <div class="product-price">
                        <span class="discount-rate">30%</span>
                        <span class="current-price">34,300원</span>
                    </div>
                </div>
                <div class="product-card">
                    <div class="product-image">이미지</div>
                    <div class="product-brand">마일스</div>
                    <div class="product-name">Mid Rise Wide Jeans DCPT027C/Brown</div>
                    <div class="product-price">
                        <span class="discount-rate">10%</span>
                        <span class="current-price">55,800원</span>
                    </div>
                </div>
                <div class="product-card">
                    <div class="product-image">이미지</div>
                    <div class="product-brand">펠트오스</div>
                    <div class="product-name">던디직 와이드 다리 진즈 데님-(미디엄) 팬츠</div>
                    <div class="product-price">
                        <span class="discount-rate">43%</span>
                        <span class="current-price">29,900원</span>
                    </div>
                </div>
                <div class="product-card">
                    <div class="product-image">이미지</div>
                    <div class="product-brand">우익</div>
                    <div class="product-name">우크로냐 와이드 크럽 팬츠 - 3 COLOR</div>
                    <div class="product-price">
                        <span class="discount-rate">36%</span>
                        <span class="current-price">45,300원</span>
                    </div>
                </div>
                <div class="product-card">
                    <div class="product-image">이미지</div>
                    <div class="product-brand">어텐업드</div>
                    <div class="product-name">Snow Cargo Denim BLACK</div>
                    <div class="product-price">
                        <span class="discount-rate">48%</span>
                        <span class="current-price">42,120원</span>
                    </div>
                </div>
            </c:if>
        </div>
    </section>

    <!-- 여성 아이템 추천 섹션 (순서 변경) -->
    <section class="section">
        <h2 class="section-title">여성 아이템 추천</h2>
        <p class="section-subtitle">트렌디한 여성 패션</p>
        <div class="product-grid">
            <c:forEach var="product" items="${womenProducts}" varStatus="status">
                <div class="product-card" onclick="location.href='/product/${product.id}'">
                    <img src="${product.imageUrl}" alt="${product.name}" class="product-image">
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
            </c:forEach>

            <!-- 샘플 데이터 (백엔드 연동 전까지) -->
            <c:if test="${empty womenProducts}">
                <div class="product-card">
                    <div class="product-image">이미지</div>
                    <div class="product-brand">디펜드파리</div>
                    <div class="product-name">ASI 베이직 체크 카드숏 다잔 폴조 반팔티 셔츠</div>
                    <div class="product-price">
                        <span class="discount-rate">23%</span>
                        <span class="current-price">29,900원</span>
                    </div>
                </div>
                <div class="product-card">
                    <div class="product-image">이미지</div>
                    <div class="product-brand">브랜드명</div>
                    <div class="product-name">WIDE DENIM SWEAT PANTS [BRUSHED BLACK]</div>
                    <div class="product-price">
                        <span class="discount-rate">25%</span>
                        <span class="current-price">75,000원</span>
                    </div>
                </div>
                <div class="product-card">
                    <div class="product-image">이미지</div>
                    <div class="product-brand">드로우</div>
                    <div class="product-name">가벼운 데님 바지 블랙</div>
                    <div class="product-price">
                        <span class="discount-rate">43%</span>
                        <span class="current-price">54,000원</span>
                    </div>
                </div>
                <div class="product-card">
                    <div class="product-image">이미지</div>
                    <div class="product-brand">우익</div>
                    <div class="product-name">리넨소 세미 와이드 진 (업라디)</div>
                    <div class="product-price">
                        <span class="discount-rate">10%</span>
                        <span class="current-price">144,000원</span>
                    </div>
                </div>
                <div class="product-card">
                    <div class="product-image">이미지</div>
                    <div class="product-brand">브로우스</div>
                    <div class="product-name">우수 실시 아이는 다 진 팩츠 (BLUE)</div>
                    <div class="product-price">
                        <span class="discount-rate">10%</span>
                        <span class="current-price">54,000원</span>
                    </div>
                </div>
            </c:if>
        </div>
    </section>
</main>

<script>
</script>
</body>
</html>