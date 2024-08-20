<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <% pageContext.include("pageContextTest3.jsp"); %> --%>
<%-- <%@include file ="pageContextTest3.jsp" %> --%>
<jsp:include page="pageContextTest3.jsp">
	<jsp:param value="20" name="age"/>
</jsp:include>

<h1>pageContextTest2.jsp</h1>
<%-- <%=request.getParameter("param") %> --%>

</body>
</html>