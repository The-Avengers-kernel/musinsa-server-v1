<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<header class="musinsa-header">
    <div class="inner">
        <div class="header-left">
            <button type="button" id="menuBtn" class="hamburger-btn" aria-label="카테고리 메뉴 열기">
                <i class="fas fa-bars"></i>
            </button>

            <div class="logo-separator">|</div>

            <div class="logo">
                <a href="${pageContext.request.contextPath}/">MUSINSA</a>
            </div>

            <nav class="gnb">
                <ul>
                    <li><a href="#">BEAUTY</a></li>
                    <li><a href="#">PLAYER</a></li>
                    <li><a href="#">OUTLET</a></li>
                    <li><a href="#">BOUTIQUE</a></li>
                    <li><a href="#">SHOES</a></li>
                    <li><a href="#">KIDS</a></li>
                    <li><a href="#">USED</a></li>
                    <li class="separator">|</li>
                    <li><a href="#">[S]:SNAP</a></li>
                </ul>
            </nav>
        </div>

        <div class="header-right">
            <ul class="user-menu">
                <li><a href="#">오프라인스토어</a></li>
                <li class="separator">|</li>
                <li><a href="${pageContext.request.contextPath}/main/search" id="searchBtn"><i class="fas fa-search"></i>검색</a></li>
                <li class="separator">|</li>
                <li><a href="#"><i class="far fa-heart"></i>좋아요</a></li>
                <li class="separator">|</li>
                <li><a href="${pageContext.request.contextPath}/mypage"><i class="far fa-user"></i>마이</a></li>
                <li class="separator">|</li>
                <li><a href="${pageContext.request.contextPath}/cart"><i class="fas fa-shopping-cart"></i>장바구니</a></li>
                <li class="separator">|</li>
                <c:if test="${empty sessionScope.loginUser}">
                    <li class="btn-outline-dark"><a href="${pageContext.request.contextPath}/login">로그인</a></li>
                </c:if>
                <c:if test="${not empty sessionScope.loginUser}">
                    <li class="btn-outline-dark"><a href="${pageContext.request.contextPath}/logout">로그아웃</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</header>

<div id="searchOverlayContainer" data-overlay-container="recent"></div>

<script>
    window.appContextPath = window.appContextPath || '${pageContext.request.contextPath}';
    window.userIsLoggedIn = false;
    window.musinsaUserId = null;
    <c:if test="${not empty sessionScope.loginUser}">
    window.userIsLoggedIn = true;
    window.musinsaUserId = '<c:out value="${sessionScope.loginUser.userId}"/>';
    </c:if>
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/recentSearches.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/header.js"></script>
