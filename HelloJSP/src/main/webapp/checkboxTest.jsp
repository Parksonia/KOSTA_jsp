<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--name 1개의 여러개의 선택이 가능한 경우 배열형태로 데이터가 넘어간다. -->
<form action="Hobbies" method="get">
	<input type="checkbox" name="hobby" value="book"/>독서<br>
	<input type="checkbox" name="hobby" value="movie"/>영화감상<br>
	<input type="checkbox" name="hobby" value="football"/>축구<br>
	<input type="checkbox" name="hobby" value="swim"/>수영<br>
	<input type="submit" value="제출"/>
</form>
</body>
</html>