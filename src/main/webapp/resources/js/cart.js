(function () {
    // ===== 상수/도우미 =====
    var DISCOUNT_RATE = 0.08;

    function toCurrency(n) {
        n = n || 0;
        return n.toLocaleString('ko-KR') + '원';
    }

    // 컨텍스트/유저
    var BASE = (window.__CTX__ && window.__CTX__.base) || '';
    var userId = (window.__CTX__ && window.__CTX__.userId) || '';

    var $container = $('.container');

    // 전역 상태
    var state = {
        raw: [],
        groups: {},
        order: [],
        selected: new Set(),
        soldoutExists: false
    };

    // ===== API =====
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

    // ===== 그룹화 =====
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

    // ===== 렌더링 =====
    function clearRoot() {
        var $root = $('#brand-lists');
        $root.empty();
        return $root;
    }

    function renderBrandHeader(brand) {
        var html = ''
            + '<div class="brand-row">'
            + '  <label class="checkbox"><input type="checkbox" class="brand-check"></label>'
            + '  <div class="brand-name">' + escapeHtml(brand) + '</div>'
            + '  <span class="chip badge-free">무료배송</span>'
            + '  <span class="chip badge-fast">빠른배송</span>'
            + '  <div style="margin-left:auto;">'
            + '    <button class="btn-ghost small btn-clear-brand">브랜드삭제</button>'
            + '  </div>'
            + '</div>';
        return $(html);
    }

    function renderItemRow(item, brand) {
        var checkedAttr = state.selected.has(item.productId) ? ' checked' : '';
        var img = item.imageUrl || '';
        var name = item.productName || '';
        var opt = item.optionName || '';
        var qty = item.quantity || 0;
        var price = item.totalPrice || 0;

        var html = ''
            + '<div class="item" data-id="' + Number(item.productId) + '" data-brand="' + escapeAttr(brand) + '">'
            + '  <div class="checkbox"><input type="checkbox" class="row-check"' + checkedAttr + '></div>'
            + '  <div class="thumb"><img src="' + escapeAttr(img) + '" alt=""></div>'
            + '  <div>'
            + '    <div class="name">' + escapeHtml(name) + '</div>'
            + '    <div class="meta">' + escapeHtml(opt) + ' · 수량 ' + Number(qty) + '</div>'
            + '    <div class="price">' + toCurrency(price) + '</div>'
            + '  </div>'
            + '  <div class="x-btn">✕</div>'
            + '  <div class="row-ctrls">'
            + '    <button class="btn-ghost ctrl btn-opt">옵션 변경</button>'
            + '  </div>'
            + '</div>';
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

        bindRowEvents();
        syncBrandChecks();
        syncSelectAll();
        updateTotals();
    }

    // ===== 이벤트 =====
    function bindRowEvents() {
        // 개별 행 체크
        $('.row-check').off('change').on('change', function () {
            var $row = $(this).closest('.item');
            var id = Number($row.data('id'));
            if (this.checked) state.selected.add(id);
            else state.selected.delete(id);
            syncBrandChecks();
            syncSelectAll();
            updateTotals();
        });

        // 행 삭제
        $('.item .x-btn').off('click').on('click', function () {
            var $row = $(this).closest('.item');
            var id = Number($row.data('id'));
            removeItemById(id);
            render();
        });

        // 브랜드 체크
        $('.brand-check').off('change').on('change', function () {
            var $brandRow = $(this).closest('.brand-row');
            var brand = $brandRow.find('.brand-name').text();
            var isOn = this.checked;

            $('.item[data-brand="' + brand + '"] .row-check').each(function () {
                var $row = $(this).closest('.item');
                var id = Number($row.data('id'));
                this.checked = isOn;
                if (isOn) state.selected.add(id);
                else state.selected.delete(id);
            });
            syncSelectAll();
            updateTotals();
        });

        // 브랜드 삭제
        $('.btn-clear-brand').off('click').on('click', function () {
            var $brandRow = $(this).closest('.brand-row');
            var brand = $brandRow.find('.brand-name').text();
            removeBrand(brand);
            render();
        });

        // 옵션 변경 (모달 사용 시)
        $('.item .btn-opt').off('click').on('click', function () {
            var $row = $(this).closest('.item');
            var brand = $row.data('brand');
            if ($('#option-modal').length === 0) return; // 모달 미사용 시 무시
            optionUpdate(brand, $row);
        });

        // 모달 공통 닫기
        $(document).off('click.cartModalClose').on('click.cartModalClose', '[data-close-modal]', closeModal);
        $('#option-modal').off('click.cartModalBg').on('click.cartModalBg', function (e) {
            if (e.target === this) closeModal();
        });
        $(document).off('keydown.cartEsc').on('keydown.cartEsc', function (e) {
            if (e.key === 'Escape') closeModal();
        });

        // 미리보기
        $('#opt-qty').off('input change').on('input change', updateOptionPricePreview);
        $('#opt-save').off('click').on('click', applyOptionChange);
    }

    // ===== 삭제/변경 도우미 =====
    function removeItemById(id) {
        var newRaw = [];
        for (var i = 0; i < state.raw.length; i++) {
            var item = state.raw[i];
            if (item.productId !== id) newRaw.push(item);
        }
        state.raw = newRaw;
        state.selected.delete(id);
        recalcGroupsFromRaw();
    }

    function removeBrand(brand) {
        var idsToRemove = [];
        $('.item[data-brand="' + brand + '"]').each(function () {
            idsToRemove.push(Number($(this).data('id')));
        });

        var newRaw = [];
        for (var i = 0; i < state.raw.length; i++) {
            var item = state.raw[i];
            var rm = false;
            for (var k = 0; k < idsToRemove.length; k++) {
                if (item.productId === idsToRemove[k]) {
                    rm = true;
                    break;
                }
            }
            if (!rm) newRaw.push(item);
        }
        state.raw = newRaw;
        idsToRemove.forEach(function (id) {
            state.selected.delete(id);
        });
        recalcGroupsFromRaw();
    }

    // ===== 체크박스 동기화 =====
    function syncBrandChecks() {
        $('.brand-row').each(function () {
            var $row = $(this);
            var brand = $row.find('.brand-name').text();
            var $checks = $('.item[data-brand="' + brand + '"] .row-check');
            if ($checks.length === 0) {
                $row.find('.brand-check').prop('checked', false);
                return;
            }
            var all = true;
            $checks.each(function () {
                if (!this.checked) all = false;
            });
            $row.find('.brand-check').prop('checked', all);
        });
    }

    function syncSelectAll() {
        var $checks = $('.row-check');
        if ($checks.length === 0) {
            $('#select-all').prop('checked', false);
            return;
        }
        var all = true;
        $checks.each(function () {
            if (!this.checked) all = false;
        });
        $('#select-all').prop('checked', all);
    }

    // ===== 합계 =====
    function updateTotals() {
        var sum = 0;
        for (var i = 0; i < state.raw.length; i++) {
            var it = state.raw[i];
            if (state.selected.has(it.productId)) sum += (it.totalPrice || 0);
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

    // ===== 상단바 =====
    $('#select-all').off('change').on('change', function () {
        var on = this.checked;
        $('.row-check').prop('checked', on);
        if (on) {
            for (var i = 0; i < state.raw.length; i++) state.selected.add(state.raw[i].productId);
        } else {
            state.selected.clear();
        }
        syncBrandChecks();
        updateTotals();
    });

    $('#btn-remove-selected').off('click').on('click', function () {
        if (state.selected.size === 0) return;
        var ids = [];
        state.selected.forEach(function (id) {
            ids.push(id);
        });
        var newRaw = [];
        for (var i = 0; i < state.raw.length; i++) {
            var it = state.raw[i];
            var rm = false;
            for (var j = 0; j < ids.length; j++) {
                if (it.productId === ids[j]) {
                    rm = true;
                    break;
                }
            }
            if (!rm) newRaw.push(it);
        }
        state.raw = newRaw;
        state.selected.clear();
        recalcGroupsFromRaw();
        render();
    });

    // ===== 모달 유틸 =====
    function openModal() {
        $('#option-modal').addClass('is-open').attr('aria-hidden', 'false');
        $('body').css('overflow', 'hidden');
    }

    function closeModal() {
        $('#option-modal').removeClass('is-open').attr('aria-hidden', 'true');
        $('body').css('overflow', '');
    }

    function parseSelectedFromOptionName(name) {
        return (name || '').split('/').map(function (s) {
            return s.trim();
        }).filter(Boolean);
    }

    function optionUpdate(brand, $row) {
        var id = Number($row.data('id'));
        var name = $row.find('.name').text().trim();

        // 현재 행에 대응하는 상품 객체
        var product = state.raw.find(function (it) {
            return Number(it.productId) === id;
        });

        if (!product) {
            console.warn('[optionUpdate] product not found for id=', id);
            return;
        }
        console.log(product);

        // 단가 계산(미리보기용)
        var q0 = Number(product.quantity || 1) || 1;
        var unitPrice = (typeof product.unitPrice === 'number')
            ? product.unitPrice
            : (q0 > 0 ? Math.round((product.totalPrice || 0) / q0) : 0);

        // 헤더 세팅
        $('#opt-name').text(name);
        $('#opt-brand-chip').text(brand);
        $('#opt-qty').val(q0);
        $('#opt-save').data('productId', id).data('unitPrice', unitPrice);

        // 초기 선택값(옵션명 -> 값만 뽑아서 실제 그룹 값과 매칭)
        var picked = parseSelectedFromOptionName(product.optionName);
        var initialSelected = {};
        (product.optionGroups || []).forEach(function (g) {
            var vals = Array.isArray(g.optionValues) ? g.optionValues : [];
            var hit = picked.find(function (p) {
                return vals.indexOf(p) >= 0;
            });
            if (hit) initialSelected[g.optionType] = hit;
        })

        // 옵션 그룹 렌더
        renderOptionGroups(product.optionGroups || [], initialSelected);

        // 수량 버튼
        $('#qty-dec').off('click').on('click', function () {
            var v = Math.max(1, Number($('#opt-qty').var() || 1) - 1);
            $('#opt-qty').var(v);
            updateOptionPricePreview();
        });
        $('#qty-inc').off('click').on('click', function () {
            var v = Math.max(1, Number($('#opt-qty').var() || 1) + 1);
            $('#opt-qty').var(v);
            updateOptionPricePreview();
        });

        updateOptionPricePreview();
        openModal();


    }


    function updateOptionPricePreview() {
        var unit = Number($('#opt-save').data('unitPrice') || 0);
        var qty = Number($('#opt-qty').val() || 1);
        if (qty < 1) qty = 1;
        var newTotal = unit * qty;
        $('#opt-price-preview').text('변경 후 금액 미리보기: ' + (newTotal ? newTotal.toLocaleString('ko-KR') + '원' : '-'));
    }

    function renderOptionGroups(groups, selectedMap) {
        var $wrap = $('#opt-groups');
        if ($wrap.length === 0) {
            console.warn('[renderOptionGroups] #opt-groups not found');
            return;
        }
        $wrap.empty();

        if (!Array.isArray(groups) || groups.length === 0) {
            // 옵션 그룹 자체가 없을 때는 아무 것도 렌더하지 않음
            return;
        }

        groups.forEach(function (g) {
            if (!g) return;
            var title = g.optionType || '';
            var values = Array.isArray(g.optionValues) ? g.optionValues : [];

            // 값이 없으면 제목만 보여주지 말고 스킵 (원하면 안내 문구를 넣어도 됨)
            if (values.length === 0) return;

            var $g = $('<div class="opt-group" style="margin-top:14px;"></div>');
            $g.append('<div class="opt-group-title" style="font-weight:700;margin-bottom:8px;">' + escapeHtml(title) + '</div>');

            var $list = $('<div class="opt-list" style="display:flex;flex-wrap:wrap;gap:8px;"></div>');

            values.forEach(function (val) {
                var $item = $('<button type="button" class="opt-item btn-ghost small"></button>')
                    .text(val)
                    .css({borderRadius: '8px', padding: '6px 10px'});

                if (selectedMap && selectedMap[title] === val) $item.addClass('is-selected').css({
                    borderColor: '#111',
                    fontWeight: 600
                });

                $item.on('click', function () {
                    $list.find('.opt-item').removeClass('is-selected').css({borderColor: '#ddd', fontWeight: 400});
                    $item.addClass('is-selected').css({borderColor: '#111', fontWeight: 600});
                    updateOptionPricePreview();
                });

                $list.append($item);
            });

            $g.append($list);
            $wrap.append($g);
        });
    }


    function applyOptionChange() {
        var productId = Number($(this).data('productId'));
        var unit = Number($('#opt-save').data('unitPrice') || 0);
        var newQty = Math.max(1, Number($('#opt-qty').val() || 1));

        // 현재 모달에서 선택된 옵션 수집
        var optionGroups = [];
        $('#opt-groups .opt-group').each(function () {
                var title = $(this).find('.opt-group-title').text().trim();
                var sel = $(this).find('.opt-item.is-selected').text().trim();
                if (title && sel) {
                    optionGroups.push({
                        optionTypeId: optionTypeIdOf(title),
                        optionValue: sel
                    });
                }

            }
        );

        // 모든 그룹이 선택됐는지 간단하게 체크(원하면 제거 가능)
        var required = $('#opt-groups .opt-group').length;
        if (required > 0 && optionGroups.length < required) {
            alert('옵션을 모두 선택해주세요');
            return;
        }

        var payload = {
            optionGroups: optionGroups, quantity: newQty
        };

        $.ajax({
            url: BASE + '/api/v1/' + encodeURIComponent(userId) + '/carts/' + encodeURIComponent(productId),
            type: 'PATCH',
            contentType: 'application/json',
            data: JSON.stringify(payload)
        }).done(function (res) {
            // 컨트롤러가 List<ProductsInCartInfoResponse> 반환.
            // 혹시 래퍼가 있으면(result.productList)도 처리.
            var list = Array.isArray(res) ? res
                : (res && res.result && Array.isArray(res.result.productList) ? res.result.productList : []);
            state.raw = list || [];
            state.selected.clear();
            for (var i = 0; i < state.raw.length; i++) {
                state.selected.add(state.raw[i].productId);
            }
            recalcGroupsFromRaw();
            render();
            closeModal();
        }).fail(function (xhr) {
            // 기본 문구
            var msg = '옵션 변경에 실패했습니다.';

            // 응답 객체 추출
            var data = xhr.responseJSON;
            if (!data && xhr.responseText) {
                try {
                    data = JSON.parse(xhr.responseText);
                } catch (e) {
                }
            }

            if (data) {
                msg = data.detail || data.message || data.error_description || data.error || msg;
            } else if (xhr.responseText) {
                msg = xhr.responseText || msg;
            }

            msg = String(msg).replace(/^[A-Z_]+\d+/, '').trim();
            
            $('#opt-error').text(msg).show();
            $('#opt-qty').focus();
        });
    }

    function optionTypeIdOf(name) {
        var n = (name || '').toLowerCase();
        if (n === 'color' || n === '색상') return 1;
        if (n === 'size' || n === '사이즈') return 2;
        if (n === 'material' || n === '소재') return 3;
        return 0; // 서버가 무시해도 되는 기본값
    }


    // ===== XSS 방지용 이스케이프 =====
    function escapeHtml(str) {
        return String(str).replace(/[&<>"']/g, function (s) {
            return ({'&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;'}[s]);
        });
    }

    function escapeAttr(str) {
        // 속성값 전용 (쌍따옴표 기준)
        return String(str).replace(/["&<>]/g, function (s) {
            return ({'&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;'}[s]);
        });
    }

    // ===== 시작 =====
    function bootstrap() {
        fetchCart(function (list) {
            state.raw = list || [];
            for (var i = 0; i < state.raw.length; i++) state.selected.add(state.raw[i].productId); // 기본 모두 선택
            recalcGroupsFromRaw();
            render();
        }, function () {
            alert('장바구니를 불러오지 못했습니다.');
        });
    }

    $(bootstrap);
})();
