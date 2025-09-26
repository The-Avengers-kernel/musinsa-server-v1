<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<div class="category-dropdown-overlay" id="categoryDropdownOverlay">
  <div class="category-dropdown-menu">
    <div class="dropdown-header">
      <a href="#product" class="tab-link active" data-tab="product">카테고리</a>
      <a href="#brand" class="tab-link" data-tab="brand">브랜드</a>
    </div>

    <div class="dropdown-content-container">

      <%-- 카테고리 (상품) 탭 내용 --%>
      <div class="tab-content active" id="product">
        <div class="dropdown-content">
          <div class="category-list">
            <ul>
              <%-- 초기 active 클래스 유지 --%>
              <li><a href="#" class="list-item-link active">상의</a></li>
              <li><a href="#" class="list-item-link">바지</a></li>
              <li><a href="#" class="list-item-link">아우터</a></li>
              <li><a href="#" class="list-item-link">스커트</a></li>
              <li><a href="#" class="list-item-link">원피스</a></li>
              <li><a href="#" class="list-item-link">가방</a></li>
              <li><a href="#" class="list-item-link">신발</a></li>
              <li><a href="#" class="list-item-link">속옷/홈웨어</a></li>
              <li><a href="#" class="list-item-link">패션잡화</a></li>
            </ul>
          </div>
          <div class="category-details">
            <div class="detail-section">
              <div class="detail-header">
                <h4>상의</h4>
                <a href="#" class="view-all">전체 보기</a>
              </div>
              <div class="detail-items">
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20241204/4650135/4650135_17333179596171_big.jpg?w=1200" alt="맨투맨/스웨트">
                  <span>맨투맨/스웨트</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20240227/3907161/3907161_17090356777279_big.jpg?w=1200" alt="후드 티셔츠">
                  <span>후드 티셔츠</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20250114/4719967/4719967_17555876557604_big.jpg?w=1200" alt="셔츠/블라우스">
                  <span>셔츠/블라우스</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20240105/3779386/3779386_17206852651191_big.jpg?w=1200" alt="긴소매 티셔츠">
                  <span>긴소매 티셔츠</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20250625/5207049/5207049_17509210153820_big.jpg?w=1200" alt="반소매 티셔츠">
                  <span>반소매 티셔츠</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20241219/4673051/4673051_17378042247619_big.jpg?w=1200" alt="피케/카라 티셔츠">
                  <span>피케/카라 티셔츠</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20240924/4459886/4459886_17276894385546_big.jpg?w=1200" alt="니트/스웨터">
                  <span>니트/스웨터</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20250422/5050163/5050163_17452892785039_big.jpg?w=1200" alt="민소매 티셔츠">
                  <span>민소매 티셔츠</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20220120/2318468/2318468_16788454797925_big.jpg?w=1200" alt="기타 상의">
                  <span>기타 상의</span>
                </a>
              </div>
            </div>
            <%-- 바지 섹션 --%>
            <div class="detail-section">
              <div class="detail-header">
                <h4>바지</h4>
                <a href="#" class="view-all">전체 보기</a>
              </div>
              <div class="detail-items">
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20241204/4650135/4650135_17333179596171_big.jpg?w=1200" alt="데님 팬츠">
                  <span>데님 팬츠</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20240227/3907161/3907161_17090356777279_big.jpg?w=1200" alt="트레이닝/조거 팬츠">
                  <span>트레이닝/조거 팬츠</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20250114/4719967/4719967_17555876557604_big.jpg?w=1200" alt="코튼 팬츠">
                  <span>코튼 팬츠</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20240105/3779386/3779386_17206852651191_big.jpg?w=1200" alt="슈트 팬츠/슬랙스">
                  <span>슈트 팬츠/슬랙스</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20250625/5207049/5207049_17509210153820_big.jpg?w=1200" alt="숏 팬츠">
                  <span>숏 팬츠</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20241219/4673051/4673051_17378042247619_big.jpg?w=1200" alt="레깅스">
                  <span>레깅스</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20240924/4459886/4459886_17276894385546_big.jpg?w=1200" alt="점프 슈트/오버올">
                  <span>점프 슈트/오버올</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20250422/5050163/5050163_17452892785039_big.jpg?w=1200" alt="기타 하의">
                  <span>기타 하의</span>
                </a>
              </div>
            </div>
            <%-- 아우터 섹션 --%>
            <div class="detail-section">
              <div class="detail-header">
                <h4>아우터</h4>
                <a href="#" class="view-all">전체 보기</a>
              </div>
              <div class="detail-items">
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20241204/4650135/4650135_17333179596171_big.jpg?w=1200" alt="후드 집업">
                  <span>후드 집업</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20240227/3907161/3907161_17090356777279_big.jpg?w=1200" alt="블루종/MA-1">
                  <span>블루종/MA-1</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20250114/4719967/4719967_17555876557604_big.jpg?w=1200" alt="레더/라이더스 재킷">
                  <span>레더/라이더스 재킷</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20240105/3779386/3779386_17206852651191_big.jpg?w=1200" alt="카디건">
                  <span>카디건</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20250625/5207049/5207049_17509210153820_big.jpg?w=1200" alt="트러커 재킷">
                  <span>트러커 재킷</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20241219/4673051/4673051_17378042247619_big.jpg?w=1200" alt="슈트/블레이저 재킷">
                  <span>슈트/블레이저 재킷</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20240924/4459886/4459886_17276894385546_big.jpg?w=1200" alt="스타디움 재킷">
                  <span>스타디움 재킷</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20250422/5050163/5050163_17452892785039_big.jpg?w=1200" alt="나일론/코치 재킷">
                  <span>나일론/코치 재킷</span>
                </a>
                <a href="#" class="item">
                  <img src="https://image.msscdn.net/thumbnails/images/goods_img/20250422/5050163/5050163_17452892785039_big.jpg?w=1200" alt="아노락 재킷">
                  <span>아노락 재킷</span>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>

      <%-- 브랜드 탭 내용 (무신사 스타일 초성 토글 적용) --%>
      <div class="tab-content" id="brand">
        <div class="dropdown-content brand-layout-content">

          <%-- 왼쪽 브랜드 카테고리 목록 --%>
          <div class="category-list">
            <ul>
              <%-- 초기 active 클래스 유지 --%>
              <li><a href="#" class="list-item-link active">전체</a></li>
              <li><a href="#" class="list-item-link">의류</a></li>
              <li><a href="#" class="list-item-link">뷰티</a></li>
              <li><a href="#" class="list-item-link">신발</a></li>
              <li><a href="#" class="list-item-link">스니커즈</a></li>
              <li><a href="#" class="list-item-link">가방</a></li>
              <li><a href="#" class="list-item-link">패션소품</a></li>
              <li><a href="#" class="list-item-link">속옷/홈웨어</a></li>
              <li><a href="#" class="list-item-link">스포츠/레저</a></li>
              <li><a href="#" class="list-item-link">디지털/라이프</a></li>
              <li><a href="#" class="list-item-link">키즈</a></li>
            </ul>
          </div>

          <%-- 오른쪽 브랜드 상세 내용 --%>
          <div class="brand-details-container">

            <%-- ✨ 초성 목록 및 버튼 영역 (수정 반영) ✨ --%>
            <div class="brand-initial-list-wrapper">

              <div class="initial-list-scroll-container">
                <%-- 가나다순 목록 (초기 비활성: ABC가 먼저 보이므로) --%>
                <div class="initial-list" id="koreanInitialList">
                  <a href="#" class="active">인기</a>
                  <a href="#">ㄱ</a>
                  <a href="#">ㄴ</a>
                  <a href="#">ㄷ</a>
                  <a href="#">ㄹ</a>
                  <a href="#">ㅁ</a>
                  <a href="#">ㅂ</a>
                  <a href="#">ㅅ</a>
                  <a href="#">ㅇ</a>
                  <a href="#">ㅈ</a>
                  <a href="#">ㅊ</a>
                  <a href="#">ㅋ</a>
                  <a href="#">ㅌ</a>
                  <a href="#">ㅍ</a>
                  <a href="#">ㅎ</a>
                  <a href="#">#</a>
                </div>

                <%-- ABC순 목록 (초기 활성: 무신사 기본) --%>
                <div class="initial-list active" id="englishInitialList">
                  <a href="#" class="active">인기</a>
                  <a href="#">A</a>
                  <a href="#">B</a>
                  <a href="#">C</a>
                  <a href="#">D</a>
                  <a href="#">E</a>
                  <a href="#">F</a>
                  <a href="#">G</a>
                  <a href="#">H</a>
                  <a href="#">I</a>
                  <a href="#">J</a>
                  <a href="#">K</a>
                  <a href="#">L</a>
                  <a href="#">M</a>
                  <a href="#">N</a>
                  <a href="#">O</a>
                  <a href="#">P</a>
                  <a href="#">Q</a>
                  <a href="#">R</a>
                  <a href="#">S</a>
                  <a href="#">T</a>
                  <a href="#">U</a>
                  <a href="#">V</a>
                  <a href="#">W</a>
                  <a href="#">X</a>
                  <a href="#">Y</a>
                  <a href="#">Z</a>
                </div>
              </div>

              <%-- 버튼 영역 (하나만 보이도록 겹쳐 놓음) --%>
              <%-- 초기에는 ABC 목록이 보이므로, '가나다순' 버튼이 표시되어야 합니다 (active) --%>
              <a href="#" class="sort-toggle-btn active" id="toggleToKorean" data-target="korean">
                <span class="btn-icon-text">가나다순</span>
                <i class="toggle-icon">⇌</i>
              </a>
              <%-- 'ABC순' 버튼은 숨겨져 있다가 '가나다순' 버튼 클릭 시 나타납니다 --%>
              <a href="#" class="sort-toggle-btn" id="toggleToEnglish" data-target="english">
                <span class="btn-icon-text">ABC순</span>
                <i class="toggle-icon">⇌</i>
              </a>
            </div>


            <%-- 브랜드 리스트 (스크롤 영역) --%>
            <div class="brand-scroll-list">
              <ul class="brand-item-list">
                <%-- 여기에 나머지 브랜드 목록이 JSTL/데이터로 채워져야 합니다. --%>
                <li>
                  <a href="#">
                    <div class="brand-info">
                      <img src="https://image.musinsa.com/images/brand/logo/MUSINS_STANDARD.png" alt="무신사 스탠다드 로고">
                      <div class="text-info">
                        <p class="kor-name">무신사 스탠다드<br><span class="eng-name">MUSINSA STANDARD</span></p>
                      </div>
                    </div>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<%-- -------------------------------------------------------------------------- --%>
