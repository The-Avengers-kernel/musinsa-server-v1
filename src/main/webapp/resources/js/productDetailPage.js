let productVariants = [];
let quantity = 1;

// 한국식 숫자 포맷팅 함수
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
        return num.toString();
    }
}

// URL에서 productId 추출하는 함수
function getProductIdFromUrl() {
    const pathParts = window.location.pathname.split('/');
    const productIndex = pathParts.indexOf('products');
    if (productIndex !== -1 && pathParts[productIndex + 1]) {
        return parseInt(pathParts[productIndex + 1]);
    }
    return 1; // 기본값
}

// 제품 상세 정보 AJAX
$(document).ready(function () {
    // 수량 조절 버튼들
    $('#increase-btn').on('click', function () {
        quantity++;
        $('#quantity-input').val(quantity);
    });

    $('#decrease-btn').on('click', function () {
        if (quantity > 1) {
            quantity--;
            $('#quantity-input').val(quantity);
        }
    });

    // 숫자만 입력 가능하도록
    $('#quantity-input').on('input', function () {
        let value = parseInt($(this).val()) || 1;
        if (value < 1) value = 1;
        quantity = value;
        $(this).val(quantity);
    });

    const productId = getProductIdFromUrl(); // URL에서 productId 가져오기
    let brandId = null;  // 전역 변수 선언
    $.ajax({
        url: '/api/v1/products/' + productId,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            brandId = data.brandId;  // 변수에 저장
            $('#productId').text(data.productId);
            $('#brandId').text(data.brandId);  // ← 이 줄 추가
            $('#productName').text(data.productName);
            $('#brandName').text(data.brandName);
            // 상품 좋아요 상태 설정
            if (data.isProductLiked) {
                $('.wishlist-icon .heart-icon').removeClass('far').addClass('fas').addClass('liked');
            } else {
                $('.wishlist-icon .heart-icon').removeClass('fas').removeClass('liked').addClass('far');
            }

            // 브랜드 좋아요 상태 설정
            if (data.isBrandLiked) {
                $('.brand-wishlist-icon .heart-icon').removeClass('far').addClass('fas').addClass('liked');
            } else {
                $('.brand-wishlist-icon .heart-icon').removeClass('fas').removeClass('liked').addClass('far');
            }
            $('#productPrice').text(data.price.toLocaleString() + '원');
            $('#productDiscount').text(data.brandDiscount + '%');
            $('#productTotalPrice').text(data.finalprice.toLocaleString() + '원');
            $('#finalPrice').text(data.finalprice.toLocaleString() + '원');
            $('#productLikeCnt').text(formatKoreanNumber(data.productLikeCnt));
            $('#brandLikeCnt').text(formatKoreanNumber(data.brandLikeCnt));

            console.log('전체 데이터:', data);
            console.log('brandId:', data.brandId);
            console.log('isProductLiked:', data.isProductLiked);
            console.log('isBrandLiked:', data.isBrandLiked);
            if (data.brandImage) {
                const imgTag = $('<img>').attr('src', data.brandImage).attr('alt', data.brandName).addClass('brand-logo-img');
                $('#brand-image-container').empty().append(imgTag);
            }

            if (data.detailSizeImage) {
                const imgTag = $('<img>').attr('src', data.detailSizeImage).attr('alt', '제품 실측 이미지').addClass('detail-size-img');
                $('#detailSizeImage').empty().append(imgTag);
            }

            const $mainImageContainer = $('.main-image-container').empty();
            const $thumbnailImages = $('#thumbnailImages').empty();

            if (data.productImageList && data.productImageList.length) {
                let firstImageUrl = '';

                // 모든 이미지를 썸네일로 표시하고, 첫 번째 이미지를 메인으로 설정
                data.productImageList.forEach(function (img, index) {
                    // 첫 번째 이미지를 메인 이미지로 설정
                    if (index === 0) {
                        firstImageUrl = img.imageUrl;
                        const mainImg = $('<img>').attr('src', img.imageUrl).attr('alt', 'Product Image');
                        $mainImageContainer.append(mainImg);
                    }

                    // 모든 이미지를 썸네일로 추가
                    const $previewItem = $('<div>')
                        .addClass('preview-item')
                        .attr('data-image-url', img.imageUrl);

                    // 첫 번째 이미지에 active 클래스 추가
                    if (index === 0) {
                        $previewItem.addClass('active');
                    }

                    const imgTag = $('<img>').attr('src', img.imageUrl).attr('alt', img.imageType || 'Product Image');
                    $previewItem.append(imgTag);
                    $thumbnailImages.append($previewItem);
                });

                // 썸네일 클릭 이벤트
                $('.preview-item').on('click', function () {
                    const imageUrl = $(this).attr('data-image-url');

                    // 활성 클래스 변경
                    $('.preview-item').removeClass('active');
                    $(this).addClass('active');

                    // 메인 이미지 변경
                    $mainImageContainer.find('img').attr('src', imageUrl);
                });
            }

            // 옵션 로드
            loadProductOptions(data.productId);
        },
        error: function (xhr, status, error) {
            console.error('제품 정보 로드 오류:', error);
        }
    });

    // 옵션 로드 함수
    function loadProductOptions(productId) {
        $.ajax({
            url: `/api/v1/products/${productId}/options`,
            method: 'GET',
            dataType: 'json',
            success: function (variants) {
                productVariants = variants;

                const colors = [...new Set(variants.map(v => v.productColor))];
                const sizes = [...new Set(variants.map(v => v.productsSize))];

                // 색상 코드 매핑
                const colorMapping = {
                    'Black': '#000000',
                    'blue': '#4A9BDC',
                    'yellow': '#FFE59D',
                    'green': '#4DAE4D',
                    'red': '#FF0000',
                };

                // 색상 스와치 생성
                const $colorSwatches = $('#colorSwatches');
                $colorSwatches.empty();
                colors.forEach((color, index) => {
                    if (color && color.trim() !== '') {
                        const colorCode = colorMapping[color] || '#cccccc';
                        const $swatch = $('<div>')
                            .addClass('color-swatch')
                            .attr('data-color', color)
                            .css('background-color', colorCode)
                            .attr('title', color);

                        if (index === 0) $swatch.addClass('selected');
                        $colorSwatches.append($swatch);
                    }
                });

                // 색상 드롭다운
                const colorSelect = $('#color-select');
                colorSelect.empty().append('<option value="">컬러</option>');
                colors.forEach(color => {
                    if (color && color.trim() !== '') {
                        const option = $('<option>').val(color).text(color);
                        colorSelect.append(option);
                    }
                });

                // 사이즈 드롭다운
                const sizeSelect = $('#size-select');
                sizeSelect.empty().append('<option value="">사이즈</option>');
                sizes.forEach(size => {
                    if (size && size.trim() !== '') {
                        const option = $('<option>').val(size).text(size);
                        sizeSelect.append(option);
                    }
                });

                // 색상 스와치 클릭 이벤트
                $('.color-swatch').on('click', function () {
                    $('.color-swatch').removeClass('selected');
                    $(this).addClass('selected');
                    const selectedColor = $(this).attr('data-color');
                    $('#color-select').val(selectedColor);
                });
            },
            error: function (xhr, status, error) {
                console.error('상품 옵션 로드 실패:', error);
            }
        });
    }

    // 장바구니 담기
    $('.add-to-cart-btn').on('click', function () {
        const productId = parseInt($('#productId').text());
        const selectedColor = $('#color-select').val();
        const selectedSize = $('#size-select').val();


        if (!selectedColor) {
            alert('색상을 선택해주세요');
            return;
        }
        if (!selectedSize) {
            alert('사이즈를 선택해주세요');
            return;
        }

        const selectedVariant = productVariants.find(v =>
            v.productColor === selectedColor && v.productsSize === selectedSize
        );

        if (!selectedVariant) {
            alert('해당 옵션의 상품을 찾을 수 없습니다.');
            return;
        }

        const cartData = {
            productId: productId,
            quantity: parseInt($('#quantity-input').val()) || 1,
            // productVariantId: selectedVariant.productVariantId,
            variantName: selectedVariant.variantName
        };

        $.ajax({
            url: '/api/v1/carts',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(cartData),
            success: function (response) {
                console.log('장바구니 추가 제품 정보 : ', cartData);
                alert('장바구니에 상품을 추가했습니다.');
            },
            error: function (xhr, status, error) {
                alert('장바구니 추가에 실패했습니다.');
            }
        });
    });

    // 구매하기 버튼
    $('.buy-now').on('click', function () {
        const productId = parseInt($('#productId').text());
        const selectedColor = $('#color-select').val();
        const selectedSize = $('#size-select').val();

        if (!selectedColor) {
            alert('색상을 선택해주세요.');
            return;
        }
        if (!selectedSize) {
            alert('사이즈를 선택해주세요.');
            return;
        }

        const selectedVariant = productVariants.find(v =>
            v.productColor === selectedColor && v.productsSize === selectedSize
        );

        if (!selectedVariant) {
            alert('해당 옵션의 상품을 찾을 수 없습니다.');
            return;
        }

        const purchaseData = {
            type: "DIRECT_PURCHASE",
            productId: productId,
            quantity: parseInt($('#quantity-input').val()) || 1,
            productVariantId: selectedVariant.productVariantId,
            optionName: selectedVariant.variantName
        };

        $.ajax({
            url: '/product/direct-purchase',  // ✅ 새로운 뷰 컨트롤러 URL
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(purchaseData),
            xhrFields: {
                withCredentials: true  // 쿠키 전송 활성화
            },
            success: function (response) {
                console.log('구매할 제품 정보:', purchaseData);

                if (response.success && response.redirectUrl) {
                    // 서버에서 반환한 리다이렉트 URL로 이동
                    window.location.href = response.redirectUrl;
                } else {
                    alert('구매 페이지로 이동합니다.');
                    window.location.href = '/orders/order-page';
                }
            },
            error: function (xhr, status, error) {
                console.error('구매 요청 실패:', error);
                console.error('상태 코드:', xhr.status);
                console.error('응답:', xhr.responseText);

                // 에러 메시지 파싱 시도
                try {
                    const errorResponse = JSON.parse(xhr.responseText);
                    alert(errorResponse.message || '구매 요청에 실패했습니다.');
                } catch (e) {
                    alert('구매 요청에 실패했습니다.');
                }
            }
        });
    });

    // 제품 좋아요 버튼
    $('.wishlist-icon').on('click', function () {
        const productId = parseInt($('#productId').text());

        $.ajax({
            url: `/api/v1/products/${productId}/liked`,
            method: 'POST',
            dataType: 'json',
            success: function (response) {
                console.log('좋아요 버튼 클릭:', response);

                // 좋아요 수 업데이트
                if (response.likeCount !== undefined) {
                    const $likeCnt = $('#productLikeCnt');
                    $likeCnt.text(formatKoreanNumber(response.likeCount));

                    // 숫자 변경 애니메이션
                    $likeCnt.addClass('like-count-updated');
                    setTimeout(function() {
                        $likeCnt.removeClass('like-count-updated');
                    }, 300);
                }

                // 하트 아이콘 토글
                const heartIcon = $('.wishlist-icon .heart-icon');
                if (response.liked) {
                    heartIcon.removeClass('far').addClass('fas').addClass('liked');
                } else {
                    heartIcon.removeClass('fas').removeClass('liked').addClass('far');
                }
            },
            error: function (xhr, status, error) {
                console.error('좋아요 처리 실패:', error);
            }
        });
    });

    // 브랜드 좋아요 버튼
    $('.brand-wishlist-icon').on('click', function () {
        const brandId = parseInt($('#brandId').text());

        console.log('brandId text:', $('#brandId').text());
        console.log('brandId parsed:', brandId);

        if (!brandId || isNaN(brandId)) {
            alert('brandId를 찾을 수 없습니다.');
            return;
        }

        const apiUrl = '/api/v1/brands/' + brandId + '/liked';  // + 연결자 사용
        console.log('최종 URL:', apiUrl);

        $.ajax({
            url: apiUrl,  // 변수 사용
            method: 'POST',
            xhrFields: {
                withCredentials: true
            },
            dataType: 'json',
            success: function (response) {
                console.log('브랜드 좋아요:', response);

                // 좋아요 수 업데이트
                if (response.likeCount !== undefined) {
                    const $likeCnt = $('#brandLikeCnt');
                    $likeCnt.text(formatKoreanNumber(response.likeCount));

                    // 숫자 변경 애니메이션
                    $likeCnt.addClass('like-count-updated');
                    setTimeout(function() {
                        $likeCnt.removeClass('like-count-updated');
                    }, 300);
                }

                // 하트 아이콘 토글
                const heartIcon = $('.brand-wishlist-icon .heart-icon');
                if (response.liked) {
                    heartIcon.removeClass('far').addClass('fas').addClass('liked');
                } else {
                    heartIcon.removeClass('fas').removeClass('liked').addClass('far');
                }
            },
            error: function (xhr, status, error) {
                console.error('좋아요 처리 실패:', error);
            }
        });
    });
});

