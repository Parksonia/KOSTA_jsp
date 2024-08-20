<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--객체가 생성됨  -->
<jsp:useBean id="member" class="bean.Member"></jsp:useBean>
<!-- bean.Member member = new bean.Member(); 와 같음 -->

<jsp:setProperty name="member" property="id" value="hong"/>
<jsp:setProperty name="member" property="name" value="hong gil dong"/>
<jsp:setProperty name="member" property="password" value="1234"/>
<jsp:setProperty name="member" property="email" value="hong@gmail.com"/>
<jsp:setProperty name="member" property="address" value="seoul"/>

	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>자바빈 사용 예제</h1>
<jsp:getProperty property="id" name="member"/><br>
<jsp:getProperty property="name" name="member"/><br>
<jsp:getProperty property="password" name="member"/><br>
<jsp:getProperty property="email" name="member"/><br>
<jsp:getProperty property="address" name="member"/><br>
</body>
</html>