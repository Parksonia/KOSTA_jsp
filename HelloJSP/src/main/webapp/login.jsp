<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String id = (String) session.getAttribute("id");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<%if(id!=null){%>
	<h3><%=id %> 님 환영합니다.<a href="logout">로그아웃</a></h3>
	<%}else{%>
	
	
	<form action="loginproc" method="post">
		<div><h3 class="header">로그인</h3></div>
		<div class="wrap">
			<div class="row">  
				<div class="title">아이디</div>
				<div class="input"><input type="text" name="id"/></div>
			</div>
			<div class="row">  
				<div class="title">비밀번호</div>
				<div class="input"><input type="text" name="password"/></div>
			</div>
			<div class="row">  
				<input type="checkbox" name="type" class="title"><b>자동로그인</b>
			</div>
			<div>
				<input type="submit" value="로그인"/>
			</div>
		</div>
	</form>
	<%} %>
</body>
</html>