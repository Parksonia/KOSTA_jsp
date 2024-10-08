<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Test2</title>
</head>
<body>
	<h1>URL/URI , METHOD</h1>
	<table border="1">
		<tr>
			<td>서버 도메인 명</td>
			<td><%=request.getServerName()%></td>
		</tr>
		<tr>
			<td>서버 포트번호</td>
			<td><%=request.getServerPort()%></td>
		</tr>
		<tr>
			<td>요청 URL</td>
			<td><%=request.getRequestURL()%></td>
		</tr>
		<tr>
			<td>요청 URI</td> <!--컨텍스트경로~page까지  -->
			<td><%=request.getRequestURI()%></td>
		</tr>
		<tr>
			<td>요청 쿼리</td>
			<td><%=request.getQueryString()%></td>
		</tr>
		<tr>
			<td>클라이언트 호스트명</td>
			<td><%= request.getLocalName() %></td>
		</tr>
		<tr>
			<td>클라이언트 IP주소</td>
			<td><%=request.getLocalAddr()%></td>
		</tr>
		<tr>
			<td>프로토콜</td>
			<td><%=request.getProtocol()%></td>
		</tr>
		<tr>
			<td>요청방식</td>
			<td><%=request.getMethod()%></td>
		</tr>
		<tr>
			<td>컨텍스트 경로</td>
			<td><%=request.getContextPath()%></td>
		</tr>
	</table>
</body>
</html>