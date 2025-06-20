<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>러프도우 리뷰</title>
    <link rel="stylesheet" href="/css/storereview.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div id="wrapper">
    <header>
        <div class="header-container">
            <img src="/img/storeohgoodfood_logo.png" alt="Logo Image">
            <div class="icon-container">
                <img src="/img/storealarm_active.png" alt="알람" class="icon">
                <img src="/img/storelogout.png" alt="로그아웃" class="icon">
            </div>
        </div>
    </header>
    <main>
        <div class="review-section">
            <div class="review-title">러프도우</div>
            <div class="review-subtitle">| 구매자들의 오굿백 리뷰를 확인해보세요~</div>
            <div class="review-list">
                <c:forEach var="vo" items="${reviews}">
                    <div class="review-card">
                    	<c:choose>
                    		<c:when test="${not empty vo.review_img}">
                    			<img src="${pageContext.request.contextPath}/upload/${vo.review_img}" alt="${vo.user_id}" class="review-img">
                    		</c:when>
                    		<c:otherwise>
                    			 <img src="${pageContext.request.contextPath}/upload/storebread2.png" alt="${vo.user_id}" class="review-img">
                    		</c:otherwise>
                    	</c:choose>
                        
                        <div class="review-content">
                            <div class="review-header">
                                <span class="review-name">${vo.user_id}</span>
                                <span class="review-date">
                                	<fmt:formatDate value="${vo.writed_at}" pattern="yyyy.MM.dd" />
                                </span>
                            </div>
                            <div class="review-text">
                                ${vo.review_content}
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </main>

    <footer>
        <div class="footer-container">
            <div class="menu-container">
                <div class="menu-item">
                	<a href="/store/home">
                		<img src="/img/storehome.png" data-name="home" alt="홈" class="menu-icon">
                	</a>
                </div>
                <div class="menu-item">
                    <a href="/store/review">
                        <img src="/img/storereview.png" data-name="review" alt="리뷰" class="menu-icon">
                    </a>
                </div>
                <div class="menu-item">
                	<a href="/store/order">
                		<img src="/img/storeorder.png" data-name="order" alt="주문" class="menu-icon">
                	</a>
                </div>
                <div class="menu-item">
                	<a href="/store/mypage">
                		<img src="/img/storemypage.png" data-name="mypage" alt="마이페이지" class="menu-icon">
                	</a>
                </div>
            </div>
        </div>
    </footer>
</div>
<script>
$(function() {
    $('.menu-item').click(function() {
        $('.menu-item').removeClass('active');
        $('.menu-item img').each(function() {
            const name = $(this).data('name');
            $(this).attr('src', `/img/store${name}.png`);
        });
        $(this).addClass('active');
        const img = $(this).find('img');
        const name = img.data('name');
        img.attr('src', `/img/store${name}_active.png`);
    });
});
</script>
</body>
</html>