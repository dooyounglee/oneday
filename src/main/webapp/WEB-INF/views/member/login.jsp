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
						<h1>Login</h1>
						<span class="subheading">로그인</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	
로그인(성공하면 메인으로,실패하면 다시 여기로)(session.setAttribute("mem"))<br>
<form action="login" method="post" autocomplete="off">
	이메일:<input name="email" /><br>
	비번:<input name="pass" /><br>
	<input type=submit value="로그인" />
</form>
<br>
<button onclick="findpass()">비번 까먹었나요?</button>
<script>
function findpass(){
	var email=prompt("이메일을 입력하세요.")
	if(email!=null || email==''){
		$.ajax({
			url:'findpass',
			method:'POST',
			async:false,
			data:{
				email:email,
			},
			success:function(data){
				if(data=='success'){
					alert("입력하신 이메일로 임시비밀번호를 보내드렸습니다. 수정부탁^^")
				}else if(data=='fail'){
					alert("이메일을 확인하세요.");
				}
			}
		})
	}
	
}
</script>



	<c:forEach var="m" items="${mlist }">
		${m }<br>
	</c:forEach>
	<br>
	<c:forEach var="h" items="${hlist }">
		${h }<br>
	</c:forEach>
	<br>
	<c:forEach var="l" items="${list }">
		${l }<br>
	</c:forEach>
</body>
</html>
