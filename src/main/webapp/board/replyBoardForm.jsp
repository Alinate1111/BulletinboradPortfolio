<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>replyBoardForm</title>
<link rel="stylesheet" href="../css/board/replyBoardForm.css">
<script src="../js/board/replyBoardForm.js"></script>
</head>
<body>
<div id="container">
	<h2>댓글 추가</h2>
	<div class="box">
		<a href="../member/logoutMember.do">로그아웃</a>
	</div>
	<form action="replyBoardPro.do" method="post" name="replyForm">
		<input type="hidden" name="pageNum" value="${pageNum }">
		<input type="hidden" name="num" value="${num }">
		<input type="hidden" name="ref" value="${ref }">
		<input type="hidden" name="re_step" value="${re_step }">
		<input type="hidden" name="re_level" value="${re_level }">
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
			<input type="button" id="btnReply" value="댓글 등록">
			<input type="reset" value="취소">
			<input type="button" id="btnBoardList" value="게시판 목록">
		</div>
	</form>
</div>
</body>
</html>