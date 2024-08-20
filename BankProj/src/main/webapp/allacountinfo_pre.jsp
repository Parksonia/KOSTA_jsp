<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Account" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List<Account> accs = (ArrayList<Account>)request.getAttribute("accs"); %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.wrap {
		margin: 0 auto;
		border: 1px solid;
		width: 600px;
	}
	.row {
		height:35px;
		border-top: 1px solid;
		border-bottom: 1px solid;
	}
	.title {
		font-weight: bold;
		background-color: lightgray;
	}
	.column {
		width:98px;
		float:left;
		line-height:35px;
		text-align:center;
		border-left:1px solid;
		border-right:1px solid;
	}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

</head>
<body>
	<%@ include file="header.jsp" %>
	<div><h3 style="text-align:center;">전체계좌조회</h3></div>
	<div class="wrap">
		<div class="row">
			<div class="column title">순서</div>
			<div class="column title">계좌번호</div>
			<div class="column title">이름</div>
			<div class="column title">입금액</div>
			<div class="column title">종류</div>
			<div class="column title">등급</div>
		</div>
		
		<%
		   for(int i=0; i<accs.size(); i++){
		   %>
		   <div calss="row">
		   <div class="column"><%= i+1%></div>
		   <div class="column"><%=accs.get(i).getId()%></div>
		   <div class="column"><%=accs.get(i).getName()%></div>
		   <div class="column"><%=accs.get(i).getBalance()%></div>
		   <div class="column"><%=accs.get(i).getType()%></div>
		   <%if(accs.get(i).getType().equals("normal")) {
		   %>
		   <div class="column"></div>
		   <%}else {
		   %>
		    <div class="column"><%=accs.get(i).getGrade()%></div>
		  
		  <%
		   }
		   %>
			</div>
		    <%}
		  %>
	</div>
</body>
</html>