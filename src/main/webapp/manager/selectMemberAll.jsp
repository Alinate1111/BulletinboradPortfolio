<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.* , vo.*, dao.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectMemberAll</title>
<link rel="stylesheet" href="../css/manager/selectMemberAll.css">
<script src="../js/manager/selectMemberAll.js"></script>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
// 세션 획득(관리자만 사용가능, 관리자의 아이디는 admin)
String managerId = (String)session.getAttribute("managerId");

// 세션이 없다면 회원가입폼으로 이동
if(managerId == null || managerId.equals("")) {
	response.sendRedirect("loginManagerForm.jsp");
} else {
	MemberDAO memberDAO = MemberDAO.getInstance();
	List<Member> memberList = memberDAO.getMemberList();
%>
<div id="container">
	<h2>회원 전체 목록</h2>
	<div class="box">
		<a href="logoutManager.jsp">관리자 로그아웃</a>
	</div>
	<table>
		<tr>
			<th width="3%">NO</th>
			<th width="6%">아이디</th>
			<th width="6%">비밀번호</th>
			<th width="5%">회원명</th>
			<th width="6%">별명</th>
			<th width="3%">나이</th>
			<th width="7%">생년월일</th>
			<th width="6%">직업</th>
			<th width="12%">이메일</th>
			<th width="9%">휴대폰</th>
			<th width="25%">주소</th>
			<th width="7%">가입일</th>
			<th width="5%">삭제</th>
		</tr>
		<%
		int i = 1;
		for(Member m : memberList) { %>
		<tr>
			<td><%=i++ %></td>
			<td><%=m.getId() %></td>
			<td><%=m.getPwd() %></td>
			<td><%=m.getUsername() %></td>
			<td><%=m.getNickname() %></td>
			<td><%=m.getAge() %></td>
			<td><%=m.getBirthday().substring(0, 10) %></td>
			<td><%=m.getJob() %></td>
			<td><%=m.getEmail() %></td>
			<td><%=m.getPhone() %></td>
			<td><%=m.getAddress() %></td>
			<td><%=m.getReg_date() %></td>
			<td><button>삭제</button></td>
		</tr>
		<%} %>
	</table>
	<div class="btns">
		<input type="button" id="btnBack" value="폼으로 이동">
		<input type="button" id="btnRemoveAll" value="전체 회원 삭제">
	</div>
</div>
<%} %>
</body>
</html>