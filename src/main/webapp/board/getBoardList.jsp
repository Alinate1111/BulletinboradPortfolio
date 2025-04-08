<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getBoardList</title>
<link rel="stylesheet" href="../css/board/getBoardList.css">
<script src="../js/board/getBoardList.js"></script>
</head>
<body>
<div id="container">
	<h2><a href="getBoardList.do">쿠킹 세상</a></h2>
	<div class="box_top">
		<div class="box_left">
			<a href="../board/insertBoardForm.do" class="a_insert">글등록</a>
		</div>
		<div class="box_right">
			<a href="../member/selectMemberOne.do" title="회원정보확인" class="a_id">${loginId }</a>님&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="../member/logoutMember.do" class="a_logout">로그아웃</a>
		</div>
	</div>
	<div class="box_2">
		<div class="box_left">
			총 <b>${paging.cnt }</b>건 (<b>${paging.currentNum }/<b>${paging.totalPage }페이지)
		</div>
		<%-- 검색 기능 --%>
		<form action="searchBoardPro.do" method="post" name="searchForm">
			<div class="box_right">
				<select name="searchCondition" id="searchCondition">
					<option value="subject">제목</option>
					<option value="content">내용</option>
					<option value="sandc">제목+내용</option>
				</select>
				<input type="text" name="searchKeyword" id="searchKeyword" placeholder="내용을 입력하세요.">
				<input type="button" name="btnSearch" id="btnSearch" value="검색">
			</div>
		</form>
	</div>
	<div class="clear"></div>
	<table>
		<tr>
			<th width="8%">글순서</th>
			<th width="10%">작성자</th>
			<th width="53%">글제목</th>
			<th width="13%">등록일</th>
			<th width="8%">조회수</th>
			<th width="8%">추천수</th>
		</tr>
		<c:if test="${boardList == null || boardList.size() == 0 }">
			<tr><td colspan="6" class="row_zero">게시글이 없습니다.</td></tr>
		</c:if>
		<c:if test="${boardList != null && boardList.size() > 0 }">
			<c:set var="num" value="${number + 1 }" />
			<c:forEach var="board" items="${boardList }">
			<tr>	
				<td class="center">${num = num - 1 }</td>
				<td class="center">${board.writer }</td>
				<td class="left">
					<%-- 추천 표시(추천이 10개 이상) --%>
					<c:if test="${board.recommcount >= 10 }">
						<img src="../icons/recommand.PNG" width="25">
					</c:if>
					<%-- 댓글 표시(순서, 단계) --%>
					<c:forEach begin="1" end="${board.re_level }" step="1">
						<img src="../icons/reply.png" width="25">
					</c:forEach>
					<%-- 로그인한 회원과 글작성자가 같다면 -> 글수정이 가능 --%>
					<c:if test="${loginId == board.writer }">
						<a href="updateBoardForm.do?num=${board.num }&pageNum=${pageNum }">${board.subject }</a>
					</c:if>
					<c:if test="${loginId != board.writer }">
						<a href="getBoard.do?num=${board.num }&pageNum=${pageNum }">${board.subject }</a>
					</c:if>
				</td>
				<td class="center">${fn:substring(board.reg_date, 0, 10) }</td>
				<td class="center">${board.readcount }</td>
				<td class="center">${board.recommcount }</td>
			</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="paging">
	<c:if test="${paging.cnt > 0 }">
		<%-- 처음, 이전 페이징 블럭 출력 --%>
		<c:if test="${paging.startPage > 10 }">
			<a href='getBoardList.do?pageNum=1'><img src='../icons/leftLastPage.PNG' class='a_img a_start'></a>
			<a href='getBoardList.do?pageNum=${paging.startPage-paging.blockPage }'><img src='../icons/nextToPage.PNG' class='a_img a_prev'></a>
		</c:if>
		
		<%-- 페이징 블럭 출력 --%>
		<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }" step="1">
			<c:if test="${paging.currentNum == i }">
				<a href='getBoardList.do?pageNum=${i }'><div class='p_box a_box'>${i }</div></a>
			</c:if>
			<c:if test="${paging.currentNum != i }">
				<a href='getBoardList.do?pageNum=${i }'><div class='p_box'>${i }</div></a>
			</c:if>
		</c:forEach>
		
		<%-- 마지막, 다음 페이징 블럭 출력 --%>
		<c:if test="${paging.endPage < paging.totalPage }">
			<a href='getBoardList.do?pageNum=${paging.startPage+paging.blockPage }'><img src='../icons/nextToPage.PNG' class='a_img a_next'></a>
			<a href='getBoardList.do?pageNum=${paging.totalPage }'><img src='../icons/rightLastPage.PNG' class='a_img a_end'></a>
		</c:if>
	</c:if>
	</div>
</div>
</body>
</html>