<%-- 🌟 JavaScript 로직 (최종 수정 반영) 🌟 --%>
<%-- -------------------------------------------------------------------------- --%>
<script>
  document.addEventListener("DOMContentLoaded", () => {

    // --------------------------------------------------------
    // 1. DOM 요소 선택 및 기본 변수 정의
    // --------------------------------------------------------
    const menuBtn = document.getElementById("menuBtn");
    const overlay = document.getElementById("categoryDropdownOverlay");
    const tabLinks = document.querySelectorAll(".tab-link");
    const tabContents = document.querySelectorAll(".tab-content");

    // Product 탭 요소
    const productLinks = document.querySelectorAll("#product .category-list .list-item-link");
    const productSections = document.querySelectorAll("#product .category-details .detail-section");

    // Brand 탭 요소
    const brandLinks = document.querySelectorAll("#brand .category-list .list-item-link");
    const toggleToKoreanBtn = document.getElementById('toggleToKorean');
    const toggleToEnglishBtn = document.getElementById('toggleToEnglish');
    const koreanList = document.getElementById('koreanInitialList');
    const englishList = document.getElementById('englishInitialList');
    const initialLinks = document.querySelectorAll('.initial-list a');

    // --------------------------------------------------------
    // 2. 햄버거 메뉴 열기/닫기
    // --------------------------------------------------------
    if (menuBtn && overlay) {
      menuBtn.addEventListener("click", () => overlay.classList.add("active"));
      overlay.addEventListener("click", (e) => {
        if (e.target === overlay) overlay.classList.remove("active");
      });
    }

    // --------------------------------------------------------
    // 3. 상단 탭 전환 (카테고리/브랜드)
    // --------------------------------------------------------
    tabLinks.forEach(link => {
      link.addEventListener("click", (e) => {
        e.preventDefault();
        const targetId = link.getAttribute("data-tab");

        tabLinks.forEach(l => l.classList.remove("active"));
        tabContents.forEach(c => c.classList.remove("active"));

        link.classList.add("active");
        document.getElementById(targetId).classList.add("active");

        // 탭 전환 시: 왼쪽 목록을 '전체' 또는 '상의'로 초기화 클릭
        document.querySelector(`#${targetId} .category-list a:first-child`)?.click();
      });
    });

    // --------------------------------------------------------
    // 4. 상품(Product) 탭: 목록 클릭 시 스크롤 이동
    // --------------------------------------------------------
    productLinks.forEach(link => {
      link.addEventListener("click", (e) => {
        e.preventDefault();
        const menuName = link.textContent.trim();

        productLinks.forEach(l => l.classList.remove("active"));
        link.classList.add("active");

        const targetSection = Array.from(productSections).find(section => {
          const header = section.querySelector("h4");
          return header && header.textContent.trim() === menuName;
        });

        if (targetSection) {
          targetSection.scrollIntoView({ behavior: "smooth", block: "start" });
        }
      });
    });

    // --------------------------------------------------------
    // 5. 왼쪽 브랜드 카테고리 클릭 이벤트
    // --------------------------------------------------------
    brandLinks.forEach(link => {
      link.addEventListener('click', function(e) {
        e.preventDefault();

        // a. 현재 활성화된 카테고리 항목의 active 클래스 제거
        brandLinks.forEach(l => l.classList.remove("active"));

        // b. 클릭된 항목에 active 클래스 추가 (볼드체 활성화)
        this.classList.add('active');

        // c. 초성 목록을 '인기'로 초기화
        initialLinks.forEach(item => {
          item.classList.remove('active');
        });

        const activeList = document.querySelector('.initial-list.active');
        if (activeList) {
          const firstItem = activeList.querySelector('a:first-child');
          if (firstItem) {
            firstItem.classList.add('active');
          }
        }
      });
    });

    // --------------------------------------------------------
    // 6. 초성/ABC순 목록 전환 버튼 클릭 이벤트 (최종 반영)
    // --------------------------------------------------------
    function handleToggleClick(e) {
      e.preventDefault();
      const target = this.getAttribute('data-target');

      // 1. 버튼 상태 전환: 클릭된 버튼을 숨기고, 반대쪽 버튼을 표시
      if (target === 'english') {
        // 'ABC순' 버튼을 클릭 -> 'ABC순' 목록 표시
        englishList.classList.add('active');
        koreanList.classList.remove('active');

        // 버튼 교체: 'ABC순' 버튼 숨기고, '가나다순' 버튼 표시
        toggleToEnglishBtn.classList.remove('active');
        toggleToKoreanBtn.classList.add('active');

      } else {
        // '가나다순' 버튼을 클릭 -> '가나다순' 목록 표시
        koreanList.classList.add('active');
        englishList.classList.remove('active');

        // 버튼 교체: '가나다순' 버튼 숨기고, 'ABC순' 버튼 표시
        toggleToKoreanBtn.classList.remove('active');
        toggleToEnglishBtn.classList.add('active');
      }

      // 2. 목록이 전환되면 '인기' 항목으로 활성화 초기화
      document.querySelectorAll('.initial-list a').forEach(item => {
        item.classList.remove('active');
      });

      const activeList = document.querySelector('.initial-list.active');
      if (activeList) {
        activeList.querySelector('a:first-child')?.classList.add('active');
      }
    }

    // 이벤트 리스너 할당
    toggleToKoreanBtn.addEventListener('click', handleToggleClick);
    toggleToEnglishBtn.addEventListener('click', handleToggleClick);


    // --------------------------------------------------------
    // 7. 초성 항목 (인기, ㄱ, ㄴ, ㄷ, A, B, C...) 클릭 이벤트
    // --------------------------------------------------------
    initialLinks.forEach(link => {
      link.addEventListener('click', function(e) {
        e.preventDefault();

        const parentList = this.closest('.initial-list');
        const currentInitialActive = parentList ? parentList.querySelector('a.active') : null;

        // 현재 활성화된 초성 항목의 active 클래스 제거
        if (currentInitialActive) {
          currentInitialActive.classList.remove('active');
        }

        // 클릭된 항목에 active 클래스 추가 (볼드체 활성화)
        this.classList.add('active');
      });
    });

    // --------------------------------------------------------
    // 8. 초기 로딩 시 기본 활성화 설정
    // --------------------------------------------------------

    // 왼쪽 카테고리의 '상의'와 '전체'에 active 클래스 설정
    document.querySelector('#product .category-list a:first-child')?.classList.add('active');
    document.querySelector('#brand .category-list a:first-child')?.classList.add('active');

    // 초성 목록의 '인기' 항목에 active 클래스 설정
    document.querySelector('#koreanInitialList a:first-child')?.classList.add('active');
    document.querySelector('#englishInitialList a:first-child')?.classList.add('active');

    // 상품(Product) 탭: 모든 상세 섹션 표시 (스크롤 이동 방식)
    productSections.forEach(s => s.style.display = "block");

    // 브랜드 탭 초기 토글 버튼 상태 설정 (ABC 목록이 보이므로, 가나다 버튼이 active)
    toggleToKoreanBtn.classList.add('active');
    toggleToEnglishBtn.classList.remove('active');
  });
</script>