<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.wrap {
		margin: 0 auto;
		border: 1px solid;
		width: 600px;
	}
	.row {
		height:35px;
		border-top: 1px solid;
		border-bottom: 1px solid;
	}
	.title {
		font-weight: bold;
		background-color: lightgray;
	}
	.column {
		width:98px;
		float:left;
		line-height:35px;
		text-align:center;
		border-left:1px solid;
		border-right:1px solid;
	}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
	let accs = [
		{id:'1001',name:'홍길동',balance:100000,type:'일반',grade:''},
		{id:'1002',name:'김길동',balance:200000,type:'특수',grade:'VIP'},
		{id:'1003',name:'고길동',balance:300000,type:'특수',grade:'Gold'},
		{id:'1004',name:'송길동',balance:400000,type:'특수',grade:'Silver'},
		{id:'1005',name:'하길동',balance:500000,type:'특수',grade:'Normal'}
	]
	
	$(function() {
		accs.forEach(function(acc,index) {
			let row = $('<div></div>').addClass('row');
			$('<div></div>').addClass('column').text(index).appendTo(row);
			$('<div></div>').addClass('column').text(acc.id).appendTo(row);
			$('<div></div>').addClass('column').text(acc.name).appendTo(row);
			$('<div></div>').addClass('column').text(acc.balance).appendTo(row);
			$('<div></div>').addClass('column').text(acc.type).appendTo(row);
			$('<div></div>').addClass('column').text(acc.grade).appendTo(row);
			$('.wrap').append(row);
		})
	})
	
</script>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div><h3 style="text-align:center;">전체계좌조회</h3></div>
	<div class="wrap">
		<div class="row">
			<div class="column title">순서</div>
			<div class="column title">계좌번호</div>
			<div class="column title">이름</div>
			<div class="column title">입금액</div>
			<div class="column title">종류</div>
			<div class="column title">등급</div>
		</div>
	</div>
</body>
</html>