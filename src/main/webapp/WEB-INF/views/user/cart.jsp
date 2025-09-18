<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>장바구니 | MUSINSA</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Malgun Gothic', 'Apple SD Gothic Neo', sans-serif;
            background-color: #f8f8f8;
            color: #333;
        }

        /* 헤더 스타일 */
        .header {
            background-color: #333;
            color: white;
            padding: 12px 0;
        }

        .header-content {
            max-width: 1200px;
            margin: 0 auto;
            display: flex;
            align-items: center;
            padding: 0 20px;
        }

        .menu-icon {
            margin-right: 20px;
            cursor: pointer;
            font-size: 18px;
        }

        .nav-menu {
            display: flex;
            gap: 30px;
            flex: 1;
        }

        .nav-item {
            color: white;
            text-decoration: none;
            font-size: 14px;
            font-weight: 500;
        }

        .nav-item.snap {
            color: #ff6b35;
        }

        .header-right {
            display: flex;
            align-items: center;
            gap: 15px;
            font-size: 12px;
        }

        .header-right a {
            color: white;
            text-decoration: none;
        }

        /* 메인 컨테이너 */
        .main-container {
            max-width: 1200px;
            margin: 30px auto;
            padding: 0 20px;
            display: flex;
            gap: 30px;
        }

        .cart-section {
            flex: 2;
            background-color: white;
            border-radius: 8px;
            padding: 30px;
        }

        .summary-section {
            flex: 1;
            background-color: white;
            border-radius: 8px;
            padding: 30px;
            height: fit-content;
            position: sticky;
            top: 30px;
        }

        /* 페이지 타이틀 */
        .page-title {
            font-size: 28px;
            font-weight: bold;
            margin-bottom: 30px;
            color: #333;
        }

        /* 탭 메뉴 */
        .tab-menu {
            display: flex;
            margin-bottom: 30px;
            border-bottom: 2px solid #f0f0f0;
        }

        .tab-item {
            padding: 15px 0;
            margin-right: 40px;
            color: #999;
            text-decoration: none;
            font-size: 16px;
            border-bottom: 2px solid transparent;
            transition: all 0.3s;
        }

        .tab-item.active {
            color: #ff6b35;
            border-bottom-color: #ff6b35;
            font-weight: bold;
        }

        /* 전체 선택 */
        .select-all {
            display: flex;
            align-items: center;
            padding: 20px 0;
            border-bottom: 1px solid #f0f0f0;
            margin-bottom: 20px;
        }

        .select-all input[type="checkbox"] {
            width: 18px;
            height: 18px;
            margin-right: 10px;
            accent-color: #333;
        }

        .select-all label {
            font-weight: bold;
            font-size: 16px;
            cursor: pointer;
        }

        .item-count {
            margin-left: auto;
            color: #999;
            font-size: 14px;
        }

        /* 브랜드 섹션 */
        .brand-section {
            margin-bottom: 30px;
        }

        .brand-header {
            display: flex;
            align-items: center;
            padding: 15px 0;
            border-bottom: 1px solid #f0f0f0;
            margin-bottom: 20px;
        }

        .brand-header input[type="checkbox"] {
            width: 18px;
            height: 18px;
            margin-right: 12px;
            accent-color: #333;
        }

        .brand-name {
            font-weight: bold;
            font-size: 16px;
        }

        .brand-link {
            color: #999;
            text-decoration: underline;
            margin-left: auto;
            font-size: 14px;
        }

        /* 상품 아이템 */
        .cart-item {
            display: flex;
            align-items: center;
            padding: 20px 0;
            border-bottom: 1px solid #f0f0f0;
            position: relative;
        }

        .cart-item:last-child {
            border-bottom: none;
        }

        .item-checkbox {
            width: 18px;
            height: 18px;
            margin-right: 15px;
            accent-color: #333;
        }

        .item-image {
            width: 80px;
            height: 100px;
            background-color: #f8f8f8;
            border-radius: 4px;
            margin-right: 15px;
            overflow: hidden;
        }

        .item-image img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .item-details {
            flex: 1;
        }

        .item-title {
            font-size: 16px;
            font-weight: 500;
            color: #333;
            margin-bottom: 5px;
            line-height: 1.4;
        }

        .item-info {
            color: #999;
            font-size: 14px;
            margin-bottom: 10px;
        }

        .item-price {
            display: flex;
            flex-direction: column;
            gap: 3px;
        }

        .original-price {
            color: #999;
            text-decoration: line-through;
            font-size: 14px;
        }

        .current-price {
            color: #333;
            font-size: 16px;
            font-weight: bold;
        }

        .remove-btn {
            position: absolute;
            top: 20px;
            right: 0;
            background: none;
            border: none;
            font-size: 20px;
            color: #999;
            cursor: pointer;
            width: 24px;
            height: 24px;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .remove-btn:hover {
            color: #333;
        }

        /* 액션 버튼 */
        .item-actions {
            display: flex;
            gap: 10px;
            margin-top: 15px;
        }

        .action-btn {
            padding: 8px 16px;
            border: 1px solid #ddd;
            background-color: white;
            color: #333;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            transition: all 0.3s;
        }

        .action-btn:hover {
            border-color: #333;
        }

        /* 결제 정보 섹션 */
        .summary-section h3 {
            font-size: 18px;
            margin-bottom: 20px;
            color: #333;
        }

        .price-detail {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 12px;
            font-size: 15px;
        }

        .price-label {
            color: #666;
        }

        .price-value {
            color: #333;
            font-weight: 500;
        }

        .discount-value {
            color: #ff4757;
            font-weight: 500;
        }

        .free-shipping {
            color: #2ed573;
            font-size: 14px;
        }

        .total-section {
            border-top: 2px solid #333;
            padding-top: 20px;
            margin-top: 20px;
        }

        .total-price {
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size: 20px;
            font-weight: bold;
            color: #333;
            margin-bottom: 15px;
        }

        .points-info {
            font-size: 14px;
            color: #999;
            margin-bottom: 20px;
        }

        .points-value {
            color: #333;
            font-weight: 500;
        }

        /* 결제 혜택 */
        .payment-benefits {
            margin-top: 30px;
        }

        .benefits-title {
            font-size: 16px;
            font-weight: bold;
            color: #ff6b35;
            margin-bottom: 15px;
        }

        .benefit-item {
            display: flex;
            align-items: center;
            padding: 10px 0;
            font-size: 14px;
            line-height: 1.4;
        }

        .benefit-icon {
            width: 20px;
            height: 20px;
            border-radius: 50%;
            margin-right: 10px;
            flex-shrink: 0;
        }

        .benefit-icon.black {
            background-color: #333;
        }

        .benefit-icon.blue {
            background-color: #0066cc;
        }

        .benefit-text {
            color: #333;
        }

        .benefit-link {
            color: #0066cc;
            text-decoration: none;
            margin-left: auto;
            white-space: nowrap;
        }

        /* 유의사항 */
        .notice-section {
            margin-top: 30px;
        }

        .notice-title {
            font-size: 16px;
            font-weight: bold;
            margin-bottom: 15px;
            display: flex;
            align-items: center;
            cursor: pointer;
        }

        .notice-arrow {
            margin-left: auto;
            transition: transform 0.3s;
        }

        .notice-content {
            font-size: 14px;
            color: #666;
            line-height: 1.6;
        }

        /* 구매하기 버튼 */
        .purchase-btn {
            width: 100%;
            padding: 18px;
            background-color: #333;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            margin-top: 20px;
            transition: background-color 0.3s;
        }

        .purchase-btn:hover {
            background-color: #555;
        }

        .purchase-btn:disabled {
            background-color: #ccc;
            cursor: not-allowed;
        }

        /* 반응형 */
        @media (max-width: 768px) {
            .main-container {
                flex-direction: column;
                gap: 20px;
                padding: 0 15px;
            }

            .cart-section,
            .summary-section {
                padding: 20px;
            }

            .cart-item {
                flex-direction: column;
                align-items: flex-start;
                gap: 15px;
            }

            .item-checkbox {
                position: absolute;
                top: 20px;
                left: 0;
            }

            .item-image {
                margin-left: 35px;
            }

            .remove-btn {
                position: absolute;
                top: 20px;
                right: 0;
            }
        }
    </style>
</head>
<body>
<!-- 헤더 -->
<header class="header">
    <div class="header-content">
        <div class="menu-icon">☰</div>
        <nav class="nav-menu">
            <a href="#" class="nav-item">MUSINSA</a>
            <a href="#" class="nav-item">BEAUTY</a>
            <a href="#" class="nav-item">PLAYER</a>
            <a href="#" class="nav-item">OUTLET</a>
            <a href="#" class="nav-item">BOUTIQUE</a>
            <a href="#" class="nav-item">SHOES</a>
            <a href="#" class="nav-item">KIDS</a>
            <a href="#" class="nav-item">USED</a>
            <a href="#" class="nav-item snap">SNAP</a>
        </nav>
        <div class="header-right">
            <a href="#">오프라인 스토어</a>
            <span>|</span>
            <a href="#">검색</a>
            <span>|</span>
            <a href="#">통합검색</a>
            <span>|</span>
            <a href="#">마이</a>
            <span>|</span>
            <a href="#">찜하기</a>
            <span>|</span>
            <a href="#">로그인/회원가입</a>
        </div>
    </div>
</header>

<!-- 메인 컨테이너 -->
<div class="main-container">
    <!-- 장바구니 섹션 -->
    <div class="cart-section">
        <h1 class="page-title">장바구니</h1>

        <!-- 탭 메뉴 -->
        <nav class="tab-menu">
            <a href="#" class="tab-item active">상품</a>
            <a href="#" class="tab-item">묶음</a>
        </nav>

        <!-- 전체 선택 -->
        <div class="select-all">
            <input type="checkbox" id="selectAll" checked>
            <label for="selectAll">전체 선택</label>
            <span class="item-count">선택 상품</span>
        </div>

        <!-- 댄컴마 브랜드 섹션 -->
        <div class="brand-section">
            <div class="brand-header">
                <input type="checkbox" id="brand1" checked>
                <span class="brand-name">댄컴마</span>
                <a href="#" class="brand-link">브랜드숍</a>
            </div>

            <!-- 상품 아이템 1 -->
            <div class="cart-item">
                <input type="checkbox" class="item-checkbox" checked>
                <div class="item-image">
                    <img src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iODAiIGhlaWdodD0iMTAwIiB2aWV3Qm94PSIwIDAgODAgMTAwIiBmaWxsPSJub25lIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPgo8cmVjdCB3aWR0aD0iODAiIGhlaWdodD0iMTAwIiBmaWxsPSIjMzMzIi8+Cjx0ZXh0IHg9IjQwIiB5PSI1NSIgZm9udC1mYW1pbHk9IkFyaWFsIiBmb250LXNpemU9IjEwIiBmaWxsPSJ3aGl0ZSIgdGV4dC1hbmNob3I9Im1pZGRsZSI+U3dlYXRzaGlydDwvdGV4dD4KPHN2Zz4K" alt="추슬히칩 시보아나넌 아타드리 스웨트셔츠">
                </div>
                <div class="item-details">
                    <div class="item-title">추슬히칩 시보아나넌 아타드리 스웨트셔츠</div>
                    <div class="item-info">M / 1개</div>
                    <div class="item-price">
                        <div class="original-price">60,000원</div>
                        <div class="current-price">29,900원</div>
                    </div>
                    <div class="item-actions">
                        <button class="action-btn">옵션 변경</button>
                        <button class="action-btn">쿠폰 사용</button>
                    </div>
                </div>
                <button class="remove-btn">×</button>
            </div>
        </div>

        <!-- 글리 브랜드 섹션 -->
        <div class="brand-section">
            <div class="brand-header">
                <input type="checkbox" id="brand2" checked>
                <span class="brand-name">글리</span>
                <a href="#" class="brand-link">브랜드숍</a>
            </div>

            <!-- 상품 아이템 2 -->
            <div class="cart-item">
                <input type="checkbox" class="item-checkbox" checked>
                <div class="item-image">
                    <img src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iODAiIGhlaWdodD0iMTAwIiB2aWV3Qm94PSIwIDAgODAgMTAwIiBmaWxsPSJub25lIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPgo8cmVjdCB3aWR0aD0iODAiIGhlaWdodD0iMTAwIiBmaWxsPSIjNjY5OUNDIi8+Cjx0ZXh0IHg9IjQwIiB5PSI1NSIgZm9udC1mYW1pbHk9IkFyaWFsIiBmb250LXNpemU9IjEwIiBmaWxsPSJ3aGl0ZSIgdGV4dC1hbmNob3I9Im1pZGRsZSI+U2V0PC90ZXh0Pgo8L3N2Zz4K" alt="추슬히칩 레디백 우몬가니러기저세 Set">
                </div>
                <div class="item-details">
                    <div class="item-title">추슬히칩 레디백 우몬가니러기저세 Set</div>
                    <div class="item-info">FREE / 1개</div>
                    <div class="item-price">
                        <div class="current-price">38,000원</div>
                    </div>
                    <div class="item-actions">
                        <button class="action-btn">옵션 변경</button>
                        <button class="action-btn">쿠폰 사용</button>
                    </div>
                </div>
                <button class="remove-btn">×</button>
            </div>
        </div>
    </div>

    <!-- 결제 정보 섹션 -->
    <div class="summary-section">
        <h3>구매 금액 <span style="color: #ff6b35;">구매 정보</span></h3>

        <div class="price-detail">
            <span class="price-label">상품 금액</span>
            <span class="price-value">98,000원</span>
        </div>

        <div class="price-detail">
            <span class="price-label">할인 금액</span>
            <span class="discount-value">-30,100원</span>
        </div>

        <div class="price-detail">
            <span class="price-label">배송비</span>
            <span class="free-shipping">무료배송</span>
        </div>

        <div class="total-section">
            <div class="price-detail total-price">
                <span>총 구매 금액</span>
                <span>67,900원</span>
            </div>

            <div class="price-detail">
                <span class="price-label">등급 적립</span>
                <span class="points-value">최대 10,000원</span>
            </div>
        </div>

        <!-- 결제 혜택 -->
        <div class="payment-benefits">
            <div class="benefits-title">결제 혜택 <span style="margin-left: auto; font-size: 14px; color: #999; font-weight: normal;">더보기</span></div>

            <div class="benefit-item">
                <div class="benefit-icon black"></div>
                <span class="benefit-text">무신사 현대카드 최대 3만원 즉시 할인</span>
                <a href="#" class="benefit-link">할인 받기</a>
            </div>

            <div class="benefit-item">
                <div style="background-color: #ffcc00; width: 20px; height: 20px; border-radius: 50%; margin-right: 10px; flex-shrink: 0; position: relative;">
                    <span style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); font-size: 10px; font-weight: bold;">M</span>
                </div>
                <span class="benefit-text">무신사머니 첫 결제 시 10% 추가 적립</span>
                <span style="color: #999; margin-left: auto; font-size: 14px;">혜택받기</span>
            </div>
        </div>

        <!-- 유의사항 -->
        <div class="notice-section">
            <div class="notice-title">
                <span>유의사항</span>
                <span class="notice-arrow">▼</span>
            </div>

            <div class="notice-content">
                <strong>LV1 혜택</strong> <span style="color: #0066cc;">최대 40,100원 혜택 ></span>
            </div>
        </div>

        <!-- 구매하기 버튼 -->
        <button class="purchase-btn">67,900원 구매하기 (2개)</button>
    </div>
