<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginMemberForm</title>
<link rel="stylesheet" href="../css/member/loginMemberForm.css">
<script src="../js/member/loginMemberForm.js"></script>
</head>
<body>
<div id="container">
	<h2>쿠킹 세상</h2>
	<p>여러분들의 레시피를 알려주세요</p>
	
	<form action="../member/loginMember.do" method="post" name="loginForm" id="loginForm">
		<div class="box">
			<label for="id">아이디</label>
			<input type="text" name="id" id="id" autofocus>
		</div>
		<div class="box">
			<label for="pwd">비밀번호</label>
			<input type="password" name="pwd" id="pwd">
		</div>
		<div class="box btns">
			<input type="button" id="btnLogin" value="로 그 인">
		</div>
		<div class="box cookie">
			<input type="checkbox" name="chk_id_save" id="chk_id_save">
			<label for="chk_id_save">아이디 저장</label>
			<a href="insertMemberForm.jsp" id="a_join">회원가입</a>
		</div>
	</form>
</div>
</body>
</html>