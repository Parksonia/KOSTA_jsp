<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	width: 150px;
}

.td_right {
	background: skyblue;
	width: 300px;
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
		<c:if test="${board.filename ne null}">

			<tr>
				<td class="td_left"><label>이미지</label></td>
				<!--src="image ~" =>매핑된url이다. 왜냐하면 서버의 경로를 직접 쓸 수 없기 때문에(차단됨)  -->
				<td class="td_right"><img src="image?file=${board.filename}"
					width="100px"></td>
			</tr>
		</c:if>
	</table>
	<div id="commandCell">
		<a href="modifyboard?num=${board.num}">수정</a>&nbsp;&nbsp;&nbsp; 
		<a href="boardList">목록</a>&nbsp;&nbsp;&nbsp;
		
		
		<c:if test="${id ne null }">
			<c:choose>
			<c:when test="${heart ne null}"><img src="image?file=redheart.png" width="30px;"></c:when>
			<c:otherwise><img src="image?file=blackheart.png" width="30px;"></c:otherwise>
			</c:choose>
		</c:if>
	</div>
</body>
</html>