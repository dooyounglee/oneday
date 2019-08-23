<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
수정페이지<br>
<form action="update" method="post" autocomplete="off">
	이메일:<input name="email" value="${mem.email }"/><br>
	비번:<input name="pass" value="${mem.pass }" /><br>
	폰:<input name="phone" value="${mem.phone }" /><br>
	<input type=submit value="아직 수정 누르지 마" />
</form>
</body>
</html>