<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8"/>
    <title>장바구니</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/header.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/css/cart.css'/>">
    <script src="" defer></script>
</head>
<body>
<%@ include file="../main/header.jsp" %>

<div class="container" data-user-id="${requestScope.userId}">
    <div class="page-title">장바구니 <span class="summary-sub" id="cart-count">전체 0</span></div>

    <%@ include file="../fragments/cart/_toolbar.jspf" %>

    <div class="grid">
        <div>
            <%@ include file="../fragments/cart/_brandList.jspf" %>
        </div>
        <aside class="right">
            <div class="sticky">
                <%@ include file="../fragments/cart/_summary.jspf" %>
            </div>
        </aside>
    </div>
</div>

<%-- 옵션 모달을 쓸 계획이면 include 유지, 아니라면 이 줄만 주석처리/삭제 --%>
<%@ include file="../fragments/cart/_optionModal.jspf" %>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<script>
    // 컨텍스트 경로/유저ID를 JS로 안전하게 전달
    window.__CTX__ = {
        base: '<c:out value="${pageContext.request.contextPath}"/>',
        userId: '<c:out value="${requestScope.userId}"/>'
    };
</script>
<script defer src="<c:url value='/resources/js/cart.js'/>"></script>
</body>
</html>
