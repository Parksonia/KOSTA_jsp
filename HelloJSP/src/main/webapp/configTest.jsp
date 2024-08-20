<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String dir = config.getInitParameter("fileDir");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=dir %></h1>
<img src="<%=dir%>\개구리.jpg" style="width:500px;" alt="이미지">

</html>