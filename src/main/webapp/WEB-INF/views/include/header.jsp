<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/">메인</a> |
	<c:choose>
		<c:when test="${mem != null }">
			<a href="/member/mypage">mypage</a> |
			<a href="/member/logout">로그아웃</a> |
			<c:if test="${mem.host eq 'Y' }">
				<a href="/host/host">호스트 전용 페이지</a> |
			</c:if>
			<c:if test="${mem.host eq 'N' }">
				<a href="/member/joinH">호스트회원가입</a> |
			</c:if>
		</c:when>
		<c:otherwise>
			<a href="/member/login">로그인(호스트포함)</a> |
			<a href="/member/join">회원가입</a> |
			<a href="/member/joinH">호스트회원가입</a> |
		</c:otherwise>
	</c:choose>
<br>
${mem }
<hr>
<br>
</body>
</html>