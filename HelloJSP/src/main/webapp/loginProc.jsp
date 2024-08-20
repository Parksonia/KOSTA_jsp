<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");
String type = request.getParameter("type");

if (id.equals("java") && password.equals("1234")) {
	session.setAttribute("id", id);
}
pageContext.forward("login.jsp");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 성공</h1>
</body>
</html>