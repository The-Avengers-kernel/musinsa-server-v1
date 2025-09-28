$(document).ready(() => {

    // --------------------------------------------------------
    // 0. 브랜드 목록 렌더링 함수 및 데이터 비동기 로딩
    // --------------------------------------------------------
    const $brandItemList = $("#brandItemList");
    const BRAND_PLACEHOLDER = "https://image.musinsa.com/images/brand/logo/default.png";

    function renderBrands(data) {
        if (!$brandItemList.length) return;
        $brandItemList.empty();
        if (!Array.isArray(data)) return;

        const items = data.map(brands => `
            <li>
                <a href="#">
                    <div class="brand-info">
                        <img src="${brands.brandImage || BRAND_PLACEHOLDER}" alt="${brands.brandNameKr || ''} 로고">
                        <div class="text-info">
                            <p class="kor-name">
                                ${brands.brandNameKr || ''}<br>
                                <span class="eng-name">${brands.brandNameEn || ''}</span>
                            </p>
                        </div>
                    </div>
                </a>
            </li>
        `).join('');

        $brandItemList.html(items);
    }

    function loadBrands(categoryId) {
        const url = categoryId === "all"
            ? "/api/v1/categories/brands"
            : `/api/v1/categories/${categoryId}/brands`;

        $.ajax({
            url: url,
            type: "GET",
            dataType: "json",
            success: function(data) {
                renderBrands(data);
            },
            error: function() {
                if ($brandItemList.length) {
                    $brandItemList.html("<li>브랜드 정보를 불러오지 못했습니다.</li>");
                }
            }
        });
    }

    loadBrands("all");

    // --------------------------------------------------------
    // 1. DOM 요소 선택
    // --------------------------------------------------------
    const $menuBtn = $("#menuBtn");
    const $overlay = $("#categoryDropdownOverlay");
    const $tabLinks = $(".tab-link");
    const $tabContents = $(".tab-content");
    const $toggleToKoreanBtn = $('#toggleToKorean');
    const $toggleToEnglishBtn = $('#toggleToEnglish');
    const $koreanList = $('#koreanInitialList');
    const $englishList = $('#englishInitialList');

    // --------------------------------------------------------
    // 2. 햄버거 메뉴 열기/닫기
    // -------------------      -------------------------------------
    $menuBtn.on("click", () => $overlay.addClass("active"));
    $overlay.on("click", (e) => {
        if (e.target === e.currentTarget) {
            $overlay.removeClass("active");
        }
    });

    // --------------------------------------------------------
    // 3. 상단 탭 전환 (카테고리/브랜드)
    // --------------------------------------------------------
    $tabLinks.on("click", function(e) {
        e.preventDefault();
        const targetId = $(this).data("tab");

        $tabLinks.removeClass("active");
        $(this).addClass("active");

        $tabContents.removeClass("active");
        $(`#${targetId}`).addClass("active");

        // 탭 전환 시 해당 탭의 첫 번째 목록 아이템을 클릭하여 상태 초기화
        $(`#${targetId} .category-list a:first-child`).trigger('click');
    });

    // --------------------------------------------------------
    // 4. 상품(Product) 탭: 왼쪽 목록 클릭 시 우측 상세 섹션으로 스크롤
    // --------------------------------------------------------
    $("#product .category-list").on("click", ".list-item-link", function(e) {
        e.preventDefault();
        const targetSectionId = $(this).data("target");

        $("#product .list-item-link").removeClass("active");
        $(this).addClass("active");

        const $targetSection = $(`#${targetSectionId}`);
        if ($targetSection.length) {
            $targetSection[0].scrollIntoView({ behavior: "smooth", block: "start" });
        }
    });

    // --------------------------------------------------------
    // 5. 왼쪽 브랜드 카테고리 클릭 이벤트
    // --------------------------------------------------------
    $("#brand .category-list").on("click", ".list-item-link", function(e) {
        e.preventDefault();
        const categoryId = $(this).data("id");

        // 모든 링크에서 active 클래스 제거 후 현재 클릭된 링크에만 추가
        $("#brand .category-list .list-item-link").removeClass("active");
        $(this).addClass("active");

        // 해당 카테고리 ID로 브랜드 목록 로드
        loadBrands(categoryId);

        // 초성 목록 '인기'로 초기화
        $('.initial-list a').removeClass('active');
        $('.initial-list.active a:first-child').addClass('active');
    });

    // --------------------------------------------------------
    // 6. 초성/ABC순 목록 전환 버튼 클릭 이벤트
    // --------------------------------------------------------
    function handleToggleClick(e) {
        e.preventDefault();
        const isEnglishTarget = $(this).data('target') === 'english';

        $englishList.toggleClass('active', isEnglishTarget);
        $koreanList.toggleClass('active', !isEnglishTarget);

        $toggleToEnglishBtn.toggleClass('active', !isEnglishTarget);
        $toggleToKoreanBtn.toggleClass('active', isEnglishTarget);

        // 목록 전환 후, 선택 상태를 '인기'로 초기화
        $('.initial-list a').removeClass('active');
        $('.initial-list.active a:first-child').addClass('active');
    }

    $toggleToKoreanBtn.on('click', handleToggleClick);
    $toggleToEnglishBtn.on('click', handleToggleClick);

    // --------------------------------------------------------
    // 7. 초성 항목 (인기, ㄱ, A...) 클릭 이벤트
    // --------------------------------------------------------
    $(".initial-list").on("click", "a", function(e) {
        e.preventDefault();
        $(this).siblings().removeClass("active");
        $(this).addClass("active");

        // TODO: 클릭된 초성에 맞는 브랜드 목록 필터링 로직 추가
    });

    // --------------------------------------------------------
    // 8. 초기 활성화 설정
    // --------------------------------------------------------
    function initialize() {
        $('#product .category-list a:first-child').addClass('active');
        $('#brand .category-list a:first-child').addClass('active');

        $('#koreanInitialList a:first-child').addClass('active');
        $('#englishInitialList a:first-child').addClass('active');

        $toggleToKoreanBtn.addClass('active');
        $toggleToEnglishBtn.removeClass('active');
    }

    initialize();
});
