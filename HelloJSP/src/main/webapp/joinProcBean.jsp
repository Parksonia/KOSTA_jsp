<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("utf-8"); %> 

<%-- <jsp:useBean id="member" class="bean.Member"/>
<jsp:setProperty property="*" name="member"/>
 --%><%-- <jsp:setProperty property="id" name="member" param="id"/>
<jsp:setProperty property="name" name="member" param="name"/>
<jsp:setProperty property="password" name="member" param="password"/>
<jsp:setProperty property="email" name="member" param="email"/>
<jsp:setProperty property="address" name="member" param="address"/>
 --%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <jsp:getProperty property="id" name="member"/><br>
<jsp:getProperty property="name" name="member"/><br>
<jsp:getProperty property="password" name="member"/><br>
<jsp:getProperty property="email" name="member"/><br>
<jsp:getProperty property="address" name="member"/><br>
 -->
<h3>${param.id}</h3>
<h3>${param.name}</h3>
<h3>${param.password}</h3>
<h3>${param.email}</h3>
<h3>${param.address}</h3>


</body>
</html>