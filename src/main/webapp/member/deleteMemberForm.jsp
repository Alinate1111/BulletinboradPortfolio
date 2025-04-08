<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteMemberForm</title>
<link rel="stylesheet" href="../css/member/deleteMemberForm.css">
<script src="../js/member/deleteMemberForm.js"></script>
</head>
<body>
<div id="container">
	<h2>회원탈퇴</h2>
	<p>회원탈퇴를 하면 1주일동안 재가입이 불가합니다.</p>
	<div class="box">
		<a href="logoutMember.do">로그아웃</a>
	</div>
	<form action="deleteMemberPro.do" method="post" name="deleteForm" id="deleteForm">
		<div class=box2>
			<label for="id">아이디</label>
			<input type="text" id="id" name="id" value="${loginId }" readonly>
		</div>
		<div class=box2>
			<label for="pwd">비밀번호</label>
			<input type="password" id="pwd" name="pwd">
		</div>
		<div class="box2 btns">
			<input type="button" id="btnOK" value="회원 탈퇴">
			<input type="button" id="btnBoardList" value="게시판 보기">
		</div>
	</form>
</div>
</body>
</html>