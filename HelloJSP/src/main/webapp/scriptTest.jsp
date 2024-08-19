<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	/*C:\PSY\jsp_workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\hello\org\apache\jsp  */
	/*클래스 영역이기 때문에 메서드 정의 가능  */
	int age = 20;
	String name ="hong";
	
	String info() {
		return String.format("name: %s, age:%d",name,age);
	}
%>
<%
	int lage =30;
	String lname = "gildong";

    /* 메소드 영역이기 때문에  함수의 정의 불가능 
 	String info() {
		return String.format("name:%s,age:%d",name,age);}*/

	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= info()%><br>
<%= lage %><br>
<%= lname %><br>
</body>
</html>