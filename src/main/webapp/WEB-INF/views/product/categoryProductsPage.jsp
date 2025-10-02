<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8"/>
    <title>카테고리 상품 목록</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/header.css'/>">
    <!-- 검색 화면과 동일 톤 유지 -->
    <link rel="stylesheet" href="<c:url value='/resources/css/categoryProductsPage.css'/>">
</head>
<body>
<%@ include file="../main/header.jsp" %>

<main class="container">
    <section class="section">

        <!-- 검색 화면의 headline 스타일 재사용 -->
        <div class="headline">
            "<strong id="categoryTitle"></strong>"
            결과 <span class="count"><fmt:formatNumber value="${fn:length(products)}" pattern="#,###"/></span>개
        </div>

        <c:choose>
            <c:when test="${empty products}">
                <div class="empty">검색 결과가 없습니다.</div>
            </c:when>
            <c:otherwise>
                <div class="search-grid">
                    <c:forEach var="p" items="${products}">
                        <a class="product-card" href="<c:url value='/products/${p.productId}'/>">
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

                            <!-- 검색 화면 구조와 동일: 브랜드/이름/가격/좋아요 -->
                            <div class="product-brand">
                                <c:out value="${p.brandName}"/>
                            </div>
                            <div class="product-name"><c:out value='${p.productName}'/></div>

                            <div class="product-price">
                                <span class="current-price">
                                    <fmt:formatNumber value='${p.price}' pattern='#,###'/>원
                                </span>
                                <c:if test='${p.productLikes != null}'>
                                    <span class="likes">♥ <fmt:formatNumber value='${p.productLikes}'
                                                                            pattern='#,###'/></span>
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
        const name = sessionStorage.getItem('categoryName');
        if (name) {
            // 간단 XSS 방지
            const safe = document.createTextNode(name);
            const target = document.getElementById('categoryTitle');
            target.textContent = '';
            target.appendChild(safe);
        }
    });
</script>
</body>
</html>