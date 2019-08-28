<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<!-- <script src="/resources/js/class.js"></script> -->

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
						<h1>addClass</h1>
						<span class="subheading">클래스 등록</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	
	
	<form method="post" action="/class/addClass">
		<div>
			<input type="text" placeholder="제목을 입력하세요." name="title" autofocus required>
		</div>
		<div>
			<!-- <input type="file" name="title_img"> -->
		</div>
		<div>
			<!-- <textarea rows="5" class="form-control" name="content"></textarea> -->
			<textarea rows="10" cols="30" name="content" required></textarea>>
		</div>
		<div>
			가격 : <input type="text"  name="price"
				onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" placeholder="숫자만 입력가능" required>원
		</div>
		<div>
			<input type="text" id="sample4_postcode" placeholder="우편번호">
			<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
			
			<input type="text" id="sample4_roadAddress" placeholder="도로명주소" size="30" name="address" required>
			<input type="text" id="sample4_jibunAddress" placeholder="지번주소">
			<span id="guide" style="color:#999;display:none"></span>
			<br>
			<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="address_detail" required>
			<input type="text" id="sample4_extraAddress" placeholder="참고항목">
		</div>
		<div>
			클래스 날짜 : <input type="date" name="class_day" required>
		</div>
		<div>
			클래스 시간 : <input type="time" name="class_time" required>
		</div>
		<div>
			인원수 : <input type="number" size="5" value="1" min="1" name="maxperson" required>명
		</div>
		
		<br><br>
		<input type="submit" value="클래스 등록하기">
		<input type="reset" value="취소">
	</form>
	
	
	
	
	
	
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
    
    
    
    
</script>
<script>
CKEDITOR.replace("content", {
	
	filebrowserUploadUrl :"/imageUpload.do"
   // filebrowserImageUploadUrl: 'MacaronicsServlet?command=ckeditor_upload'	
});
</script>
	
	
	
	
	
</body>
</html>
