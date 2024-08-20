<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.*" %>
<%@ page import = "bean.Member" %>

<%
	List<Member> members = new ArrayList<>();
	members.add(new Member("hong","홍길동","1234","hong@kosta.com","서울시 금천구"));
	members.add(new Member("song","송길동","1234","song@kosta.com","서울시 영등포구"));
	members.add(new Member("gong","공길동","1234","gong@kosta.com","서울시 강서구"));
	request.setAttribute("members", members);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="i" begin="1" end="10" step="1"> <!--for(int i=1; i<11 i++)과 같다.  -->
	<b>${i}</b>&nbsp;	
</c:forEach>

<table border="1">
	<tr>
		<th>순번</th>
		<th>아이디</th>
		<th>이름</th>
		<th>비밀번호</th>
		<th>이메일</th>
		<th>주소</th>
	</tr>
	<%-- <c:forEach var="member" items="<%=members%>" varStatus="status"> --%>
	<c:forEach var="member" items="${members}" varStatus="status"> <!--request에서 가져오기 때문에 request.setAttribute해야함  -->
	<tr>
	<td>${status.count}</td>
	<td>${member.id}</td>
	<td>${member.name}</td>
	<td>${member.password}</td>
	<td>${member.email}</td>
	<td>${member.address}</td>
	</tr>
	</c:forEach>
</table>	
	<c:forTokens items="홍길동#김길동#송길동#콩길동#통길동#하길동" delims="#" var="name">
	<b>${name}</b>&nbsp;
	</c:forTokens>
	<br>
	<c:set var="fruits" value="apple,banna,orange,strawberry"></c:set>
	<c:forTokens items="${fruits}" delims="," var="fruit">
	<b>${fruit}</b>&nbsp;
	</c:forTokens>

</body>
</html>