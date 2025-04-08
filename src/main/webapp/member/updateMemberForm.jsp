<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateMemberForm</title>
<link rel="stylesheet" href="../css/member/updateMemberForm.css">
<script src="../js/member/updateMemberForm.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
<div id="container">
	<h2>회원 정보 수정</h2>
	<div class="box">
		<a href="logoutMember.do">로그아웃</a>
	</div>
	<form action="updateMemberPro.do" method="post" name="updateForm" id="updateForm">
	<table>
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" name="id" id="id" value="${member.id }" readonly>
				<span>아이디는 변경불가</span>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pwd" id="pwd" value="${member.pwd }" autofocus></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td>
				<input type="password" name="pwd2" id="pwd2">
				<span id="s_pwd_chk"></span>
			</td>
		</tr>
		<tr>
			<th>사용자명</th>
			<td><input type="text" name="username" id="username" value="${member.username }"></td>
		</tr>
		<tr>
			<th>별명</th>
			<td><input type="text" name="nickname" id="nickname" value="${member.nickname }"></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="text" name="age" id="age" value="${member.age }"></td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><input type="date" name="birthday" id="birthday" value="${fn:substring(member.birthday, 0, 10) }"></td>
		</tr>
		<tr>
			<th>직업</th>
			<td><input type="text" name="job" id="job" value="${member.job }"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<input type="text" name="email" id="email" value="${member.email }">
				<span id="s_email_chk"></span>
			</td>
		</tr>
		<tr>
			<th>휴대폰 번호</th>
			<td>
				<input type="text" name="phone" id="phone" value="${member.phone }">
				<span id="s_phone_chk"></span>
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<input type="text" name="address1" id="address1" value="${member.address }">
				<input type="button" id="btnAddress" value="주소 찾기"><br>
				<input type="text" name="address2" id="address2" placeholder="상세주소를 입력하시오.">
			</td>
		</tr>
		<tr>
			<th>가입일</th>
			<td>${fn:substring(member.reg_date, 0, 10) }</td>
		</tr>
	</table>
	<div class="btns">
		<input type="button" id="btnOK" value="수 정">
		<input type="button" id="btnBoardList" value="게시판 보기">
	</div>
	</form>
</div>
</body>
</html>