<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8"/>
    <title>장바구니</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">

    <style>
        /* General Body & Main Content Styles */
        body {
            font-family: 'Noto Sans KR', -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }

        /* ===== Page container ===== */
        .container {
            max-width: 1180px;
            margin: 0 auto;
            padding: 24px 16px
        }

        /* 이하 장바구니 전용 스타일 그대로 유지 */
        .page-title {
            font-weight: 700;
            font-size: 20px;
            margin-bottom: 6px
        }

        .summary-sub {
            color: #868e96;
            font-size: 13px
        }

        .grid {
            display: grid;
            grid-template-columns:1fr 360px;
            gap: 24px;
            margin-top: 12px
        }

        @media (max-width: 1024px) {
            .grid {
                grid-template-columns:1fr
            }
        }

        .bar {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 10px 12px;
            border: 1px solid #eee;
            border-radius: 10px;
            background: #fff
        }

        .bar-left {
            display: flex;
            align-items: center;
            gap: 12px
        }

        .muted {
            color: #9aa1a7;
            font-size: 13px
        }

        .btn-ghost {
            border: 1px solid #ddd;
            background: #fff
        }

        .btn-ghost.small {
            padding: 6px 10px;
            font-size: 12px
        }

        .list {
            margin-top: 12px;
            border: 1px solid #eee;
            border-radius: 12px;
            overflow: hidden;
            background: #fff
        }

        .brand-row {
            padding: 14px 16px;
            border-bottom: 1px solid #f1f3f5;
            display: flex;
            align-items: center;
            gap: 10px;
            background: #fff
        }

        .brand-name {
            font-weight: 700
        }

        .items {
            display: flex;
            flex-direction: column
        }

        .item {
            display: grid;
            grid-template-columns:24px 84px 1fr 24px;
            gap: 14px;
            padding: 14px 16px;
            border-bottom: 1px solid #f6f7f8
        }

        .item:last-child {
            border-bottom: 0
        }

        .thumb {
            width: 84px;
            height: 84px;
            border: 1px solid #eee;
            border-radius: 8px;
            overflow: hidden;
            background: #fafafa
        }

        .name {
            font-weight: 600
        }

        .meta {
            color: #98a1a8;
            font-size: 12px;
            margin-top: 2px
        }

        .price {
            font-weight: 700;
            margin-top: 8px
        }

        .row-ctrls {
            grid-column: 1 / -1;
            margin: 0;
            display: flex;
            justify-content: center;
        }

        .btn-opt {
            border-radius: 5px;
            margin-left: 32px;
            margin-bottom: 15px;
            margin-right: 2px;
            width: 716px;
            height: 25px

        }

        .x-btn {
            opacity: .6;
            cursor: pointer;
        }

        .x-btn:hover {
            opacity: 1
        }

        .checkbox {
            display: flex;
            align-items: center;
            justify-content: center
        }

        .checkbox input {
            width: 16px;
            height: 16px
        }

        .right {
            position: relative
        }

        .sticky {
            position: sticky;
            top: 16px
        }

        .panel {
            background: #fff;
            border: 1px solid #eee;
            border-radius: 12px;
            padding: 16px 16px 10px
        }

        .panel h4 {
            margin: 0 0 10px 0;
            font-size: 16px
        }

        .kv {
            display: flex;
            justify-content: space-between;
            margin: 8px 0
        }

        .kv .k {
            color: #616a73
        }

        .kv .v {
            font-weight: 600
        }

        .big {
            font-size: 18px
        }

        .emph {
            color: #e03131;
            font-weight: 800
        }

        .hint {
            color: #9aa1a7;
            font-size: 12px
        }

        .divider {
            height: 1px;
            background: #f1f3f5;
            margin: 12px 0
        }

        .coupon-panel {
            margin-top: 12px;
            padding: 12px;
            border: 1px solid #e9ecef;
            border-radius: 12px;
            background: #f8f9fa
        }

        .notice {
            margin-top: 12px
        }

        .banner {
            margin-top: 12px;
            border: 1px solid #e9ecef;
            border-radius: 12px;
            padding: 12px;
            background: #f8f9ff
        }

        .help {
            font-size: 12px;
            color: #66707a
        }

        .chip {
            display: inline-block;
            padding: 2px 6px;
            border: 1px solid #e9ecef;
            border-radius: 999px;
            font-size: 11px;
            color: #66707a;
            margin-left: 6px
        }

        .badge-free {
            color: #2f9e44;
            border-color: #b2f2bb
        }

        .badge-fast {
            color: #1c7ed6;
            border-color: #a5d8ff
        }

        .btn-ghost {
            cursor: pointer;
        }

    </style>

    <style>
        /* --- modal --- */
        .modal {
            display: none;
            position: fixed;
            inset: 0;
            z-index: 1000;
        }

        .modal.is-open {
            display: block;
        }

        .modal-backdrop {
            position: absolute;
            inset: 0;
            background: rgba(0, 0, 0, .35);
        }

        .modal-sheet {
            position: absolute;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
            width: min(560px, 92vw);
            background: #fff;
            border: 1px solid #eee;
            border-radius: 12px;
            overflow: hidden;
            box-shadow: 0 10px 30px rgba(0, 0, 0, .15);
        }

        .modal-header, .modal-footer {
            padding: 12px 14px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            border-bottom: 1px solid #f1f3f5;
        }

        .modal-footer {
            border-top: 1px solid #f1f3f5;
            border-bottom: none;
        }

        .modal-body {
            padding: 14px;
            max-height: 65vh;
            overflow: auto;
        }

        .modal-close {
            background: none;
            border: none;
            font-size: 16px;
            cursor: pointer;
        }

        .modal .chip {
            margin-left: 6px;
        }

        .modal input[type="text"], .modal input[type="number"], .modal select {
            padding: 8px 10px;
            border: 1px solid #e9ecef;
            border-radius: 8px;
            font-size: 14px;
        }

    </style>
