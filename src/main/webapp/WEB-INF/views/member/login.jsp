<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<c:if test="${error !=null }">
	<script>
		alert("${error}")
	</script>
</c:if>
로그인(성공하면 메인으로,실패하면 다시 여기로)(session.setAttribute("mem"))<br>
<form action="login" method="post" autocomplete="off">
	이메일:<input name="email" /><br>
	비번:<input name="pass" /><br>
	<input type=submit value="로그인" />
	<br>
	<c:forEach var="m" items="${mlist }">
		${m }<br>
	</c:forEach>
	<br>
	<c:forEach var="h" items="${hlist }">
		${h }<br>
	</c:forEach>
	<br>
	<c:forEach var="l" items="${list }">
		${l }<br>
	</c:forEach>
</form>
</body>
</html>