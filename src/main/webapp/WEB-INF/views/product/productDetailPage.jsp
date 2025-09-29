<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>제품 상세</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/productDetailPage.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/productDetailPage.js"></script>
    <%@ include file="../main/header.jsp" %>
    <link rel="stylesheet" href="<c:url value='/resources/css/header.css'/>">
</head>

<body>

<div class="container">
    <div class="product-layout">
        <!-- 왼쪽: 이미지 + 상세 설명 + 사이즈 + 리뷰 -->
        <div class="product-left-column">
            <!-- 상품 이미지 영역 -->
            <div class="product-images-section">
                <div class="image-previews" id="thumbnailImages"></div>
                <div class="main-image-container"></div>
            </div>

            <!-- 상품 상세 설명 -->
            <div class="product-detail-section">
                <div id="detailDescription" class="product-description-url"></div>
            </div>

            <!-- 사이즈 정보 -->
            <div class="product-size-section">
                <div id="detailSizeImage" class="product-detailSizeImage-url"></div>
                <div id="productDetailSizeList" class="product-detail-size-list"></div>
            </div>

            <!-- 리뷰 섹션 -->
            <div class="product-review-section">
                <div id="productsReviews" class="product-reviews"></div>
            </div>
        </div>

        <!-- 오른쪽: 제품 정보 및 구매 옵션 -->
        <div class="product-right-column">
            <div class="product-info-sticky">
                <!-- 브랜드 및 상품명 -->
                <div class="seller-info">
                    <div class="brand-header">
                        <span class="brand-image-container" id="brand-image-container"></span>
                        <span class="brand-name" id="brandName"></span>
                        <!-- 브랜드 좋아요 버튼 -->
                        <button class="brand-wishlist-icon">
                            <i class="far fa-heart heart-icon"></i>
                            <span id="brandLikeCnt"></span>
                        </button>
                    </div>

                    <div id="categoryName" class="product-categories"></div>

                    <span class="product-title" id="productName"></span>

                    <!-- 별점 및 리뷰 -->
                    <div class="product-rating">
                        <span class="star-icon">★</span>
                        <span class="rating-score">4.9</span>
                        <span class="review-count">후기 69개</span>
                    </div>
                </div>

                <!-- 색상 스와치 (동그라미) -->
                <div class="color-swatches" id="colorSwatches">
                    <!-- JavaScript로 동적 생성 -->
                </div>

                <!-- 가격 섹션 -->
                <div class="price-section">
                    <div class="price-header">
                        <span class="original-price" id="productPrice"></span>
                    </div>

                    <div class="price-main">
                        <span class="sale-percentage" id="productDiscount"></span>
                        <span class="discounted-price" id="productTotalPrice"></span>
                    </div>

                    <div class="final-price-wrapper">
                        <span class="final-price-amount" id="finalPrice"></span>
                        <span class="max-benefit-label">최대혜택가</span>
                        <span class="detail-link">자세히 ▼</span>
                    </div>
                </div>

                <!-- 적립금 섹션 -->
                <div class="point-section">
                    <p class="max-point-amount">9,250원 최대적립</p>
                    <ul>
                        <li>· 등급 적립 (LV.5 실버 • 1.5%) <span>2,530원</span></li>
                        <li>· 후기 적립 <span>2,500원</span></li>
                        <li>· 무신사머니 결제 시 적립 2.5% <span>4,220원</span></li>
                    </ul>
                </div>

                <!-- M Money 배너 -->
                <div class="money-benefit-banner">
                    <span class="money-logo">M Money</span>
                    <p>무신사머니 첫 결제 시 <strong>10%</strong> 추가 적립</p>
                    <span>›</span>
                </div>

                <!-- 옵션 선택 -->
                <div class="options-section">
                    <select id="color-select" class="color-select">
                        <option value="">컬러</option>
                    </select>

                    <select id="size-select" class="size-select">
                        <option value="">사이즈</option>
                    </select>
                </div>
                <!-- 수량 선택 추가 -->
                <div class="quantity-section">
                    <div class="quantity-controls">
                        <button type="button" class="quantity-btn" id="decrease-btn">−</button>
                        <input type="text" id="quantity-input" value="1" readonly>
                        <button type="button" class="quantity-btn" id="increase-btn">+</button>
                    </div>
                </div>

                <!-- 하단 액션 버튼들 -->
                <div class="bottom-action-buttons">
                    <button class="wishlist-icon">
                        <i class="far fa-heart heart-icon"></i>
                        <span id="productLikeCnt"></span>
                    </button>
                    <button class="add-to-cart-btn large-btn">장바구니</button>
                    <button class="buy-now large-btn">구매하기</button>
                </div>

                <!-- 숨겨진 데이터 -->
                <p id="brandId" style="display:none;"></p>
                <p id="productId" style="display:none;"></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>