<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
	<!-- Page Header -->
	<header class="masthead"
		style="background-image: url('/resources/startbootstrap-clean-blog-gh-pages/img/home-bg.jpg')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="site-heading">
						<h1>Join as Host</h1>
						<span class="subheading">호스트 가입</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	
호스트 회원가입<br>
<form action="joinH" method="post" autocomplete="off">
	이메일:<input name="email" value="${mem.email }"/><br>
	비번:<input name="pass"  value="${mem.pass }"/><br>
	폰:<input name="phone" /><br>
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
