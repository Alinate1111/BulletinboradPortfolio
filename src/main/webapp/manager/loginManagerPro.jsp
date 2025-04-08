<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.*, vo.*, dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginManagerPro</title>
</head>
<body>
<%
String m_id = request.getParameter("m_id");
String m_pwd = request.getParameter("m_pwd");

ManagerDAO managerDAO = ManagerDAO.getInstance();
int result = managerDAO.loginManager(m_id, m_pwd);

if(result == 1) {
	session.setAttribute("managerId", m_id);
	JSFunction.alertLocation(out, "관리자로 로그인하였습니다.", "selectMemberAll.jsp");
} else {
	JSFunction.alertBack(out, "관리자 로그인에 실패하였습니다.");
}
%>
</body>
</html>