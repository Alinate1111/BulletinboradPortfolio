<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertBoardForm</title>
<link rel="stylesheet" href="../css/board/insertBoardForm.css">
<script src="../js/board/insertBoardForm.js"></script>
</head>
<body>
<div id="container">
	<h2>글추가</h2>
	<div class="box">
		<a href="../member/logoutMember.do">로그아웃</a>
	</div>
	<form action="insertBoardPro.do" method="post" name="insertForm">
		<table>
			<tr>
				<th>글번호</th>
				<td>&nbsp;${result+1 }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" id="writer" value="${loginId }" readonly></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="subject" id="subject"></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td>&nbsp;<textarea name="content" id="content" rows="25" cols="68"></textarea></td>
			</tr>
		</table>
		<div class="btns">
			<input type="button" id="btnInsert" value="글등록">
			<input type="reset" value="취소">
			<input type="button" id="btnBoardList" value="게시판 목록">
		</div>
	</form>
</div>
</body>
</html>