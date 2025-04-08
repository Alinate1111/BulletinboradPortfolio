<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getBoard</title>
<link rel="stylesheet" href="../css/board/getBoard.css">
<script src="../js/board/getBoard.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
<div id="container">
	<h2>글내용</h2>
	<div class="box">
		<a href="logoutMember.do">로그아웃</a>
	</div>
	<form action="" method="post" name="boardForm">
		<input type="hidden" name="pageNum" value="${pageNum }">
		<input type="hidden" name="num" value="${board.num }">
		<input type="hidden" name="ref" value="${board.ref }">
		<input type="hidden" name="re_step" value="${board.re_step }">
		<input type="hidden" name="re_level" value="${board.re_level }">
		<table>
			<tr>
				<th>글번호</th>
				<td>${board.num }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.writer }</td>
			</tr>
			<tr>
				<th>글제목</th>
				<td>${board.subject }</td>
			</tr>
			<tr>
				<th>글내용</th>
				<td>${board.content }</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td>${board.reg_date }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${board.readcount }</td>
			</tr>
			<tr>
				<th>추천수</th>
				<td>${board.recommcount }</td>
			</tr>
		</table>
		<div class="btns">
			<input type="button" id="btnReply" value="댓 글">
			<input type="button" id="btnBoardList" value="게시판 목록">
			<input type="image" src="../icons/recommandation.PNG" id="btnRecomm" value="${board.num }" title="추천해주세요!">
		</div>
	</form>
</div>
</body>
</html>