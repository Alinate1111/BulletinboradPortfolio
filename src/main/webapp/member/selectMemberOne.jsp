<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectMemberOne</title>
<link rel="stylesheet" href="../css/member/selectMemberOne.css">
<script src="../js/member/selectMemberOne.js"></script>
</head>
<body>
<div id="container">	
	<h2>회원 정보 확인</h2>
	<div class="box">
		<a href="logoutMember.do">로그아웃</a>
	</div>
	<table>
		<tr>
			<th>아이디</th>
			<td>${member.id }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${member.pwd }</td>
		</tr>
		<tr>
			<th>사용자명</th>
			<td>${member.username }</td>
		</tr>
		<tr>
			<th>별명</th>
			<td>${member.nickname }</td>
		</tr>
		<tr>
			<th>나이</th>
			<td>${member.age }</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td>${fn:substring(member.birthday, 0, 10) }</td>
		</tr>
		<tr>
			<th>직업</th>
			<td>${member.job }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${member.email }</td>
		</tr>
		<tr>
			<th>휴대폰 번호</th>
			<td>${member.phone }</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${member.address }</td>
		</tr>
		<tr>
			<th>가입일</th>
			<td>${fn:substring(member.reg_date, 0, 10) }</td>
		</tr>
	</table>
	<div class="btns">
		<input type="button" id="btnUpdate" value="수 정">
		<input type="button" id="btnDelete" value="회원 탈퇴">
		<input type="button" id="btnBoardList" value="게시판 이동">
	</div>
</div>
</body>
</html>