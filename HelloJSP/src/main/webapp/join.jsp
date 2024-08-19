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
	<form action="joinProc" method= "post">
		<div class="header"><h3>회원가입</h3></div>
		<div class="wrap">
			<div class="row">
				<div class="title">아이디</div>
				<div class="input"><input type="text" name="id"/></div>
			</div>
			<div class="row">
				<div class="title">이름</div>
				<div class="input"><input type="text" name="name"/></div>
			</div>
			<div class="row">
				<div class="title">비밀번호</div>
				<div class="input"><input type="password" name="pw"/></div>
			</div>
			<div class="row">
				<div class="title">이메일</div>
				<div class="input"><input type="text" name="email"/></div>
			</div>
			<div class="row">
				<div class="title">주소</div>
				<div class="input"><input type="text" name="addr"/></div>
			</div>
			<div class="button">
				<input type="submit" value="회원가입"/>
			</div>
		</div>
	</form>
</body>
</html>