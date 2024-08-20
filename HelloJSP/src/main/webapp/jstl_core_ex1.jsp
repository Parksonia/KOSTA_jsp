<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="test" value="hello JSTL!"/>
<c:remove var="test"/>
<c:out value="${test}"/>

<c:catch var="err">
	<%=10/0%>
</c:catch>
<c:out value="${err}"></c:out>

<c:set var="n" value="10"/>
<c:set var="m" value="20"/>


<c:if test="${n<m}"> <!--"${n le m}"도 같은 결과임  -->
	<h3>${n }은 ${m }보다 작음</h3>

<!--else if 조건을 쓰고싶으면 이렇게 써야 함  -->
<c:choose>
	<c:when test="${5+10 ==50}">
		<h3>5+10은 50이다.</h3>
	</c:when>
	
	<c:otherwise>
		<h3>5+10은 50이 아니다.</h3>
	</c:otherwise>
	
</c:choose>	
</c:if>
</body>
</html>