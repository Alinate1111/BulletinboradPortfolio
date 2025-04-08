<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateBoardForm</title>
<link rel="stylesheet" href="../css/board/updateBoardForm.css">
<script src="../js/board/updateBoardForm.js"></script>
</head>
<body>
<div id="container">
	<h2>글수정</h2>
	<div class="box">
		<a href="../member/logoutMember.do">로그아웃</a>
	</div>
	<form action="updateBoardPro.do" method="post" name="updateForm">
		<input type="hidden" name="pageNum" value="${pageNum }">
		<input type="hidden" name="ref" value="${board.ref }">
		<input type="hidden" name="re_step" value="${board.re_step }">
		<input type="hidden" name="re_level" value="${board.re_level }">
		<table>
			<tr>
				<th>글번호</th>
				<td><input type="text" name="num" id="num" value="${board.num }" readonly></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" id="writer" value="${board.writer }" readonly></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="subject" id="subject" value="${board.subject }"></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td>&nbsp;<textarea name="content" id="content" rows="25" cols="67">${board.getContent() }</textarea></td>
			</tr>
			<tr>
				<th>등록일</th>
				<td>${fn:substring(board.reg_date, 0, 10) }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${board.readcount }</td>
			</tr>
		</table>
		<div class="btns">
			<input type="button" id="btnUpdate" value="글수정">
			<input type="button" id="btnDelete" value="글삭제">
			<input type="button" id="btnReply" value="댓 글">
			<input type="button" id="btnBoardList" value="게시판 목록">
		</div>
	</form>
</div>
</body>
</html>