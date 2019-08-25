<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
						<h1>OneDay Class</h1>
						<span class="subheading">단 하루의 투자</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	
	메인페이지<br>
	<c:if test="${mem != null }">
		${mem.email } 님 안녕하세요.
	</c:if>

</body>
</html>