</head>
<body>
<%@ include file="main/header.jsp" %>


<!-- ===== 본문 ===== -->
<div class="container" data-user-id="<%= request.getAttribute("userId") %>">
    <div class="page-title">장바구니 <span class="summary-sub" id="cart-count">전체 0</span></div>

    <!-- 상단 선택/삭제 바 -->
    <div class="bar">
        <div class="bar-left">
            <label class="checkbox"><input type="checkbox" id="select-all"/></label>
            <div>전체 선택</div>
            <div class="muted" id="soldout-note" style="display:none;">품절된 상품이 있습니다.</div>
        </div>
        <div class="bar-right">
            <button class="btn-ghost small" id="btn-remove-selected">선택 삭제</button>
        </div>
    </div>

    <div class="grid">
        <!-- Left: 리스트 -->
        <div>
            <div id="brand-lists" class="list" style="display:none;"></div>
        </div>

        <!-- Right: 요약 -->
        <aside class="right">
            <div class="sticky">
                <div class="panel">
                    <h4>구매 금액</h4>
                    <div class="kv">
                        <div class="k">상품 금액</div>
                        <div class="v" id="sum-product">-</div>
                    </div>
                    <div class="kv">
                        <div class="k">할인 금액</div>
                        <div class="v" id="sum-discount" style="color:#1c7ed6;">-</div>
                    </div>
                    <div class="kv">
                        <div class="k">배송비</div>
                        <div class="v">무료배송</div>
                    </div>
                    <div class="divider"></div>
                    <div class="kv big">
                        <div class="k">총 구매 금액</div>
                        <div class="v"><span id="sum-final">-</span> <span class="emph" id="disc-rate"></span></div>
                    </div>
                    <div class="hint" id="benefit-hint">적립혜택 예상 최대 0원</div>
                </div>

                <div class="panel" style="margin-top:12px;">
                    <h4>결제 혜택</h4>
                    <div class="kv help">
                        <div>즉시 할인</div>
                        <div>카드/간편결제 적용</div>
                    </div>
                    <div class="divider"></div>
                    <div class="kv help">
                        <div>무신사 현대카드 혜택</div>
                        <div>
                            <button class="btn-ghost small">할인 받기</button>
                        </div>
                    </div>
                    <div class="coupon-panel">
                        <div style="display:flex;align-items:center;gap:10px;">
                            <div style="width:36px;height:36px;border-radius:8px;border:1px solid #e9ecef;display:flex;align-items:center;justify-content:center;">
                                ₩
                            </div>
                            <div style="flex:1;">
                                <div>첫 결제 시 <b>10% 추가 적립</b></div>
                                <div class="help">혜택은 결제 수단에 따라 상이할 수 있어요</div>
                            </div>
                            <button class="btn-ghost small">혜택확인</button>
                        </div>
                    </div>
                </div>

                <div class="panel notice">
                    <h4>유의사항</h4>
                    <div class="help">쿠폰/적립 적용 조건은 주문서에서 최종 확정됩니다.</div>
                </div>

                <div class="banner">
                    <div class="help">인기 아우터 3000원 장바구니 쿠폰 • 지금 구매 시 장바구니 즉시 적용!</div>
                </div>
            </div>
        </aside>
    </div>
