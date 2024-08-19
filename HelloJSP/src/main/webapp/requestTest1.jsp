<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	Enumeration e= request.getParameterNames();
	while(e.hasMoreElements()){
		out.print(e.nextElement()+"\t");
	}
	
	
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Test</title>
</head>
<body>
	<h1>Request 예제입니다.</h1>
	<table border="1" style="width: 400">
		<tr>
			<td>이름</td>
			<td><%=request.getParameter("name") %></td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<%
			if(request.getParameter("gender").equals("male")){
			%> 남자 <%
			}else{
			%> 여자 <%	
			}%>
			</td>
		</tr>
		<tr>
			<td>취미</td>
			<td>
				<%
				String[] hobby = request.getParameterValues("hobby");
				for(String h :hobby){ %> <%=h%>&nbsp;&nbsp; <%}%>
			</td>
		</tr>
	</table>

</body>
</html>