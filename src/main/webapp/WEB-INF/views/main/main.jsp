<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MUSINSA - 무신사</title>
    <link rel="stylesheet" href="/css/header.css">
    <script src="/js/header.js" defer></script>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }


        body {
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
            background-color: #f8f9fa;
        }

        /* Header */
        .header {
            background-color: #000;
            color: white;
            padding: 0;
            position: sticky;
            top: 0;
            z-index: 1000;
        }

        .header-top {
            background-color: #333;
            padding: 8px 0;
            font-size: 12px;
            text-align: right;
            padding-right: 20px;
        }

        .header-top a {
            color: #ccc;
            text-decoration: none;
            margin: 0 5px;
        }

        .header-main {
            display: flex;
            align-items: center;
            padding: 15px 20px;
        }

        .menu-btn {
            background: none;
            border: none;
            color: white;
            font-size: 18px;
            margin-right: 20px;
            cursor: pointer;
        }

        .logo {
            font-size: 24px;
            font-weight: bold;
            margin-right: 30px;
        }

        .nav-menu {
            display: flex;
            list-style: none;
            margin: 0;
            padding: 0;
        }

        .nav-menu li {
            margin-right: 30px;
        }

        .nav-menu a {
            color: white;
            text-decoration: none;
            font-weight: 500;
            font-size: 14px;
        }

        .search-container {
            flex: 1;
            max-width: 600px;
            margin-left: auto;
            margin-right: 20px;
        }

        .search-box {
            width: 100%;
            padding: 15px 20px;
            border: none;
            border-radius: 25px;
            background-color: #fff;
            color: #333;
            font-size: 14px;
        }

        .user-menu {
            display: flex;
            align-items: center;
            gap: 15px;
        }

        .notification-btn {
            background: none;
            border: none;
            color: white;
            font-size: 18px;
            cursor: pointer;
        }

        /* Sidebar */
        .sidebar-overlay {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.6);
            z-index: 2000;
            display: none;
        }
        .sidebar-overlay.show {
            display: block;
        }

        .sidebar {
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%) scale(0);
            width: 600px;
            max-width: 90vw;
            height: 500px;
            max-height: 80vh;
            background-color: white;
            z-index: 2001;
            transition: transform 0.3s ease;
            overflow-y: auto;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
        }

        .sidebar.open {
            transform: translate(-50%, -50%) scale(1);
        }

        .sidebar-header {
            background-color: #f8f9fa;
            padding: 15px 20px;
            border-bottom: 1px solid #dee2e6;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .sidebar-title {
            font-size: 18px;
            font-weight: bold;
            color: #333;
        }

        .close-btn {
            background: none;
            border: none;
            font-size: 20px;
            cursor: pointer;
            color: #666;
        }

        .tab-buttons {
            display: flex;
            background-color: #f8f9fa;
            border-bottom: 1px solid #dee2e6;
        }

        .tab-btn {
            flex: 1;
            padding: 15px 20px;
            background: none;
            border: none;
            font-size: 16px;
            font-weight: 500;
            cursor: pointer;
            color: #666;
            border-bottom: 3px solid transparent;
            transition: all 0.2s;
        }

        .tab-btn.active {
            color: #333;
            border-bottom-color: #007bff;
            background-color: white;
        }

        .tab-content {
            display: none;
            padding: 20px;
        }

        .tab-content.active {
            display: block;
        }

        /* 상품 카테고리 스타일 */
        .category-section {
            margin-bottom: 30px;
        }

        .category-title {
            font-size: 16px;
            font-weight: bold;
            color: #333;
            margin-bottom: 15px;
            padding-bottom: 8px;
            border-bottom: 2px solid #f0f0f0;
        }

        .category-grid {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 20px;
        }

        .category-item {
            text-align: center;
            cursor: pointer;
            padding: 15px 10px;
            border-radius: 8px;
            transition: background-color 0.2s;
        }

        .category-item:hover {
            background-color: #f8f9fa;
        }

        .category-icon {
            width: 50px;
            height: 50px;
            background-color: #e9ecef;
            border-radius: 50%;
            margin: 0 auto 10px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 24px;
            color: #666;
        }

        .category-name {
            font-size: 12px;
            color: #333;
            font-weight: 500;
        }

        /* 브랜드 리스트 스타일 */
        .brand-search {
            margin-bottom: 20px;
        }

        .brand-search input {
            width: 100%;
            padding: 12px 15px;
            border: 1px solid #dee2e6;
            border-radius: 6px;
            font-size: 14px;
        }

        .brand-alphabet {
            display: flex;
            flex-wrap: wrap;
            gap: 5px;
            margin-bottom: 20px;
            padding-bottom: 15px;
            border-bottom: 1px solid #f0f0f0;
        }

        .alphabet-btn {
            width: 30px;
            height: 30px;
            background: none;
            border: 1px solid #dee2e6;
            border-radius: 4px;
            font-size: 12px;
            cursor: pointer;
            color: #666;
            transition: all 0.2s;
        }

        .alphabet-btn:hover,
        .alphabet-btn.active {
            background-color: #007bff;
            color: white;
            border-color: #007bff;
        }

        .brand-list {
            max-height: 400px;
            overflow-y: auto;
        }

        .brand-item {
            display: flex;
            align-items: center;
            padding: 12px 0;
            border-bottom: 1px solid #f8f9fa;
            cursor: pointer;
            transition: background-color 0.2s;
        }

        .brand-item:hover {
            background-color: #f8f9fa;
            margin: 0 -20px;
            padding-left: 20px;
            padding-right: 20px;
        }

        .brand-logo {
            width: 40px;
            height: 40px;
            background-color: #f8f9fa;
            border-radius: 4px;
            margin-right: 15px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 12px;
            font-weight: bold;
            color: #666;
        }

        .brand-info {
            flex: 1;
        }

        .brand-name {
            font-size: 14px;
            font-weight: 500;
            color: #333;
            margin-bottom: 2px;
        }

        .brand-name-eng {
            font-size: 11px;
            color: #999;
            text-transform: uppercase;
        }

        .like-btn {
            width: 30px;
            height: 30px;
            background: none;
            border: 1px solid #dee2e6;
            border-radius: 50%;
            cursor: pointer;
            color: #ccc;
            transition: all 0.2s;
        }

        .like-btn:hover {
            color: #e74c3c;
            border-color: #e74c3c;
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
            /* 호버 효과 제거 - transform transition 제거 */
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

            .nav-menu {
                display: none;
            }

            .search-container {
                max-width: 200px;
            }

            .category-grid {
                grid-template-columns: repeat(2, 1fr);
                gap: 15px;
            }
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>

<!-- Sidebar Overlay -->
<div class="sidebar-overlay" id="sidebarOverlay"></div>

<!-- Sidebar -->
<div class="sidebar" id="sidebar">
    <div class="sidebar-header">
        <div class="sidebar-title">카테고리</div>
        <button class="close-btn" id="closeSidebar">✕</button>
    </div>

    <div class="tab-buttons">
        <button class="tab-btn active" data-tab="products">상품</button>
        <button class="tab-btn" data-tab="brands">브랜드</button>
    </div>

    <div class="sidebar-content">
        <!-- 상품 탭 -->
        <div class="tab-content active" id="products-tab">
            <div class="category-section">
                <div class="category-title">상의</div>
                <div class="category-grid">
                    <div class="category-item">
                        <div class="category-icon">👕</div>
                        <div class="category-name">맨투맨/스웨트</div>
                    </div>
                    <div class="category-item">
                        <div class="category-icon">🧥</div>
                        <div class="category-name">후드 티셔츠</div>
                    </div>
                    <div class="category-item">
                        <div class="category-icon">👔</div>
                        <div class="category-name">셔츠/블라우스</div>
                    </div>
                    <div class="category-item">
                        <div class="category-icon">👔</div>
                        <div class="category-name">긴소매 티셔츠</div>
                    </div>
                    <div class="category-item">
                        <div class="category-icon">👕</div>
                        <div class="category-name">민소매 티셔츠</div>
                    </div>
                    <div class="category-item">
                        <div class="category-icon">🧥</div>
                        <div class="category-name">피케/카라 티셔츠</div>
                    </div>
                    <div class="category-item">
                        <div class="category-icon">🧥</div>
                        <div class="category-name">니트/스웨터</div>
                    </div>
                    <div class="category-item">
                        <div class="category-icon">👕</div>
                        <div class="category-name">민소매 티셔츠</div>
                    </div>
                    <div class="category-item">
                        <div class="category-icon">👔</div>
                        <div class="category-name">기타 상의</div>
                    </div>
                </div>
            </div>

            <div class="category-section">
                <div class="category-title">아우터</div>
                <div class="category-grid">
                    <div class="category-item">
                        <div class="category-icon">🧥</div>
                        <div class="category-name">후드 집업</div>
                    </div>
                    <div class="category-item">
                        <div class="category-icon">🧥</div>
                        <div class="category-name">블루종/MA-1</div>
                    </div>
                    <div class="category-item">
                        <div class="category-icon">🧥</div>
                        <div class="category-name">레더/라이더스 재킷</div>
                    </div>
                    <div class="category-item">
                        <div class="category-icon">🧥</div>
                        <div class="category-name">카디건</div>
                    </div>
                    <div class="category-item">
                        <div class="category-icon">🧥</div>
                        <div class="category-name">트러커 재킷</div>
                    </div>
                    <div class="category-item">
                        <div class="category-icon">🧥</div>
                        <div class="category-name">수트/블레이져 재킷</div>
                    </div>
                </div>
            </div>
        </div>

        <!-- 브랜드 탭 -->
        <div class="tab-content" id="brands-tab">
            <div class="brand-search">
                <input type="text" placeholder="브랜드를 검색해보세요" id="brandSearchInput">
            </div>

            <div class="brand-alphabet">
                <button class="alphabet-btn">전체</button>
                <button class="alphabet-btn active">ㄱ</button>
                <button class="alphabet-btn">ㄴ</button>
                <button class="alphabet-btn">ㄷ</button>
                <button class="alphabet-btn">ㄹ</button>
                <button class="alphabet-btn">ㅁ</button>
                <button class="alphabet-btn">ㅂ</button>
                <button class="alphabet-btn">ㅅ</button>
                <button class="alphabet-btn">ㅇ</button>
                <button class="alphabet-btn">ㅈ</button>
                <button class="alphabet-btn">A</button>
                <button class="alphabet-btn">B</button>
                <button class="alphabet-btn">C</button>
                <button class="alphabet-btn">D</button>
                <button class="alphabet-btn">E</button>
                <button class="alphabet-btn">기타</button>
            </div>

            <div class="brand-list" id="brandList">
                <div class="brand-item">
                    <div class="brand-logo">AD</div>
                    <div class="brand-info">
                        <div class="brand-name">아디다스</div>
                        <div class="brand-name-eng">ADIDAS</div>
                    </div>
                    <button class="like-btn">♡</button>
                </div>
                <div class="brand-item">
                    <div class="brand-logo">NK</div>
                    <div class="brand-info">
                        <div class="brand-name">나이키</div>
                        <div class="brand-name-eng">NIKE</div>
                    </div>
                    <button class="like-btn">♡</button>
                </div>
                <div class="brand-item">
                    <div class="brand-logo">PM</div>
                    <div class="brand-info">
                        <div class="brand-name">푸마</div>
                        <div class="brand-name-eng">PUMA</div>
                    </div>
                    <button class="like-btn">♡</button>
                </div>
                <div class="brand-item">
                    <div class="brand-logo">NF</div>
                    <div class="brand-info">
                        <div class="brand-name">노스페이스</div>
                        <div class="brand-name-eng">THE NORTH FACE</div>
                    </div>
                    <button class="like-btn">♡</button>
                </div>
                <div class="brand-item">
                    <div class="brand-logo">MK</div>
                    <div class="brand-info">
                        <div class="brand-name">마틴킴</div>
                        <div class="brand-name-eng">MARTIN KIM</div>
                    </div>
                    <button class="like-btn">♡</button>
                </div>
                <div class="brand-item">
                    <div class="brand-logo">NB</div>
                    <div class="brand-info">
                        <div class="brand-name">뉴발란스</div>
                        <div class="brand-name-eng">NEW BALANCE</div>
                    </div>
                    <button class="like-btn">♡</button>
                </div>
                <div class="brand-item">
                    <div class="brand-logo">AS</div>
                    <div class="brand-info">
                        <div class="brand-name">아식스</div>
                        <div class="brand-name-eng">ASICS</div>
                    </div>
                    <button class="like-btn">♡</button>
                </div>
                <div class="brand-item">
                    <div class="brand-logo">DM</div>
                    <div class="brand-info">
                        <div class="brand-name">닥터마틴</div>
                        <div class="brand-name-eng">DR.MARTENS</div>
                    </div>
                    <button class="like-btn">♡</button>
                </div>
            </div>
        </div>
    </div>
</div>

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
</body>
</html>