$(document).ready(function () {
    const productId = getProductIdFromUrl(); // URL에서 productId 가져오기

    // 카테고리 로드
    $.ajax({
        url: '/api/v1/products/' + productId + '/categories',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            if (data.productCategoryList && data.productCategoryList.length) {
                const names = data.productCategoryList.map(c => c.categoryName);
                $('#categoryName').text(names.join(' > '));
            }
        }
    });

    // 상세 설명 로드
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

    // 사이즈 정보 로드
    $.ajax({
        url: '/api/v1/products/' + productId + '/detail-size-list',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            const $sizeListContainer = $('#productDetailSizeList');
            $sizeListContainer.empty();

            console.log('사이즈 데이터:', data);

            if (data && data.length > 0) {
                const firstImageId = Number(data[0].sizeDetailImageId);
                console.log('firstImageId:', firstImageId, 'type:', typeof firstImageId);

                if (firstImageId === 1 || firstImageId === 2) {
                    const $table = $('<table>').addClass('size-table');
                    const $thead = $('<thead>').html(
                        '<tr><th>사이즈</th><th>총장</th><th>어깨너비</th><th>가슴단면</th><th>소매길이</th></tr>'
                    );
                    const $tbody = $('<tbody>');

                    data.forEach(function (size) {
                        $tbody.append($('<tr>').append(
                            $('<td>').text(size.cm),
                            $('<td>').text(size.length),
                            $('<td>').text(size.shoulderWidth),
                            $('<td>').text(size.chestWidth),
                            $('<td>').text(size.sleaveLength)
                        ));
                    });

                    $sizeListContainer.append('<h3>상의 실측 사이즈 (cm)</h3>');
                    $sizeListContainer.append($table.append($thead).append($tbody));
                } else if (firstImageId === 3 || firstImageId === 4) {
                    const $table = $('<table>').addClass('size-table');
                    const $thead = $('<thead>').html(
                        '<tr><th>사이즈</th><th>총장</th><th>허리단면</th><th>엉덩이단면</th><th>허벅지단면</th><th>밑위</th><th>밑단단면</th></tr>'
                    );
                    const $tbody = $('<tbody>');

                    data.forEach(function (size) {
                        $tbody.append($('<tr>').append(
                            $('<td>').text(size.cm),
                            $('<td>').text(size.length),
                            $('<td>').text(size.waist),
                            $('<td>').text(size.hip),
                            $('<td>').text(size.thigh),
                            $('<td>').text(size.rise),
                            $('<td>').text(size.hemWidth)
                        ));
                    });

                    $sizeListContainer.append('<h3>하의 실측 사이즈 (cm)</h3>');
                    $sizeListContainer.append($table.append($thead).append($tbody));
                }


            }
        }
    });

    // 리뷰 로드
    $.ajax({
        url: '/api/v1/products/' + productId + '/reviews',
        method: 'GET',
        dataType: 'json',
        success: function (reviews) {
            const $reviewsContainer = $('#productsReviews');
            $reviewsContainer.empty();

            if (reviews && reviews.length > 0) {
                reviews.forEach(function (review) {
                    const $reviewItem = $('<div>').addClass('review-item')
                        .append($('<div>').addClass('review-header')
                            .append($('<strong>').addClass('review-nickname').text(review.nickName)))
                        .append($('<div>').addClass('review-body')
                            .append($('<p>').addClass('review-content').text(review.content)))
                        .append($('<div>').addClass('review-footer')
                            .append($('<span>').text('구매옵션: ' + review.purchaseOptions))
                            .append($('<button>').addClass('review-help-button')
                                .text('도움이 돼요 ' + review.helpCount)));
                    $reviewsContainer.append($reviewItem);
                });
            }
        }
    });
});
