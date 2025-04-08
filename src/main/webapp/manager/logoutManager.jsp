<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logoutManger</title>
</head>
<body>
<%
// 세션 삭제, 이동
session.removeAttribute("managerId");
response.sendRedirect("loginManagerForm.jsp");
%>
</body>
</html>