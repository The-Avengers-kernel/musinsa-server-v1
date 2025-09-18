<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 상세 목록</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Malgun Gothic', sans-serif;
            background-color: #f5f5f5;
        }

        .header {
            background-color: #333;
            color: white;
            padding: 10px 0;
        }

        .nav {
            text-align: center;
            font-size: 14px;
        }

        .nav span {
            margin: 0 15px;
            cursor: pointer;
        }

        .nav .highlight {
            color: #ff6b35;
        }

        .container {
            max-width: 1200px;
            margin: 20px auto;
            background-color: white;
            border: 1px solid #ddd;
            padding: 20px;
        }

        .page-title {
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 20px;
            border-bottom: 2px solid #333;
            padding-bottom: 10px;
        }

        .product-section {
            display: flex;
            gap: 30px;
            margin-bottom: 30px;
        }

        .product-images {
            flex: 1;
        }

        .thumbnail-list {
            display: flex;
            flex-direction: column;
            gap: 10px;
            margin-right: 15px;
            float: left;
        }

        .thumbnail {
            width: 60px;
            height: 80px;
            border: 1px solid #ddd;
            background-color: #f9f9f9;
            cursor: pointer;
        }

        .thumbnail.active {
            border: 2px solid #333;
        }

        .main-image {
            width: 400px;
            height: 500px;
            border: 1px solid #ddd;
            background-color: #f9f9f9;
            margin-left: 80px;
            position: relative;
        }

        .image-nav {
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            background: rgba(0,0,0,0.3);
            color: white;
            border: none;
            width: 30px;
            height: 30px;
            cursor: pointer;
            font-size: 16px;
        }

        .image-nav.prev {
            left: 10px;
        }

        .image-nav.next {
            right: 10px;
        }

        .product-info {
            flex: 1;
            padding-left: 20px;
        }

        .brand-info {
            color: #999;
            font-size: 14px;
            margin-bottom: 5px;
        }

        .brand-name {
            color: #ff6b35;
            font-weight: bold;
        }

        .product-title {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 10px;
            line-height: 1.4;
        }

        .rating {
            display: flex;
            align-items: center;
            gap: 5px;
            margin-bottom: 15px;
            font-size: 14px;
        }

        .star {
            color: #ff6b35;
        }

        .delivery-info {
            background-color: #e8f4fd;
            padding: 8px 12px;
            border-radius: 4px;
            font-size: 13px;
            color: #0066cc;
            margin-bottom: 15px;
        }

        .price-section {
            margin-bottom: 20px;
        }

        .original-price {
            color: #999;
            text-decoration: line-through;
            font-size: 14px;
        }

        .discount-price {
            display: flex;
            align-items: center;
            gap: 10px;
            margin: 5px 0;
        }

        .discount-badge {
            background-color: #fff;
            border: 1px solid #ff6b35;
            color: #ff6b35;
            padding: 2px 8px;
            font-size: 12px;
            border-radius: 2px;
        }

        .price {
            font-size: 18px;
            font-weight: bold;
        }

        .final-price {
            color: #ff4444;
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .discount-amount {
            color: #ff4444;
            font-size: 14px;
        }

        .point-info {
            color: #999;
            font-size: 13px;
            margin-bottom: 15px;
        }

        .membership-info {
            color: #999;
            font-size: 13px;
            margin-bottom: 20px;
        }

        .size-section {
            margin-bottom: 20px;
        }

        .size-label {
            font-size: 14px;
            color: #999;
            margin-bottom: 8px;
        }

        .size-guide {
            color: #ff6b35;
            text-decoration: underline;
            cursor: pointer;
        }

        .size-options {
            display: flex;
            flex-wrap: wrap;
            gap: 8px;
            margin-bottom: 15px;
        }

        .size-option {
            padding: 8px 12px;
            border: 1px solid #ddd;
            background-color: white;
            cursor: pointer;
            font-size: 14px;
        }

        .size-option:hover {
            border-color: #333;
        }

        .size-option.selected {
            background-color: #333;
            color: white;
        }

        .quantity-section {
            display: flex;
            align-items: center;
            justify-content: space-between;
            margin-bottom: 20px;
        }

        .quantity-controls {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .quantity-btn {
            width: 30px;
            height: 30px;
            border: 1px solid #ddd;
            background: white;
            cursor: pointer;
            font-size: 16px;
        }

        .quantity-input {
            width: 60px;
            height: 30px;
            text-align: center;
            border: 1px solid #ddd;
        }

        .total-price {
            font-size: 16px;
            font-weight: bold;
        }

        .action-buttons {
            display: flex;
            gap: 10px;
            margin-bottom: 30px;
        }

        .btn-wishlist {
            flex: 0 0 60px;
            height: 50px;
            border: 1px solid #ddd;
            background: white;
            cursor: pointer;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            font-size: 12px;
        }

        .btn-cart {
            flex: 1;
            height: 50px;
            border: 1px solid #333;
            background: white;
            cursor: pointer;
            font-size: 16px;
        }

        .btn-buy {
            flex: 1;
            height: 50px;
            background: #333;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
        }

        .delivery-section {
            border-top: 1px solid #eee;
            padding-top: 20px;
            margin-bottom: 30px;
        }

        .delivery-title {
            font-size: 16px;
            font-weight: bold;
            color: #ff6b35;
            margin-bottom: 15px;
        }

        .delivery-item {
            display: flex;
            align-items: center;
            padding: 8px 0;
            border-bottom: 1px solid #f5f5f5;
        }

        .delivery-icon {
            width: 20px;
            height: 20px;
            margin-right: 10px;
            border-radius: 50%;
        }

        .delivery-icon.fast {
            background-color: #333;
        }

        .delivery-icon.regular {
            background-color: #ffcc00;
        }

        .shipping-section {
            border-top: 1px solid #eee;
            padding-top: 20px;
            margin-bottom: 30px;
        }

        .shipping-title {
            font-size: 16px;
            font-weight: bold;
            color: #0066cc;
            margin-bottom: 15px;
        }

        .shipping-info {
            color: #666;
            font-size: 14px;
            line-height: 1.6;
        }

        .tags-section {
            border-top: 1px solid #eee;
            padding-top: 20px;
        }

        .tags-title {
            font-size: 14px;
            color: #666;
            margin-bottom: 10px;
        }

        .tags {
            display: flex;
            flex-wrap: wrap;
            gap: 8px;
        }

        .tag {
            padding: 4px 8px;
            background-color: #f5f5f5;
            border-radius: 2px;
            font-size: 12px;
            color: #666;
        }

        .action-section {
            display: flex;
            gap: 20px;
            margin-bottom: 30px;
        }

        .action-btn {
            flex: 1;
            height: 50px;
            border: 1px solid #ddd;
            background: white;
            cursor: pointer;
            font-size: 14px;
            color: #ff6b35;
        }

        .detail-section {
            border-top: 1px solid #eee;
            padding-top: 20px;
        }

        .detail-title {
            font-size: 16px;
            font-weight: bold;
            color: #ff6b35;
            margin-bottom: 15px;
        }

        .detail-content {
            color: #666;
            font-size: 14px;
            line-height: 1.8;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="nav">
        <span>MUSINSA</span>
        <span>BEAUTY</span>
        <span>PLAYER</span>
        <span>OUTLET</span>
        <span>BOUTIQUE</span>
        <span>SHOES</span>
        <span>KIDS</span>
        <span>USED</span>
        <span class="highlight">SNAP</span>
    </div>
</div>

<div class="container">
    <div class="page-title">상품 상세 목록</div>

    <div class="product-section">
        <div class="product-images">
            <div class="thumbnail-list">
                <div class="thumbnail active"></div>
                <div class="thumbnail"></div>
                <div class="thumbnail"></div>
                <div class="thumbnail"></div>
                <div class="thumbnail"></div>
                <div class="thumbnail"></div>
            </div>
            <div class="main-image">
                <button class="image-nav prev">‹</button>
                <button class="image-nav next">›</button>
            </div>
        </div>

        <div class="product-info">
            <div class="brand-info">
                무신사 스탠다드 <span class="brand-name">브랜드 초회</span>
                <div style="float: right; font-size: 12px;">♡ 96만</div>
            </div>
            <div style="clear: both;"></div>

            <div class="product-title">
                상의 > 반소매 티셔츠 무신사 스탠다드 홍 카테고리<br>
                올마이티 썸머 레저 셋업 [블랙] <span style="color: #ff6b35;">섬유 이름</span>
            </div>

            <div class="rating">
                <span class="star">★</span>
                <span>4.9</span>
                <span style="color: #999;">후기 183개</span>
                <span style="color: #ff6b35;">별점,리뷰 수</span>
            </div>

            <div class="delivery-info">
                🚚 오늘 22시까지 결제 시 내일(월) 도착예정 <span style="color: #ff6b35;">도착 정보</span>
            </div>

            <div class="price-section">
                <div class="original-price">59,900원</div>
                <div class="discount-price">
                    <span class="discount-badge">23,890원</span>
                    <span>가격(착한가격에 따른 할인율)</span>
                </div>
                <div class="final-price">23,070원 <span style="font-size: 14px; color: #ff4444;">최대할인가</span> ❤️ <span style="color: #ff6b35;">적립 정보</span></div>
                <div style="text-align: right; color: #999; font-size: 14px;">자세히 ></div>
                <div style="color: #ff6b35; font-size: 14px;">적립금</div>
                <div class="point-info">2,410원 최대적립</div>
                <div class="membership-info">등급 적립 (LV.5 실버 - 1.5%) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 340원</div>
            </div>

            <div class="size-section">
                <div class="size-label">
                    사이즈 <span class="size-guide">구매상품 사이즈 옵션 조회</span>
                </div>
                <div class="size-options">
                    <div class="size-option">S</div>
                    <div class="size-option">M</div>
                    <div class="size-option">L</div>
                    <div class="size-option">XL</div>
                    <div class="size-option">2XL</div>
                </div>
            </div>

            <div class="quantity-section">
                <div>XL</div>
                <div style="margin-left: auto;">X</div>
            </div>

            <div class="quantity-section">
                <div class="quantity-controls">
                    <button class="quantity-btn">-</button>
                    <input type="text" class="quantity-input" value="1">
                    <button class="quantity-btn">+</button>
                </div>
                <div class="total-price">23,890원</div>
            </div>

            <div class="action-buttons">
                <button class="btn-wishlist">
                    ♡<br>513
                </button>
                <button class="btn-cart">장바구니</button>
                <button class="btn-buy">구매하기</button>
            </div>

            <div class="delivery-section">
                <div class="delivery-title">결제혜택 <span style="color: #ff6b35;">결제 혜택</span></div>

                <div class="delivery-item">
                    <div class="delivery-icon fast"></div>
                    <div>무신사페이 x 무신사현대카드 1만 1천원 이상 결제 시 1만원 할인</div>
                </div>

                <div class="delivery-item">
                    <div class="delivery-icon regular"></div>
                    <div>카카오페이 x 페이북 12만원 이상 결제 시 1만원 할인</div>
                </div>

                <div class="delivery-item">
                    <div class="delivery-icon fast"></div>
                    <div>무신사페이 x 무신사현대카드 10만원 이상 결제 시 7천원 할인</div>
                </div>

                <div style="text-align: center; margin-top: 10px;">
                    <span style="color: #999;">13개 혜택 더보기 ></span>
                </div>
            </div>

            <div class="shipping-section">
                <div style="color: #666; font-size: 14px; margin-bottom: 10px;">
                    무신사 회원 전 품목 무료배송<br>
                    (일반 상품 및 도서 신간 지역 제외)
                </div>

                <div class="shipping-title">🚚 무료배송 ❤️ 도착 정보</div>
                <div class="shipping-info">
                    오늘 22시까지 결제 시 내일(월) 도착예정 • C.I.F택배운<br>
                    서울 관악구 신림동 498-54 기준 <span style="color: #0066cc; text-decoration: underline;">배송지 변경</span>
                </div>
            </div>

            <div class="tags-section">
                <div class="tags-title">이 상품의 연관 태그 <span style="color: #ff6b35;">연관 태그</span></div>
                <div class="tags">
                    <span class="tag">#반소매</span>
                    <span class="tag">#반팔</span>
                    <span class="tag">#셔츠</span>
                    <span class="tag">#셔츠차림</span>
                    <span class="tag">#아이템아이</span>
                    <span class="tag">#유니크</span>
                    <span class="tag">#프리미엄</span>
                </div>
            </div>
        </div>
    </div>

    <div class="action-section">
        <button class="action-btn">실물 정보 조회</button>
        <button class="action-btn">상품 정보 조회</button>
    </div>

    <div class="action-section">
        <button class="action-btn">사이즈 상세정보 조회</button>
        <button class="action-btn">사이즈 상세정보 조회</button>
    </div>

    <div class="detail-section">
        <div class="detail-title">상품 문의</div>
        <div class="detail-content">
            • 세탁 시 물빠짐<br>
            • 세탁 시 관리<br>
            • 원단 내부에서 사이징 원단시<br>
            특별한 나일론 • 스판덱스
        </div>
    </div>
</div>
</body>
</html>