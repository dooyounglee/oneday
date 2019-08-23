<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${mem eq null }">
	<script>
		alert("로그인해")
		location.href="login"
	</script>
</c:if>
mypage<br>
${mem }<br>
<a href="update">수정</a> | <button onclick="leave()">탈퇴</button>
<script>
function leave(){
	if(confirm("정말로?")){
		location.href="leave?m_no=${mem.m_no}"
	}
}
</script>
</body>
</html>