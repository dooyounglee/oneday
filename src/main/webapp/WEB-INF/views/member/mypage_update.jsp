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
		style="background-image: url('/resources/home-bg.jpg')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="site-heading">
						<h1>Update</h1>
						<span class="subheading">내정보수정</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	
수정페이지<br>
<form action="changepass" method="post" autocomplete="off">
	<input name="email" value="${mem.email }" />
	현재 비번:<input name="pass" /><br>
	바꿀 비번:<input name="newpass" /><br>
	<input type=submit value="변경" />
</form>
</body>
</html>
