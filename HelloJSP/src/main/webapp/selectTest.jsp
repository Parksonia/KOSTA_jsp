<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form action="choiceDog" method="get">
	<select name ="dog" multiple="multiple"><!--여러개 다중선택은 mutiple="multiple"  -->
		<option value="pu">푸들</option>
		<option value="jindo">진돗개</option>
		<option value="pung">풍산개</option>
		<option value="sap">삽살개</option>
	</select>
	<input type="submit" value="제출"/>
	</form>
</body>
</html>