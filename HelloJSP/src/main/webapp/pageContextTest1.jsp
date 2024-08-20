<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <% pageContext.forward("pageContextTest2.jsp"); %> --%>
<jsp:forward page="pageContextTest2.jsp">
	<jsp:param value="test" name="param"/>
</jsp:forward>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>pageContextTest1.jsp</h1>
<!--foward시켰기때문에 <h1>tag는 출력되지 않는다.  -->
</body>
</html>