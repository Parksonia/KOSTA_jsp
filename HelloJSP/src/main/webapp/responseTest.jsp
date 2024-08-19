<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 	//response.sendRedirect("responseTest2.jsp");
	//responseTest.jsp로 갔다가  바로 responseTest2.jsp로 페이지를 응답함,둘은 완전 분리됨 (2번)
	//http://localhost:8080/hello/responseTest.jsp?param=test 하면 null 왜냐면 responseTest2.jsp?로 param이 넘어간게 없으니까 완벽 분리
	
	pageContext.forward("responseTest2.jsp"); 
	// responseTest.jsp가서 응답은 2가 해줌, 위임받은것 ,데이터 공유됨 (1번만 감)
	//http://localhost:8080/hello/responseTest.jsp?param=test 하면 test라는 데이터가 넘어감 ,페이지가 달라도 공유됨
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ResponseTest.jsp</h1>
</body>
</html>