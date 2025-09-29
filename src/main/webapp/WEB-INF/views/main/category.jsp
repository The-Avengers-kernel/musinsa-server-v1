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
                            <%-- data-target 속성 추가 --%>
                            <li><a href="#" class="list-item-link" data-target="tops">상의</a></li>
                            <li><a href="#" class="list-item-link" data-target="pants">바지</a></li>
                            <li><a href="#" class="list-item-link" data-target="outers">아우터</a></li>
                            <li><a href="#" class="list-item-link" data-target="skirts">스커트</a></li>
                            <li><a href="#" class="list-item-link" data-target="dresses">원피스</a></li>
                            <li><a href="#" class="list-item-link" data-target="bags">가방</a></li>
                            <li><a href="#" class="list-item-link" data-target="shoes">신발</a></li>
                            <li><a href="#" class="list-item-link" data-target="underwear">속옷/홈웨어</a></li>
                            <li><a href="#" class="list-item-link" data-target="accessories">패션잡화</a></li>
                        </ul>
                    </div>
                    <div class="category-details">
                        <%-- 각 섹션에 id 추가 --%>
                        <div id="tops" class="detail-section">
                            <div class="detail-header">
                                <h4>상의</h4>
                                <a href="#" class="view-all">전체 보기</a>
                            </div>
                            <div id="cloth-top" class="detail-items">
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
                        <div id="pants" class="detail-section">
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
                        <div id="outers" class="detail-section">
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
                            <%-- data-id 속성 추가 --%>
                            <li><a href="#" class="list-item-link" data-id="all">전체</a></li>
                            <li><a href="#" class="list-item-link" data-id="1">의류</a></li>
                            <li><a href="#" class="list-item-link" data-id="2">뷰티</a></li>
                            <li><a href="#" class="list-item-link" data-id="3">신발</a></li>
                            <li><a href="#" class="list-item-link" data-id="4">스니커즈</a></li>
                            <li><a href="#" class="list-item-link" data-id="5">가방</a></li>
                            <li><a href="#" class="list-item-link" data-id="6">패션소품</a></li>
                            <li><a href="#" class="list-item-link" data-id="7">속옷/홈웨어</a></li>
                            <li><a href="#" class="list-item-link" data-id="8">스포츠/레저</a></li>
                            <li><a href="#" class="list-item-link" data-id="9">디지털/라이프</a></li>
                            <li><a href="#" class="list-item-link" data-id="10">키즈</a></li>
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
                            <ul class="brand-item-list" id="brandItemList">
                                <%-- 여기에 나머지 브랜드 목록이 JSTL/데이터로 채워져야 합니다. --%>
<%--                                <li>--%>
<%--                                    <a href="#">--%>
<%--                                        <div class="brand-info">--%>
<%--                                            <img src="https://image.musinsa.com/images/brand/logo/MUSINS_STANDARD.png" alt="무신사 스탠다드 로고">--%>
<%--                                            <div class="text-info">--%>
<%--                                                <p class="kor-name">무신사 스탠다드<br><span class="eng-name">MUSINSA STANDARD</span></p>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </a>--%>
<%--                                </li>--%>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>