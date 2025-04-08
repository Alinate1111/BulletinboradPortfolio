<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertMemberForm</title>
<link rel="stylesheet" href="../css/member/insertMemberForm.css">
<script src="../js/member/insertMemberForm.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
<%-- chk: 1(중복 아이디가 있음, 추가하는 아이디는 사용불가), 0(중복 아이디가 없음, 추가하는 아이디는 사용가능) --%>
<div id="container">
	<h2>회원가입 폼</h2>
	<form action="../member/insertMemberPro.do" method="post" name="insertForm" id="insertForm">
		<div class="box">
			<label for="id">아이디</label>
			<input type="text" name="id" id="id" value="${chkId }" autofocus>
			<input type="button" id="btnIdChk" value="ID 중복 확인"><br>
			<label></label>
			<c:if test="${chkNum == null }">
				<span id="s_id_chk" class="chk_2">아이디 중복 확인을 하세요.</span>
			</c:if>
			<c:if test="${chkNum == '1' }">
				<span id="s_id_chk" class="chk_1">이미 사용중인 아이디입니다. 다시 입력해 주세요</span>
			</c:if>
			<c:if test="${chkNum == '0' }">
				<span id="s_id_chk" class="chk_0">사용가능한 아이디입니다.</span>
			</c:if>
		</div>
		<div class="box">
			<label for="pwd">비밀번호</label>
			<input type="password" name="pwd" id="pwd">
		</div>
		<div class="box">
			<label for="pwd2">비밀번호 확인</label>
			<input type="password" name="pwd2" id="pwd2"><br>
			<label></label>
			<span id="s_pwd_chk"></span>
		</div>
		<div class="box">
			<label for="username">회원명</label>
			<input type="text" name="username" id="username">
		</div>
		<div class="box">
			<label for="nickname">별명</label>
			<input type="text" name="nickname" id="nickname">
		</div>
		<div class="box">
			<label for="age">나이</label>
			<input type="number" name="age" id="age">
		</div>
		<div class="box">
			<label for="birthday">생년월일</label>
			<input type="date" name="birthday" id="birthday">
		</div>
		<div class="box">
			<label for="job">직업</label>
			<input type="text" name="job" id="job">
		</div>
		<div class="box">
			<label for="email">이메일</label>
			<input type="email" name="email" id="email"><br>
			<label></label>
			<span id="s_email_chk"></span>
		</div>
		<div class="box">
			<label for="phone">휴대폰번호</label>
			<input type="text" name="phone" id="phone"><br>
			<label></label>
			<span id="s_phone_chk"></span>
		</div>
		<div class="box">
			<label for="address2">주소</label>
			<input type="text" name="address1" id="address1">
			<input type="button" id="btnAddress" value="주소 찾기"><br>
			<label></label>
			<input type="text" name="address2" id="address2" placeholder="상세주소를 입력하시오.">
		</div>
		<div class="box">
			<label for="reg_date">가입일</label>
			<input type="date" name="reg_date" id="reg_date">
		</div>
		<div class="box btns">
			<input type="button" id="btnOK" value="가 입">
			<input type="reset" value="취 소">
			<input type="button" id="btnLoginForm" value="로그인폼">
		</div>
	</form>
</div>
</body>
</html>