<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=78d21eb8c5c03e01cb0cf78534c01fca&libraries=services"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/classInfo.css">
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
						<h1>classInfo</h1>
						<span class="subheading">클래스 정보</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	

	
	<a href="/">메인으로</a>
	<hr>
	
	<div id="wrapper">
		<div id="left_wrapper">
			
			<div>
				<div>
					<label>타이틀이미지 : </label>
						${c.title_img}
				</div>
				<div>
					<label>제목 : </label>
					${c.title}
				</div>
				<div>
					<label>가격 : </label>
					${c.price}
				</div>
				<div>
					<label>내용 : </label>
					${c.content}
				</div>
				<div>
					<div>
						<label>클래스 위치 : </label> 
						<br>
						${c.address} <br>
						${c.address_detail }
					</div>
					<div id="map" style="width:50%;height:350px;"></div>
				</div>
				<div>
					<label>클래스 날짜 : </label>
					${c.class_day}
				</div>
				<div>
					<label>클래스 시간 : </label>
					${c.class_time}
				</div>
				<div>
					<label>참가 가능 인원 : </label>
					${c.maxperson} <c:out value="명"/>
				</div>
				
			
			</div>
		
		</div>
	
		<!-- 오른쪽 예약공간 -->
		<div id="right_wrapper">

			<div>
				<div>참가비(1인)</div>
				<div>남은수량 <c:out value="(${c.possible })"/></div>
			</div>
			<div>
				<button onclick="location.href='/book/booking/${c.class_no}'">참여하기</button>
				<!-- mem이 참여한 상태면 버튼 바꿔야 하고,, 그걸 못누르게 하거나, 또 누르면 예약 취소 되도록 -->
			</div>
			
			<c:choose>
				<c:when test="${c.m_no eq mno}">
					<button onclick="location='/host/updateClass?cno=${c.class_no}'">수정하기</button>
				</c:when>
			</c:choose>
			
		</div>
	</div>
	




<!-- 지도api -->
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();

		// 주소로 좌표를 검색합니다
		// 넘어온 주소값 받기
		geocoder
				.addressSearch(
						'${c.address}',
						function(result, status) {

							// 정상적으로 검색이 완료됐으면 
							if (status === kakao.maps.services.Status.OK) {

								var coords = new kakao.maps.LatLng(result[0].y,
										result[0].x);

								// 결과값으로 받은 위치를 마커로 표시합니다
								var marker = new kakao.maps.Marker({
									map : map,
									position : coords
								});

								// 인포윈도우로 장소에 대한 설명을 표시합니다
								var infowindow = new kakao.maps.InfoWindow(
										{
											content : '<div style="width:150px;text-align:center;padding:6px 0;">클래스 장소</div>'
										});
								infowindow.open(map, marker);

								// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
								map.setCenter(coords);
							}
						});
	</script>

</body>
</html>
