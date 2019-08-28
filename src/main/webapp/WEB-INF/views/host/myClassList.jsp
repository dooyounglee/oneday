<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
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
						<h1>My Class</h1>
						<span class="subheading">나의 클래스</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	
	<h3>내 클래스 목록</h3>
	<div>
		<table border=1>
			<thead>
				<tr>
					<td>번호</td>
					<td>클래스명</td>
					<td>가격</td>
					<td>클래스날짜</td>
					<!-- <td>현재상태</td> -->
				</tr>
			</thead>
			
			<c:forEach items="${list}" var="list">
				<tr>
					<td><c:out value="${list.class_no }"/></td>

					<td><a href="/class/classInfo?cno=${list.class_no }&mno=${mno}">
						<c:out value="${list.title }"/></a>
					</td>

					<td><c:out value="${list.price }"/></td>
					<td><c:out value="${list.class_day }"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>