</div>

<script>
    // 전체 선택 체크박스
    document.getElementById('selectAll').addEventListener('change', function() {
        const isChecked = this.checked;
        const itemCheckboxes = document.querySelectorAll('.item-checkbox');
        const brandCheckboxes = document.querySelectorAll('.brand-header input[type="checkbox"]');

        itemCheckboxes.forEach(checkbox => {
            checkbox.checked = isChecked;
        });

        brandCheckboxes.forEach(checkbox => {
            checkbox.checked = isChecked;
        });

        updatePurchaseButton();
    });

    // 개별 상품 체크박스
    document.querySelectorAll('.item-checkbox').forEach(checkbox => {
        checkbox.addEventListener('change', function() {
            updateSelectAll();
            updatePurchaseButton();
        });
    });

    // 브랜드 체크박스
    document.querySelectorAll('.brand-header input[type="checkbox"]').forEach(checkbox => {
        checkbox.addEventListener('change', function() {
            const brandSection = this.closest('.brand-section');
            const itemCheckboxes = brandSection.querySelectorAll('.item-checkbox');

            itemCheckboxes.forEach(item => {
                item.checked = this.checked;
            });

            updateSelectAll();
            updatePurchaseButton();
        });
    });

    // 전체 선택 상태 업데이트
    function updateSelectAll() {
        const allItems = document.querySelectorAll('.item-checkbox');
        const checkedItems = document.querySelectorAll('.item-checkbox:checked');
        const selectAllCheckbox = document.getElementById('selectAll');

        selectAllCheckbox.checked = allItems.length === checkedItems.length && allItems.length > 0;
    }

    // 구매 버튼 업데이트
    function updatePurchaseButton() {
        const checkedItems = document.querySelectorAll('.item-checkbox:checked');
        const purchaseBtn = document.querySelector('.purchase-btn');

        if (checkedItems.length === 0) {
            purchaseBtn.textContent = '상품을 선택해주세요';
            purchaseBtn.disabled = true;
        } else {
            purchaseBtn.textContent = `67,900원 구매하기 (${checkedItems.length}개)`;
            purchaseBtn.disabled = false;
        }
    }

    // 삭제 버튼
    document.querySelectorAll('.remove-btn').forEach(btn => {
        btn.addEventListener('click', function() {
            if (confirm('상품을 장바구니에서 삭제하시겠습니까?')) {
                const cartItem = this.closest('.cart-item');
                cartItem.remove();
                updateSelectAll();
                updatePurchaseButton();
            }
        });
    });

    // 옵션 변경 버튼
    document.querySelectorAll('.action-btn').forEach(btn => {
        btn.addEventListener('click', function() {
            if (this.textContent === '옵션 변경') {
                alert('옵션 변경 기능');
            } else if (this.textContent === '쿠폰 사용') {
                alert('쿠폰 사용 기능');
            }
        });
    });

    // 구매하기 버튼
    document.querySelector('.purchase-btn').addEventListener('click', function() {
        const checkedItems = document.querySelectorAll('.item-checkbox:checked');

        if (checkedItems.length === 0) {
            alert('구매할 상품을 선택해주세요.');
            return;
        }

        alert(`${checkedItems.length}개 상품을 구매합니다.`);
    });

    // 유의사항 토글
    document.querySelector('.notice-title').addEventListener('click', function() {
        const arrow = this.querySelector('.notice-arrow');
        const content = this.nextElementSibling;

        if (content.style.display === 'none') {
            content.style.display = 'block';
            arrow.textContent = '▼';
        } else {
            content.style.display = 'none';
            arrow.textContent = '▶';
        }
    });

    // 초기 상태 설정
    updatePurchaseButton();
</script>
</body>
</html>