<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<c:if test="${message !=null }">
	<script>
		alert("${message}")
	</script>
</c:if>
	메인페이지<br>
${mem.email } 님 안녕하세요.

</body>
</html>
