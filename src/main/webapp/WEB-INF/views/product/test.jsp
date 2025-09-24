<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Header Test</title>
<%--    헤더 CSS 파일을 불러온다--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">

    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<%--    헤더 JS 파일도 필요하다면 여기에 추가한다.--%>
    <script src="/js/header.js" defer></script>
</head>

<body>
<%-- 이 페이지의 본문에는 header.jsp 조각만 포함시킨다.--%>
<jsp:include page="/WEB-INF/views/main/header.jsp"/>
<div id="productInfo">
    <p id="productId"></p>
    <p id="productName"></p>
    <p id="productPrice"></p>
    <p id="productLikeCnt"></p>
    <p id="productDiscount"></p>
    <p id="productTotalPrice"></p>
    <p id="brandId"></p>
    <p id="brandName"></p>
    <p id="brandLikeCnt"></p>
</div>
<script>
    $(document).ready(function() {
        $.ajax({
            url: '/api/v1/products/1',
            method: 'GET',
            dataType: 'json',
            success: function(data) {
                // 결과를 문자열(JSON.stringify)로 변환
                //const result = JSON.stringify(data);
                $('#productId').text('product Id : ' + data.productId);
                $('#productName').text('Product Name : ' + data.productName);
                $('#productPrice').text('Price : ' + data.price);
                $('productLikeCnt').text('productLikeCnt : ' + data.productLikeCnt);
                $('productDiscount').text('productDiscount : ' + data.productDiscount);
                $('productTotalPrice').text('productTotalPrice : ' + data.productTotalPrice);
                $('brandId').text('brandId : ' + data.brandId);
                $('brandName').text('brandName : ' + data.brandName);
                $('brandLikeCnt').text('brandLikeCnt : ' + data.brandLikeCnt);

            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
            }
        });
    });
</script>

</body>
</html>