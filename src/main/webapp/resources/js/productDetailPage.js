// ==============================
// productDetailPage.js (refactored for new JSP)
// ==============================

(() => {
    // ---- State ----
    let productVariants = [];
    let quantity = 1;

    // ---- Utils ----
    const $ = window.jQuery;

    function formatKoreanNumber(num) {
        if (num >= 100000000) {
            const eok = Math.floor(num / 100000000);
            const remainder = num % 100000000;
            let result = eok + '억';
            if (remainder >= 10000) {
                const man = Math.floor(remainder / 10000);
                result += man + '만';
            }
            return result;
        } else if (num >= 10000) {
            const man = Math.floor(num / 10000);
            return man + '만';
        } else if (num >= 1000) {
            return Math.floor(num / 1000) + '천';
        } else {
            return String(num);
        }
    }

    function getProductIdFromUrl() {
        const pathParts = window.location.pathname.split('/');
        const idx = pathParts.indexOf('products');
        if (idx !== -1 && pathParts[idx + 1]) {
            const v = parseInt(pathParts[idx + 1], 10);
            if (!Number.isNaN(v)) return v;
        }
        return null;
    }

    function getProductId() {
        // 1) 신규 구조: #pageMeta data-product-id
        const meta = document.getElementById('pageMeta');
        const v = meta?.dataset?.productId;
        if (v && !Number.isNaN(Number(v))) return Number(v);

        // 2) URL
        const fromUrl = getProductIdFromUrl();
        if (fromUrl) return fromUrl;

        // 3) 레거시 구조: #productId 텍스트
        const legacy = document.getElementById('productId');
        const legacyVal = legacy?.textContent?.trim();
        if (legacyVal && !Number.isNaN(Number(legacyVal))) return Number(legacyVal);

        return null;
    }

    function getBrandId() {
        const meta = document.getElementById('pageMeta');
        const v = meta?.dataset?.brandId;
        if (v && !Number.isNaN(Number(v))) return Number(v);

        const legacy = document.getElementById('brandId');
        const legacyVal = legacy?.textContent?.trim();
        if (legacyVal && !Number.isNaN(Number(legacyVal))) return Number(legacyVal);

        return null;
    }

    function setPageMeta({productId, brandId}) {
        const meta = document.getElementById('pageMeta');
        if (!meta) return;
        if (productId != null) meta.dataset.productId = String(productId);
        if (brandId != null) meta.dataset.brandId = String(brandId);
    }

    function guardRequired(val, msg) {
        if (val == null || val === '' || Number.isNaN(val)) {
            alert(msg);
            throw new Error(msg);
        }
    }

    // ---- DOM Bindings (single) ----
    $(document).ready(() => {
        bindQuantityControls();
        bindActionButtons(); // add-to-cart / buy-now / likes
        bootstrapPage();     // fetch & render everything
    });

    // ---- Quantity ----
    function bindQuantityControls() {
        $(document).off('click.qtyInc').on('click.qtyInc', '#increase-btn', () => {
            quantity++;
            $('#quantity-input').val(quantity);
        });

        $(document).off('click.qtyDec').on('click.qtyDec', '#decrease-btn', () => {
            if (quantity > 1) {
                quantity--;
                $('#quantity-input').val(quantity);
            }
        });

        $(document).off('input.qty').on('input.qty', '#quantity-input', function () {
            let v = parseInt($(this).val(), 10);
            if (!v || v < 1) v = 1;
            quantity = v;
            $(this).val(quantity);
        });
    }

    // ---- Bootstrap all ----
    function bootstrapPage() {
        const urlPid = getProductIdFromUrl(); // 우선 URL 파싱
        if (urlPid) setPageMeta({productId: urlPid}); // meta에 미리 기록

        const productId = getProductId();
        guardRequired(productId, '상품 ID를 확인할 수 없습니다.');

        // 1) 제품 기본 정보
        fetchProduct(productId)
            .then((data) => {
                // 메타 기록(브랜드ID 포함)
                setPageMeta({productId: data.productId, brandId: data.brandId});

                renderProductHeader(data);
                renderBrand(data);
                renderPrice(data);
                renderImages(data);
                renderDetailSizeImage(data);

                // 옵션
                return loadProductOptions(data.productId);
            })
            .catch((e) => {
                console.error('제품 정보 로드 오류:', e);
            });

        // 2) 카테고리/상세설명/사이즈리스트/리뷰 (병렬)
        loadCategories(productId);
        loadDetailDescription(productId);
        loadSizeTable(productId);
        loadReviews(productId);
    }

    // ---- Fetchers ----
    function fetchProduct(productId) {
        return $.ajax({
            url: '/api/v1/products/' + productId,
            method: 'GET',
            dataType: 'json'
        });
    }

    function loadProductOptions(productId) {
        return $.ajax({
            url: `/api/v1/products/${productId}/options`,
            method: 'GET',
            dataType: 'json'
        }).then((variants) => {
            productVariants = Array.isArray(variants) ? variants : [];
            renderOptions(productVariants);
        }).catch((err) => {
            console.error('상품 옵션 로드 실패:', err);
        });
    }

    function loadCategories(productId) {
        $.ajax({
            url: '/api/v1/products/' + productId + '/categories',
            method: 'GET',
            dataType: 'json',
            success: function (data) {
                if (data.productCategoryList && data.productCategoryList.length) {
                    const names = data.productCategoryList.map((c) => c.categoryName);
                    $('#categoryName').text(names.join(' > '));
                }
            }
        });
    }

    function loadDetailDescription(productId) {
        $.ajax({
            url: '/api/v1/products/' + productId + '/detail-Info',
            method: 'GET',
            dataType: 'json',
            success: function (data) {
                if (data.detailDescription) {
                    const imgTag = $('<img>')
                        .attr('src', data.detailDescription)
                        .attr('alt', '제품 상세 이미지')
                        .addClass('detail-description-img');
                    $('#detailDescription').empty().append(imgTag);
                }
            }
        });
    }

    function loadSizeTable(productId) {
        $.ajax({
            url: '/api/v1/products/' + productId + '/detail-size-list',
            method: 'GET',
            dataType: 'json',
            success: function (data) {
                const $container = $('#productDetailSizeList').empty();
                if (!Array.isArray(data) || data.length === 0) return;

                const firstImageId = Number(data[0].sizeDetailImageId);
                if (firstImageId === 1 || firstImageId === 2) {
                    // 상의
                    const $table = $('<table>').addClass('size-table');
                    const $thead = $('<thead>').html(
                        '<tr><th>사이즈</th><th>총장</th><th>어깨너비</th><th>가슴단면</th><th>소매길이</th></tr>'
                    );
                    const $tbody = $('<tbody>');
                    data.forEach((size) => {
                        $tbody.append(
                            $('<tr>').append(
                                $('<td>').text(size.cm),
                                $('<td>').text(size.length),
                                $('<td>').text(size.shoulderWidth),
                                $('<td>').text(size.chestWidth),
                                $('<td>').text(size.sleaveLength)
                            )
                        );
                    });
                    $container.append('<h3>상의 실측 사이즈 (cm)</h3>');
                    $container.append($table.append($thead).append($tbody));
                } else if (firstImageId === 3 || firstImageId === 4) {
                    // 하의
                    const $table = $('<table>').addClass('size-table');
                    const $thead = $('<thead>').html(
                        '<tr><th>사이즈</th><th>총장</th><th>허리단면</th><th>엉덩이단면</th><th>허벅지단면</th><th>밑위</th><th>밑단단면</th></tr>'
                    );
                    const $tbody = $('<tbody>');
                    data.forEach((size) => {
                        $tbody.append(
                            $('<tr>').append(
                                $('<td>').text(size.cm),
                                $('<td>').text(size.length),
                                $('<td>').text(size.waist),
                                $('<td>').text(size.hip),
                                $('<td>').text(size.thigh),
                                $('<td>').text(size.rise),
                                $('<td>').text(size.hemWidth)
                            )
                        );
                    });
                    $container.append('<h3>하의 실측 사이즈 (cm)</h3>');
                    $container.append($table.append($thead).append($tbody));
                }
            }
        });
    }

    function loadReviews(productId) {
        $.ajax({
            url: '/api/v1/products/' + productId + '/reviews',
            method: 'GET',
            dataType: 'json',
            success: function (reviews) {
                const $reviewsContainer = $('#productsReviews').empty();
                if (!Array.isArray(reviews) || reviews.length === 0) return;

                reviews.forEach((review) => {
                    const $reviewItem = $('<div>').addClass('review-item')
                        .append(
                            $('<div>').addClass('review-header')
                                .append($('<strong>').addClass('review-nickname').text(review.nickName))
                        )
                        .append(
                            $('<div>').addClass('review-body')
                                .append($('<p>').addClass('review-content').text(review.content))
                        )
                        .append(
                            $('<div>').addClass('review-footer')
                                .append($('<span>').text('구매옵션: ' + (review.purchaseOptions ?? '')))
                                .append($('<button>').addClass('review-help-button')
                                    .text('도움이 돼요 ' + (review.helpCount ?? 0)))
                        );
                    $reviewsContainer.append($reviewItem);
                });
            }
        });
    }

    // ---- Renderers ----
    function renderProductHeader(data) {
        $('#productName').text(data.productName);
        $('#categoryName').attr('aria-label', '카테고리');

        // 평점 요약 (선택적으로 동기화)
        // $('#summaryRatingScore').text(...);
        // $('#summaryReviewCount').text(...);

        // 좋아요 상태
        if (data.isProductLiked) {
            $('.wishlist-icon .heart-icon').removeClass('far').addClass('fas liked');
        } else {
            $('.wishlist-icon .heart-icon').removeClass('fas liked').addClass('far');
        }
    }

    function renderBrand(data) {
        $('#brandName').text(data.brandName);
        if (data.brandImage) {
            const imgTag = $('<img>')
                .attr('src', data.brandImage)
                .attr('alt', data.brandName)
                .addClass('brand-logo-img');
            $('#brand-image-container').empty().append(imgTag);
        }
        $('#productLikeCnt').text(formatKoreanNumber(data.productLikeCnt ?? 0));
        $('#brandLikeCnt').text(formatKoreanNumber(data.brandLikeCnt ?? 0));

        if (data.isBrandLiked) {
            $('.brand-wishlist-icon .heart-icon').removeClass('far').addClass('fas liked');
        } else {
            $('.brand-wishlist-icon .heart-icon').removeClass('fas liked').addClass('far');
        }
    }

    function renderPrice(data) {
        $('#productPrice').text(Number(data.price).toLocaleString() + '원');
        $('#productDiscount').text((data.brandDiscount ?? 0) + '%');
        $('#productTotalPrice').text(Number(data.finalprice).toLocaleString() + '원');
        $('#finalPrice').text(Number(data.finalprice).toLocaleString() + '원');
    }

    function renderImages(data) {
        const $main = $('#mainImageContainer').empty();
        const $thumb = $('#thumbnailImages').empty();

        if (Array.isArray(data.productImageList) && data.productImageList.length) {
            data.productImageList.forEach((img, idx) => {
                if (idx === 0) {
                    $main.append($('<img>').attr('src', img.imageUrl).attr('alt', 'Product Image'));
                }
                const $preview = $('<div>')
                    .addClass('preview-item')
                    .attr('data-image-url', img.imageUrl);
                if (idx === 0) $preview.addClass('active');

                const imgTag = $('<img>').attr('src', img.imageUrl).attr('alt', img.imageType || 'Product Image');
                $preview.append(imgTag);
                $thumb.append($preview);
            });

            // 썸네일 이벤트(위임)
            $(document).off('click.thumb').on('click.thumb', '.preview-item', function () {
                const url = $(this).attr('data-image-url');
                $('.preview-item').removeClass('active');
                $(this).addClass('active');
                $('#mainImageContainer').find('img').attr('src', url);
            });
        }
    }

    function renderDetailSizeImage(data) {
        if (data.detailSizeImage) {
            const imgTag = $('<img>')
                .attr('src', data.detailSizeImage)
                .attr('alt', '제품 실측 이미지')
                .addClass('detail-size-img');
            $('#detailSizeImage').empty().append(imgTag);
        }
    }

    function renderOptions(variants) {
        // 유니크 컬러/사이즈
        const colors = [...new Set(variants.map((v) => v.productColor).filter(Boolean))];
        const sizes = [...new Set(variants.map((v) => v.productsSize).filter(Boolean))];

        // 스와치
        const colorMapping = {
            'Black': '#000000',
            'blue': '#4A9BDC',
            'yellow': '#FFE59D',
            'green': '#4DAE4D',
            'red': '#FF0000'
        };
        const $swatches = $('#colorSwatches').empty();
        colors.forEach((color, idx) => {
            const code = colorMapping[color] || '#cccccc';
            const $sw = $('<div>')
                .addClass('color-swatch')
                .attr('data-color', color)
                .css('background-color', code)
                .attr('title', color);
            if (idx === 0) $sw.addClass('selected');
            $swatches.append($sw);
        });

        // 드롭다운
        const $colorSelect = $('#color-select').empty().append('<option value="">컬러</option>');
        colors.forEach((c) => $colorSelect.append($('<option>').val(c).text(c)));

        const $sizeSelect = $('#size-select').empty().append('<option value="">사이즈</option>');
        sizes.forEach((s) => $sizeSelect.append($('<option>').val(s).text(s)));

        // 스와치 클릭 → 드롭다운 동기화
        $(document).off('click.color').on('click.color', '.color-swatch', function () {
            $('.color-swatch').removeClass('selected');
            $(this).addClass('selected');
            const selectedColor = $(this).attr('data-color');
            $('#color-select').val(selectedColor);
        });
    }

    // ---- Actions ----
    function bindActionButtons() {
        // Add to Cart (양쪽 셀렉터 지원)
        $(document).off('click.cart')
            .on('click.cart', '#addToCartBtn, .add-to-cart-btn', onAddToCart);

        // Buy Now
        $(document).off('click.buy')
            .on('click.buy', '#buyNowBtn, .buy-now', onBuyNow);

        // Product like
        $(document).off('click.prodLike')
            .on('click.prodLike', '.wishlist-icon', onToggleProductLike);

        // Brand like
        $(document).off('click.brandLike')
            .on('click.brandLike', '.brand-wishlist-icon', onToggleBrandLike);
    }

    function getSelectedVariantOrThrow() {
        const selectedColor = $('#color-select').val();
        const selectedSize = $('#size-select').val();

        guardRequired(selectedColor, '색상을 선택해주세요.');
        guardRequired(selectedSize, '사이즈를 선택해주세요.');

        const variant = productVariants.find(
            (v) => v.productColor === selectedColor && v.productsSize === selectedSize
        );
        if (!variant) {
            alert('해당 옵션의 상품을 찾을 수 없습니다.');
            throw new Error('Variant not found');
        }
        return variant;
    }

    function onAddToCart() {
        const productId = getProductId();
        guardRequired(productId, '상품 정보를 불러오지 못했습니다.');

        const variant = getSelectedVariantOrThrow();
        const qty = Number($('#quantity-input').val() || 1);

        const cartData = {
            productId: Number(productId),
            quantity: Number.isNaN(qty) ? 1 : qty,
            // 서버 스키마에 맞게 사용: productVariantId / optionId / variantName 등
            // productVariantId: variant.productVariantId,
            variantName: variant.variantName
        };

        $.ajax({
            url: '/api/v1/carts',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(cartData),
            success: function () {
                console.log('장바구니 추가 제품 정보 : ', cartData);
                alert('장바구니에 상품을 추가했습니다.');
            },
            error: function (xhr) {
                console.error('장바구니 추가 실패:', xhr.responseText || xhr);
                alert('장바구니 추가에 실패했습니다.');
            }
        });
    }

    function onBuyNow() {
        const productId = getProductId();
        guardRequired(productId, '상품 정보를 불러오지 못했습니다.');

        const variant = getSelectedVariantOrThrow();
        const qty = Number($('#quantity-input').val() || 1);

        const purchaseData = {
            type: 'DIRECT_PURCHASE',
            productId: Number(productId),
            quantity: Number.isNaN(qty) ? 1 : qty,
            productVariantId: variant.productVariantId,
            optionName: variant.variantName
        };

        $.ajax({
            url: '/product/direct-purchase',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(purchaseData),
            xhrFields: {withCredentials: true},
            success: function (response) {
                console.log('구매할 제품 정보:', purchaseData);
                if (response && response.success && response.redirectUrl) {
                    window.location.href = response.redirectUrl;
                } else {
                    alert('구매 페이지로 이동합니다.');
                    window.location.href = '/orders/order-page';
                }
            },
            error: function (xhr) {
                console.error('구매 요청 실패:', xhr.status, xhr.responseText);
                try {
                    const err = JSON.parse(xhr.responseText);
                    alert(err.message || '구매 요청에 실패했습니다.');
                } catch {
                    alert('구매 요청에 실패했습니다.');
                }
            }
        });
    }

    function onToggleProductLike() {
        const productId = getProductId();
        guardRequired(productId, '상품 정보를 불러오지 못했습니다.');

        $.ajax({
            url: `/api/v1/products/${productId}/liked`,
            method: 'POST',
            dataType: 'json',
            success: function (response) {
                if (typeof response.likeCount !== 'undefined') {
                    const $likeCnt = $('#productLikeCnt');
                    $likeCnt.text(formatKoreanNumber(response.likeCount))
                        .addClass('like-count-updated');
                    setTimeout(() => $likeCnt.removeClass('like-count-updated'), 300);
                }
                const heart = $('.wishlist-icon .heart-icon');
                if (response.liked) {
                    heart.removeClass('far').addClass('fas liked');
                } else {
                    heart.removeClass('fas liked').addClass('far');
                }
            },
            error: function (xhr) {
                console.error('상품 좋아요 실패:', xhr.responseText || xhr);
            }
        });
    }

    function onToggleBrandLike() {
        const brandId = getBrandId();
        guardRequired(brandId, '브랜드 정보를 불러오지 못했습니다.');

        const apiUrl = '/api/v1/brands/' + brandId + '/liked';

        $.ajax({
            url: apiUrl,
            method: 'POST',
            xhrFields: {withCredentials: true},
            dataType: 'json',
            success: function (response) {
                if (typeof response.likeCount !== 'undefined') {
                    const $likeCnt = $('#brandLikeCnt');
                    $likeCnt.text(formatKoreanNumber(response.likeCount))
                        .addClass('like-count-updated');
                    setTimeout(() => $likeCnt.removeClass('like-count-updated'), 300);
                }
                const heart = $('.brand-wishlist-icon .heart-icon');
                if (response.liked) {
                    heart.removeClass('far').addClass('fas liked');
                } else {
                    heart.removeClass('fas liked').addClass('far');
                }
            },
            error: function (xhr) {
                console.error('브랜드 좋아요 실패:', xhr.responseText || xhr);
            }
        });
    }
})();
