<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginManagerForm</title>
<link rel="stylesheet" href="../css/manager/loginManagerForm.css">
<script src="../js/manager/loginManagerForm.js"></script>
</head>
<body>
<div id="container">
	<h2>관리자 로그인폼</h2>
	<p>관리자만 로그인할 수 있습니다.</p>
	
	<form action="loginManagerPro.jsp" method="post" name="loginForm" id="loginForm">
		<div class="box">
			<label for="m_id">아이디</label>
			<input type="text" name="m_id" id="m_id" autofocus>
		</div>
		<div class="box">
			<label for="m_pwd">비밀번호</label>
			<input type="password" name="m_pwd" id="m_pwd">
		</div>
		<div class="box btns">
			<input type="button" id="btnLogin" value="로 그 인">
		</div>
	</form>
</div>
</body>
</html>