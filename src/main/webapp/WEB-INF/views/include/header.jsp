<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="/resources/startbootstrap-clean-blog-gh-pages/vendor/jquery/jquery.min.js"></script>

  <!-- Bootstrap core CSS -->
  <link href="/resources/startbootstrap-clean-blog-gh-pages/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="/resources/startbootstrap-clean-blog-gh-pages/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="/resources/startbootstrap-clean-blog-gh-pages/css/clean-blog.min.css" rel="stylesheet">
  
  <!-- Bootstrap core JavaScript -->
  <script src="/resources/startbootstrap-clean-blog-gh-pages/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/startbootstrap-clean-blog-gh-pages/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="/resources/startbootstrap-clean-blog-gh-pages/js/clean-blog.min.js"></script>
</head>
<body>

<c:if test="${message !=null }">
	<script>
		alert("${message}")
	</script>
</c:if>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="/">OneDay Class</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="/class/classList">Class List</a>
					</li>
					<li class="nav-item"> | </li>
					<c:choose>
						<c:when test="${mem != null }">
							<c:if test="${mem.host eq 'Y' }">
								<li class="nav-item"><a class="nav-link" href="/class/addClass">Add Class</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="/host/myClass?mno=${mem.m_no }">My Classes</a>
								</li>
								<%-- <li class="nav-item"><a class="nav-link" href="/host/host?mno=${mem.m_no}">Host Page</a>
								</li> --%>
								<li class="nav-item"> | </li>
							</c:if>
							<li class="nav-item"><a class="nav-link"
								href="/member/mypage">MyPage</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/member/logout">Logout</a></li>
							<c:if test="${mem.host eq 'N' }">
								<li class="nav-item"><a class="nav-link"
									href="/member/joinH">Join as Host</a></li>
							</c:if>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link"
								href="/member/login">Login</a></li>
							<li class="nav-item"><a class="nav-link" href="/member/join">Join</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="/member/joinH">Join as Host</a>
							</li>
						</c:otherwise>
					</c:choose>

				</ul>
			</div>
		</div>
		<div style="position:absolute;top:0px;left:0px;">${mem }</div>
	</nav>


	

</body>
</html>
