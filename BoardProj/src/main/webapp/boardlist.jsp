<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
h2, #paging, #tr_top {
	text-align: center;
}

table, #member, #paging {
	margin: auto;
	width: 800px;
}
td,th{border:solid gray 1px;}
#member {
	margin: auto;
	width: 800px;
	text-align: right;
}

#tr_top {
	background: orange;
	text-align: center;
}

#paging a {
	display: inline-block;
	width: 20px;
	height: 20px;
	border: solid gray 1px;
	text-decoration: none;
}

#paging .select {
	background: lightblue;
}

#paging .btn {
	background: lightgray;
}
</style>
<title>Insert title here</title>

</head>
<body>

	<h2>
		글목록 &nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${ id ne null}"> <a href="boardWrite">글쓰기</a></c:if>
	</h2>
	<div id="member">
		<c:choose>
			<c:when test="${id eq null }">
				<a href ="login">로그인</a>&nbsp;&nbsp;
			</c:when>
			<c:otherwise>
				<b>[ ${id} ]</b>&nbsp;&nbsp;<a href="logout">로그아웃</a>
			</c:otherwise>
		</c:choose>
		<a href="join">회원가입</a>
	</div>
	<br>
	<table border="1">
		<tr id="tr_top">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${list}" var="board">
			<tr>
				<td>${board.num }</td>
				<td><a href="boardDetail?num=${board.num}"> ${board.subject }</a></td>
				<td>${board.writer }</td>
				<td>${board.create_date }</td>
				<td>${board.view_cnt }</td>
		</tr>
		</c:forEach>

	</table>
	<div id="paging">
	
		<c:choose>
			<c:when test="${pageInfo.curPage>1 }">
					<a href="boardList?page=${pageInfo.curPage-1}">&lt;</a>			
			</c:when>
			<c:otherwise>
					<a>&lt;</a>
			</c:otherwise>
		</c:choose>
	
		<c:forEach  begin="${pageInfo.startPage }"  end="${pageInfo.endPage }" var="i">
			<c:choose>
			<c:when test="${i eq pageInfo.curPage }">
			<a href="boardList?page=${i}" class="select">${i}</a>
			</c:when>
			<c:otherwise>
			<a href="boardList?page=${i}" class="btn">${i}</a>
			</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${pageInfo.curPage < pageInfo.allPage}">
			  <a href="boardList?page=${pageInfo.curPage+1}">&gt;</a>
			</c:when>
				<c:otherwise>
					<a>&gt;</a>
			</c:otherwise>
		
		</c:choose>
		
		
		
	</div>
</body>
</html>