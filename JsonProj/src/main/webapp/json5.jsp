<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#btn').click(function() {
			let pers = {persons:[{name:"홍길동",age:30},{name:"송길동",age:40},{name:"하길동",age:50}]}
			
			$.ajax({
				url:'json5',
				type:'post',
				async:true,
				data:{param:JSON.stringify(pers)},
				success:function(result) {
					alert(result);
				}
			})
		
		})
	})
</script>
</head>
<body>
<button id="btn">버튼</button>
</body>
</html>