</div>

<div id="option-modal" class="modal" aria-hidden="true">
    <div class="modal-backdrop" data-close-modal></div>

    <div class="modal-sheet" role="dialog" aria-modal="true" aria-labelledby="option-modal-title">
        <div class="modal-header">
            <strong id="option-modal-title">옵션 변경</strong>
            <button class="modal-close" data-close-modal>✕</button>
        </div>

        <div class="modal-body">
            <div class="help" style="margin-bottom:8px;">
                상품: <b id="opt-name"></b> <span class="chip" id="opt-brand-chip"></span>
            </div>

            <div style="display:grid;grid-template-columns:120px 1fr;gap:10px;align-items:center;">
                <label>옵션명</label>
                <input id="opt-optionName" type="text" placeholder="예: 블랙 / M"/>

                <label>수량</label>
                <input id="opt-qty" type="number" min="1" value="1" style="width:120px"/>
            </div>

            <div class="divider" style="margin:14px 0;"></div>
            <div class="help" id="opt-price-preview">변경 후 금액 미리보기: -</div>
        </div>

        <div class="modal-footer">
            <button class="btn-ghost small" data-close-modal>취소</button>
            <button id="opt-save" class="btn-ghost small">적용</button>
        </div>
    </div>
</div>


<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<script>
    (function () {
        // ========== 상수/도우미 ==========
        var DISCOUNT_RATE = 0.08;

        function toCurrency(n) {
            n = n || 0;
            return n.toLocaleString('ko-KR') + '원';
        }

        var $container = $('.container');
        var userId = $container.data('user-id');
        var BASE = '<%= request.getContextPath() %>'; // 보통 "" 또는 "/앱컨텍스트"

        // 전역 상태 (가능한 단순한 형태 유지)
        var state = {
            raw: [],              // 전체 상품 목록
            groups: {},           // { 브랜드명: [상품, ...] }
            order: [],            // 브랜드 표시 순서
            selected: new Set(),  // 선택된 productId 모음
            soldoutExists: false  // 품절 안내 표시 여부 (현재 예비 필드)
        };

        // ========== API 호출 ==========
        function fetchCart(onSuccess, onError) {
            var url = BASE + '/api/v1/carts/' + userId;
            $.getJSON(url)
                .done(function (list) {
                    if (typeof onSuccess === 'function') onSuccess(list || []);
                })
                .fail(function () {
                    if (typeof onError === 'function') onError();
                });
        }

        // ========== 그룹화 ==========
        function buildGroups(list) {
            var groups = {};
            var order = [];

            for (var i = 0; i < list.length; i++) {
                var item = list[i];
                var brand = item.productBrand || '기타';

                if (!groups[brand]) {
                    groups[brand] = [];
                    order.push(brand);
                }
                groups[brand].push(item);
            }
            return {g: groups, order: order};
        }

        function recalcGroupsFromRaw() {
            var gb = buildGroups(state.raw);
            state.groups = gb.g;
            state.order = gb.order;
        }

        // ========== 렌더링 ==========
        function clearRoot() {
            var $root = $('#brand-lists');
            $root.empty();
            return $root;
        }

        function renderBrandHeader(brand) {
            // 단순한 문자열 + jQuery 래핑
            var html = '' +
                '<div class="brand-row">' +
                '<label class="checkbox"><input type="checkbox" class="brand-check"></label>' +
                '<div class="brand-name">' + brand + '</div>' +
                '<span class="chip badge-free">무료배송</span>' +
                '<span class="chip badge-fast">빠른배송</span>' +
                '<div style="margin-left:auto;">' +
                '<button class="btn-ghost small btn-clear-brand">브랜드삭제</button>' +
                '</div>' +
                '</div>';
            return $(html);
        }

        function renderItemRow(item, brand) {
            var checkedAttr = state.selected.has(item.productId) ? ' checked' : '';
            var html = '' +
                '<div class="item" data-id="' + item.productId + '" data-brand="' + brand + '">' +
                '<div class="checkbox"><input type="checkbox" class="row-check"' + checkedAttr + '></div>' +
                '<div class="thumb"><img src="' + (item.imageUrl || '') + '" alt=""></div>' +
                '<div>' +
                '<div class="name">' + (item.productName || '') + '</div>' +
                '<div class="meta">' + (item.optionName || '') + ' · 수량 ' + (item.quantity || 0) + '</div>' +
                '<div class="price">' + toCurrency(item.totalPrice || 0) + '</div>' +
                '</div>' +
                '<div class="x-btn">✕</div>' +
                '<div class="row-ctrls">' +
                '<button class="btn-ghost ctrl btn-opt">옵션 변경</button>' +
                '</div>' +
                '</div>';
            return $(html);
        }

        function render() {
            var $root = clearRoot();

            if (state.order.length === 0) {
                $root.hide();
                $('#cart-count').text('전체 0');
                updateTotals();
                return;
            }

            $('#cart-count').text('전체 ' + state.raw.length);
            $root.show();

            // 브랜드별로 DOM 생성
            for (var i = 0; i < state.order.length; i++) {
                var brand = state.order[i];
                var items = state.groups[brand] || [];

                var $brandRow = renderBrandHeader(brand);
                var $itemsWrap = $('<div class="items"></div>');

                for (var j = 0; j < items.length; j++) {
                    var $row = renderItemRow(items[j], brand);
                    $itemsWrap.append($row);
                }

                $root.append($brandRow);
                $root.append($itemsWrap);
            }

            // 이벤트 바인딩
            bindRowEvents();
            syncBrandChecks();
            syncSelectAll();
            updateTotals();
        }

        // ========== 이벤트 바인딩 ==========
        function bindRowEvents() {
            // (1) 개별 행 체크
            $('.row-check').off('change').on('change', function () {
                var $row = $(this).closest('.item');
                var id = Number($row.data('id'));

                if (this.checked) {
                    state.selected.add(id);
                } else {
                    state.selected.delete(id);
                }

                syncBrandChecks();
                syncSelectAll();
                updateTotals();
            });

            // (2) 개별 행 삭제(X 버튼)
            $('.item .x-btn').off('click').on('click', function () {
                var $row = $(this).closest('.item');
                var id = Number($row.data('id'));

                removeItemById(id);
                render();
            });

            // (3) 브랜드 단위 체크 (전체 선택/해제)
            $('.brand-check').off('change').on('change', function () {
                var $brandRow = $(this).closest('.brand-row');
                var brand = $brandRow.find('.brand-name').text();
                var isOn = this.checked;

                // 해당 브랜드의 모든 행 체크박스 상태 = 브랜드 체크박스 상태
                $('.item[data-brand="' + brand + '"] .row-check').each(function () {
                    var $row = $(this).closest('.item');
                    var id = Number($row.data('id'));

                    this.checked = isOn;
                    if (isOn) {
                        state.selected.add(id);
                    } else {
                        state.selected.delete(id);
                    }
                });

                syncSelectAll();
                updateTotals();
            });

            // (4) 브랜드 전체 삭제 버튼
            $('.btn-clear-brand').off('click').on('click', function () {
                var $brandRow = $(this).closest('.brand-row');
                var brand = $brandRow.find('.brand-name').text();

                removeBrand(brand);
                render();
            });


            // ============= 옵션 변경 ===============
            $('.item .btn-opt').off('click').on('click', function () {
                var $row = $(this).closest('.item');
                var brand = $row.data('brand');
                optionUpdate(brand, $row);
            });
        }

        // ========== 삭제/변경 도우미 ==========
        function removeItemById(id) {
            // raw에서 제거
            var newRaw = [];
            for (var i = 0; i < state.raw.length; i++) {
                var item = state.raw[i];
                if (item.productId !== id) {
                    newRaw.push(item);
                }
            }
            state.raw = newRaw;

            // 선택 해제
            state.selected.delete(id);

            // 그룹 재계산
            recalcGroupsFromRaw();
        }

        function removeBrand(brand) {
            // 해당 브랜드의 productId 목록 수집
            var idsToRemove = [];
            $('.item[data-brand="' + brand + '"]').each(function () {
                var id = Number($(this).data('id'));
                idsToRemove.push(id);
            });

            // raw에서 브랜드 아이템들 제거
            var newRaw = [];
            for (var i = 0; i < state.raw.length; i++) {
                var item = state.raw[i];
                var shouldRemove = false;

                for (var k = 0; k < idsToRemove.length; k++) {
                    if (item.productId === idsToRemove[k]) {
                        shouldRemove = true;
                        break;
                    }
                }
                if (!shouldRemove) {
                    newRaw.push(item);
                }
            }
            state.raw = newRaw;

            // 선택 상태에서도 제거
            for (var j = 0; j < idsToRemove.length; j++) {
                state.selected.delete(idsToRemove[j]);
            }

            // 그룹 재계산
            recalcGroupsFromRaw();
        }

        // ========== 체크박스 동기화 ==========
        function syncBrandChecks() {
            // 각 브랜드 행마다 "해당 브랜드의 개별행 체크박스가 모두 체크됨"이면 브랜드 체크박스 ON
            $('.brand-row').each(function () {
                var $row = $(this);
                var brand = $row.find('.brand-name').text();

                var $checks = $('.item[data-brand="' + brand + '"] .row-check');

                if ($checks.length === 0) {
                    $row.find('.brand-check').prop('checked', false);
                    return;
                }

                var allChecked = true;
                $checks.each(function () {
                    if (!this.checked) {
                        allChecked = false;
                    }
                });

                $row.find('.brand-check').prop('checked', allChecked);
            });
        }

        function syncSelectAll() {
            var $checks = $('.row-check');
            if ($checks.length === 0) {
                $('#select-all').prop('checked', false);
                return;
            }

            var allChecked = true;
            $checks.each(function () {
                if (!this.checked) {
                    allChecked = false;
                }
            });

            $('#select-all').prop('checked', allChecked);
        }

        // ========== 합계 계산 ==========
        function updateTotals() {
            var sum = 0;

            for (var i = 0; i < state.raw.length; i++) {
                var it = state.raw[i];
                if (state.selected.has(it.productId)) {
                    sum += (it.totalPrice || 0);
                }
            }

            var disc = Math.floor(sum * DISCOUNT_RATE);
            var finalPay = sum - disc;

            $('#sum-product').text(toCurrency(sum));
            $('#sum-discount').text('-' + toCurrency(disc));
            $('#sum-final').text(toCurrency(finalPay));
            $('#disc-rate').text(sum > 0 ? ' 8%' : '');
            $('#benefit-hint').text('적립혜택 예상 최대 ' + toCurrency(Math.floor(finalPay * 0.047)));
            $('#soldout-note').toggle(state.soldoutExists);
        }

        // ========== 상단바(전체선택/선택삭제) ==========
        $('#select-all').off('change').on('change', function () {
            var turnOn = this.checked;
            $('.row-check').prop('checked', turnOn);

            // 선택 상태 반영
            if (turnOn) {
                // 모두 선택
                for (var i = 0; i < state.raw.length; i++) {
                    state.selected.add(state.raw[i].productId);
                }
            } else {
                // 모두 해제
                state.selected.clear();
            }

            syncBrandChecks();
            updateTotals();
        });

        $('#btn-remove-selected').off('click').on('click', function () {
            if (state.selected.size === 0) return;

            // 선택된 id 배열화
            var ids = [];
            state.selected.forEach(function (id) {
                ids.push(id);
            });

            // raw에서 제거
            var newRaw = [];
            for (var i = 0; i < state.raw.length; i++) {
                var it = state.raw[i];
                var shouldRemove = false;

                for (var j = 0; j < ids.length; j++) {
                    if (it.productId === ids[j]) {
                        shouldRemove = true;
                        break;
                    }
                }
                if (!shouldRemove) {
                    newRaw.push(it);
                }
            }
            state.raw = newRaw;

            // 선택 초기화 + 그룹 재계산 + 렌더
            state.selected.clear();
            recalcGroupsFromRaw();
            render();
        });

        // ===== 모달 도우미 =====
        function openModal() {
            $('#option-modal').addClass('is-open').attr('aria-hidden', 'false');
            $('body').css('overflow', 'hidden'); // 배경 스크롤 잠금
        }

        function closeModal() {
            $('#option-modal').removeClass('is-open').attr('aria-hidden', 'true');
            $('body').css('overflow', '');
        }

// 공통 닫기 핸들러 (X 버튼, 취소, 배경, ESC)
        $(document).on('click', '[data-close-modal]', closeModal);
        $('#option-modal').on('click', function (e) {
            if (e.target === this) closeModal();
        });
        $(document).on('keydown', function (e) {
            if (e.key === 'Escape') closeModal();
        });

// ===== 옵션 변경 엔트리 =====
        function optionUpdate(brand, $row) {
            // 행 정보 추출
            var id = Number($row.data('id'));
            var name = $row.find('.name').text().trim();
            var meta = $row.find('.meta').text();          // "옵션명 · 수량 n"
            var optionNameMatch = meta.split('·')[0] || ''; // 좌항을 옵션명으로 사용
            var qtyNow = (meta.match(/수량\s*(\d+)/) || [null, 1])[1];

            // state.raw에서 단가 추정 (unitPrice 없으면 totalPrice/quantity 로 계산)
            var unitPrice = null, totalPriceNow = null;
            for (var i = 0; i < state.raw.length; i++) {
                var it = state.raw[i];
                if (it.productId === id) {
                    totalPriceNow = Number(it.totalPrice || 0);
                    var q = Number(it.quantity || 1) || 1;
                    unitPrice = typeof it.unitPrice === 'number' ? it.unitPrice : (q > 0 ? Math.round(totalPriceNow / q) : 0);
                    break;
                }
            }

            // 모달 값 세팅
            $('#opt-name').text(name);
            $('#opt-brand-chip').text(brand);
            $('#opt-optionName').val(optionNameMatch.trim());
            $('#opt-qty').val(qtyNow);
            $('#opt-save').data('productId', id).data('unitPrice', unitPrice);

            // 미리보기 업데이트
            updateOptionPricePreview();

            // 모달 오픈
            openModal();
        }

// 미리보기: 수량 변경 시 금액 보여주기
        function updateOptionPricePreview() {
            var unit = Number($('#opt-save').data('unitPrice') || 0);
            var qty = Number($('#opt-qty').val() || 1);
            if (qty < 1) qty = 1;
            var newTotal = unit * qty;
            $('#opt-price-preview').text('변경 후 금액 미리보기: ' + (newTotal ? newTotal.toLocaleString('ko-KR') + '원' : '-'));
        }

        $('#opt-qty').on('input change', updateOptionPricePreview);

// 적용(저장) 버튼: state 갱신 → 재렌더 → 닫기
        $('#opt-save').on('click', function () {
            var id = Number($(this).data('productId'));
            var unit = Number($(this).data('unitPrice') || 0);
            var newQty = Math.max(1, Number($('#opt-qty').val() || 1));
            var newOpt = $('#opt-optionName').val().trim();

            // state.raw 갱신
            for (var i = 0; i < state.raw.length; i++) {
                var it = state.raw[i];
                if (it.productId === id) {
                    it.quantity = newQty;
                    if (newOpt) it.optionName = newOpt;
                    if (typeof it.unitPrice === 'number') {
                        it.totalPrice = it.unitPrice * newQty;
                    } else if (unit > 0) {
                        it.totalPrice = unit * newQty;
                    }
                    break;
                }
            }

            // 그룹/합계/화면 재계산
            recalcGroupsFromRaw();
            render();

            closeModal();
        });


        // ========== 시작(부트스트랩) ==========
        function bootstrap() {
            fetchCart(function onSuccess(list) {
                state.raw = list;

                // 기본: 모두 선택
                for (var i = 0; i < state.raw.length; i++) {
                    console.log(state.raw[i])
                    state.selected.add(state.raw[i].productId);
                }

                recalcGroupsFromRaw();
                render();
            }, function onError() {
                alert('장바구니를 불러오지 못했습니다.');
            });
        }

        bootstrap();
    })();
</script>


</body>
</html>
