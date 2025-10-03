<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8"/>
    <title>검색 화면</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/header.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/css/search.css'/>">
</head>
<body>
<%@ include file="../main/header.jsp" %>

<main class="container">
    <section class="section">

        <%--        <!-- 검색바 -->--%>
        <%--        <form class="search-header" action="<c:url value='/search'/>" method="get">--%>
        <%--            <input class="search-input" type="text" name="keyword"--%>
        <%--                   placeholder="브랜드/상품/카테고리 검색"--%>
        <%--                   value="${keyword != null ? keyword : result.searchKeyword}"/>--%>
        <%--            <button class="search-btn" type="submit">검색</button>--%>
        <%--        </form>--%>

        <!-- 키워드/결과 수 -->
        <div class="headline">
            "<strong><c:out value='${keyword != null ? keyword : result.searchKeyword}'/></strong>"
            검색 결과 <span class="count"><fmt:formatNumber value="${result.totalCount}" pattern="#,###"/></span>개
        </div>

        <!-- 정렬 옵션 -->
        <div class="sort-options">
            <button class="sort-btn" data-sort="POPULARITY">인기순</button>
            <button class="sort-btn" data-sort="PRICE_LOW">낮은 가격</button>
            <button class="sort-btn" data-sort="PRICE_HIGH">높은 가격</button>
        </div>

        <!-- 브랜드 정보(brandInfo 있을 때만 노출) -->
        <c:if test="${not empty result.brandInfo}">
            <a class="brand-box" href='<c:url value='/brands/${result.brandInfo.brandId}'/>'>
                <c:if test="${not empty result.brandInfo.brandImage}">
                    <img src="<c:out value='${result.brandInfo.brandImage}'/>"
                         alt="<c:out value='${result.brandInfo.brandNameKr}'/>">
                </c:if>
                <div>
                    <div style="font-weight:700;"><c:out value='${result.brandInfo.brandNameKr}'/></div>
                    <div class="brand-en"><c:out value='${result.brandInfo.brandNameEn}'/></div>
                </div>
                <div class="brand-count">
                    <fmt:formatNumber value="${result.brandInfo.totalCount}" pattern="#,###"/>개
                </div>
            </a>
        </c:if>

        <%-- 어떤 리스트를 쓸지 선택 --%>
        <c:choose>
            <c:when test="${not empty result.brandInfo}">
                <c:set var="productList" value="${result.brandInfo.products}"/>
            </c:when>
            <c:otherwise>
                <c:set var="productList" value="${result.products}"/>
            </c:otherwise>
        </c:choose>

        <!-- 결과 그리드 -->
        <c:choose>
            <c:when test="${empty productList}">
                <div class="empty">검색 결과가 없습니다.</div>
            </c:when>
            <c:otherwise>
                <div class="search-grid">
                    <c:forEach var="p" items="${productList}">
                        <a class="product-card" href='<c:url value='/products/${p.productId}'/>'>
                            <div class="product-image">
                                <c:choose>
                                    <c:when test="${not empty p.productImage}">
                                        <img src="<c:out value='${p.productImage}'/>"
                                             alt="<c:out value='${p.productName}'/>">
                                    </c:when>
                                    <c:otherwise>
                                        <img src="<c:url value='/resources/img/placeholder.png'/>" alt="no image">
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="product-brand">
                                <c:out value="${p.brandNameKr}"/> / <c:out value="${p.brandNameEn}"/>
                            </div>
                            <div class="product-name"><c:out value='${p.productName}'/></div>
                            <div class="product-price">
                                <span class="current-price"><fmt:formatNumber value='${p.price}'
                                                                              pattern='#,###'/>원</span>
                            </div>

                            <div class="likes-and-stars">
                                <c:if test='${p.productLikes != null}'>
                                    <span class="likes">♥ <fmt:formatNumber value='${p.productLikes}'
                                                                            pattern='#,###'/></span>
                                </c:if>
                                <c:if test='${p.ratingAverage != null}'>
                                    <span class="stars">★<fmt:formatNumber value='${p.ratingAverage}'
                                                                           pattern='0.0'/>(<fmt:formatNumber
                                            value='${p.reviewCount}'/>)</span>
                                </c:if>
                            </div>
                        </a>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>

    </section>
</main>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        // 현재 URL에서 sortBy 파라미터 읽기
        const urlParams = new URLSearchParams(window.location.search);
        const currentSort = urlParams.get('sortBy') || 'POPULARITY';

        // 현재 정렬 버튼에 active 클래스 추가
        const sortButtons = document.querySelectorAll('.sort-btn');
        sortButtons.forEach(btn => {
            if (btn.dataset.sort === currentSort) {
                btn.classList.add('active');
            }

            // 클릭 이벤트 추가
            btn.addEventListener('click', function () {
                const sortType = this.dataset.sort;

                // URL 파라미터 업데이트
                const newParams = new URLSearchParams(window.location.search);
                newParams.set('sortBy', sortType);

                // 페이지 리로드
                window.location.search = newParams.toString();
            });
        });
    });
</script>

</body>
</html>
