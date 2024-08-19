<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<div><h3 class="header">회원가입</h3></div>
		<div class="wrap">
			<div class="row">  
				<div class="title">아이디</div>
				<div class="input"><input type="text"/></div>
			</div>
			<div class="row">  
				<div class="title">이름</div>
				<div class="input"><input type="text"/></div>
			</div>
			<div class="row">  
				<div class="title">비밀번호</div>
				<div class="input"><input type="text"/></div>
			</div>
			<div class="row">  
				<div class="title">이메일</div>
				<div class="input"><input type="text"/></div>
			</div>
			<div class="row">  
				<div class="title">주소</div>
				<div class="input"><input type="text"/></div>
			</div>
			<div>
				<input type="submit" value="회원가입"/>
			</div>
		</div>
	</form>
</body>
</html>