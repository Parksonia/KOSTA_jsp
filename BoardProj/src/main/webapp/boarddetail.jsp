<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h2, #commandCell {
	text-align: center;
}

table {
	margin: auto;
	width: 450px;
}

.td_left {
	background: orange;
	width:150px;
}

.td_right {
	background: skyblue;
	width:300px;
}

#content {
	height: 200px;
}
</style>
</head>
<body>
<h2>게시판 글 상세</h2>
<table border="1">
	<tr>
		<td class="td_left"><label>글쓴이</label></td>
		<td class="td_right"><span>${requestScope.board.writer}</span></td>
	</tr>
	<tr>
		<td class="td_left"><label>제목</label></td>
		<td class="td_right"><span>${board.subject}</span></td>
	</tr>
	<tr>
		<td class="td_left"><label>내용</label></td>
		<td class="td_right"><div id="content">${board.content}</div></td>
	</tr>
	<tr>
		<td class="td_left"><label>이미지</label></td>
		<td class="td_right"><img src="image?file=${board.filename}" width="100px"></td> <!--src="image ~" =>매핑된url이다.   -->
	</tr>

</table>
<div id="commandCell">
	<a href="#">수정</a>&nbsp;&nbsp;&nbsp;
	<a href="#">목록</a>
</div>
</body>
</html>