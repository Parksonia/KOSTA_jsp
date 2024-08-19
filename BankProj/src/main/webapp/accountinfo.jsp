<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Account" %>
<% Account acc = (Account)request.getAttribute("acc"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/common.css" rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp" %>
	<form action="#" method="post">
		<div><h3 class="header">계좌조회</h3></div>
		<div class="wrap">
			<div class="row">  
				<div class="title">계좌번호</div>
				<div class="input"><input type="text" disabled value="<%=acc.getId()%>"/></div>
			</div>
			<div class="row">  
				<div class="title">이름</div>
				<div class="input"><input type="text" disabled value="<%=acc.getName()%>"/></div>
			</div>
			<div class="row">  
				<div class="title">잔액</div>
				<div class="input"><input type="text" disabled value="<%=acc.getBalance()%>"/></div>
			</div>
			<div class="row">  
				<div class="title">종류</div>
				<div class="input"><input type="text" disabled value="<%=acc.getType()%>"/></div>
			</div>
			<%if(acc.getType().equals("special")) {%>
			<div class="row">  
				<div class="title">등급</div>
				<div class="input"><input type="text" disabled value="<%=acc.getGrade()%>"/></div>
			</div>
			<%} %>
		</div>
	</form>
</body>
</html>