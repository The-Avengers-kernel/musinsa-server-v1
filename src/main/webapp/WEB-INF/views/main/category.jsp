<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<div class="category-dropdown-overlay" id="categoryDropdownOverlay">
  <div class="category-dropdown-menu">
    <div class="dropdown-header">
      <a href="#product" class="tab-link active" data-tab="product">카테고리</a>
      <a href="#brand" class="tab-link" data-tab="brand">브랜드<i class="fas fa-angle-down"></i></a>
    </div>

    <div class="dropdown-content-container">

      <%-- 카테고리 (상품) 탭 내용 --%>
      <div class="tab-content active" id="product">
        <div class="dropdown-content">
          <div class="category-list">
            <ul>
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

            <div class="detail-section">
              <div class="detail-header">
                <h4>하의</h4>
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
          </div>
        </div>
      </div>

      <%-- 브랜드 탭 내용 (새 디자인 및 토글 기능 적용) --%>
      <div class="tab-content" id="brand">
        <div class="dropdown-content brand-layout-content"> 
          
          <%-- 왼쪽 브랜드 카테고리 목록 --%>
          <div class="category-list">
            <ul>
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
            
            <%-- 성별 탭 및 검색 영역 --%>
            <div class="brand-details-header">
              <div class="gender-tabs">
                <button class="gender-tab active">전체</button>
                <button class="gender-tab">남성</button>
                <button class="gender-tab">여성</button>
              </div>
              
              <div class="brand-search-box">
                <input type="text" placeholder="브랜드를 검색하세요" class="brand-search-input">
                <i class="fas fa-search search-icon"></i>
              </div>
            </div>
            
            <%-- 한글/알파벳 토글 목록 (아이콘 추가됨) --%>
            <div class="brand-initial-list-wrapper">
              
              <div class="initial-list active" id="koreanInitialList">
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
                  <a href="#" class="toggle-initial-btn" data-target="english">ABC순 <i class="fas fa-angle-right"></i></a>
              </div>
              
              <div class="initial-list" id="englishInitialList">
                  <a href="#" class="active">A</a>
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
                  <a href="#" class="toggle-initial-btn" data-target="korean">가나다순 <i class="fas fa-angle-right"></i></a>
              </div>
            </div>
            
            <%-- 브랜드 리스트 (스크롤 영역) --%>
            <div class="brand-scroll-list">
              <h4 class="brand-list-title">인기 브랜드 <span class="brand-count">100개</span></h4>
              
              <ul class="brand-item-list">
                <%-- 브랜드 리스트 아이템 예시 --%>
                <li>
                  <a href="#">
                    <div class="brand-info">
                      <img src="https://image.musinsa.com/images/brand/logo/MUSINS_STANDARD.png" alt="무신사 스탠다드 로고">
                      <div class="text-info">
                        <p class="kor-name">무신사 스탠다드 <span class="exclusive">단독</span></p>
                        <p class="eng-name">MUSINSA STANDARD</p>
                      </div>
                    </div>
                    <i class="far fa-heart heart-icon"></i>
                  </a>
                </li>
                <li>
                  <a href="#">
                    <div class="brand-info">
                      <img src="https://image.musinsa.com/images/brand/logo/ADIDAS.png" alt="아디다스 로고">
                      <div class="text-info">
                        <p class="kor-name">아디다스</p>
                        <p class="eng-name">ADIDAS</p>
                      </div>
                    </div>
                    <i class="far fa-heart heart-icon"></i>
                  </a>
                </li>
                <li>
                  <a href="#">
                    <div class="brand-info">
                      <img src="https://image.musinsa.com/images/brand/logo/MUSINS_STANDARD_WOMAN.png" alt="무신사 스탠다드 우먼 로고">
                      <div class="text-info">
                        <p class="kor-name">무신사 스탠다드 우먼 <span class="exclusive">단독</span></p>
                        <p class="eng-name">MUSINSA STANDARD WOMAN</p>
                      </div>
                    </div>
                    <i class="far fa-heart heart-icon"></i>
                  </a>
                </li>
                <%-- ... 더 많은 브랜드 아이템 ... --%>
              </ul>
            </div>
          </div>
        </div>
      </div>

      <%-- 서비스 탭 내용 --%>
      <div class="tab-content" id="service">
        <div class="service-content">
          <h3>서비스 메뉴</h3>
          <p>MUSINSA PLAYER, OUTLET, BOUTIQUE 등 서비스 관련 상세 내용이 여기에 표시됩니다.</p>
          <ul>
            <li><a href="#">MUSINSA PLAYER</a></li>
            <li><a href="#">MUSINSA OUTLET</a></li>
            <li><a href="#">MUSINSA BOUTIQUE</a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>

<%-- JavaScript --%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
  $(document).ready(function() {
    // 햄버거 버튼 클릭 시 드롭다운 메뉴 토글 (실제 이벤트는 header.jsp의 #menuBtn에 연결 가정)
    $('#menuBtn').on('click', function() {
      $('#categoryDropdownOverlay').toggleClass('active');
      $(this).toggleClass('active');
    });

    // 오버레이 외부 클릭 시 메뉴 닫기
    $('#categoryDropdownOverlay').on('click', function(e) {
      if ($(e.target).is('#categoryDropdownOverlay')) {
        $(this).removeClass('active');
        $('#menuBtn').removeClass('active');
      }
    });

    // 탭 전환 기능
    $('.tab-link').on('click', function(e) {
      e.preventDefault();
      const targetTab = $(this).data('tab');

      // 탭 링크 활성화
      $('.tab-link').removeClass('active');
      $(this).addClass('active');

      // 내용 전환
      $('.tab-content').removeClass('active');
      $('#' + targetTab).addClass('active');

      // 좌측 카테고리 목록 초기화 및 기본 active 설정
      $('.category-list ul li a.list-item-link').removeClass('active'); // 모든 좌측 항목 active 제거

      if (targetTab === 'product') {
        // 상품 탭일 경우 '상의'를 active
        $('#product .category-list ul li a:contains("상의")').addClass('active');
      } else if (targetTab === 'brand') {
        // 브랜드 탭일 경우 '전체'를 active
        $('#brand .category-list ul li a:contains("전체")').addClass('active');
      }
    });

    // 카테고리 리스트 호버 기능
    $('.category-list ul li a.list-item-link').on('mouseenter', function() {
      $('.category-list ul li a.list-item-link').removeClass('active');
      $(this).addClass('active');
      // 여기에 AJAX 호출 또는 데이터 로드 로직 추가 (카테고리 상세 내용 변경)
    })

    // **** [핵심] 초성 목록 토글 기능 ****
    $('.toggle-initial-btn').on('click', function(e) {
        e.preventDefault();
        const target = $(this).data('target');
        
        // 현재 활성화된 목록 숨기기
        $('.initial-list').removeClass('active');
        
        // 목표 목록 활성화
        if (target === 'english') {
            $('#englishInitialList').addClass('active');
        } else if (target === 'korean') {
            $('#koreanInitialList').addClass('active');
        }
    });
  });
</script>