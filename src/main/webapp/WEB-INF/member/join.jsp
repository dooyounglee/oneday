<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
일반 회원가입<br>
<form action="join" method="post" autocomplete="off">
	이메일:<input name="email" /><br>
	비번:<input name="pass" /><br>
	<input type=submit value="가입" />
	<br>
	<c:forEach var="m" items="${mlist }">
		${m }<br>
	</c:forEach>
	<br>
	<c:forEach var="h" items="${hlist }">
		${h }<br>
	</c:forEach>
</form>
</body>
</html>