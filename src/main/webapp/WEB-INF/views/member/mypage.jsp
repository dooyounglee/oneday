<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function leave(){
	if(confirm("정말로?")){
		location.href="leave?m_no=${mem.m_no}"
	}
}
</script>
</head>
<body>
<c:if test="${mem eq null }">
	<script>
		alert("로그인해")
		location.href="login"
	</script>
</c:if>

	<!-- Page Header -->
	<header class="masthead"
		style="background-image: url('/resources/startbootstrap-clean-blog-gh-pages/img/home-bg.jpg')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="site-heading">
						<h1>My Page</h1>
						<span class="subheading">마이페이지</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	
mypage<br>
${mem }<br>
<a href="update">수정</a> | <button onclick="leave()">탈퇴</button><br>
<c:forEach var="c" items="${classlist }">
	${c }<br>
</c:forEach>
<c:forEach var="b" items="${books }">
	${b }<button onclick="location.href='/book/cancel/${b.b_no }'">예약취소</button><br>
</c:forEach>
</body>
</html>
