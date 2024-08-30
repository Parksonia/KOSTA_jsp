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
			
			$.ajax({
				url:'json7',
				type:'post',
				async:true,
				data:{param:JSON.stringify(pers)},
				success:function(result) {
					console.log(result)
					
					let resObj = JSON.parse(result);
					$('#team').text(resObj.team);
					$('#area').text(resObj.area);
					
					resObj.pers.forEach(function(per){
						$('#pers').append(`<tr><th>\${per.name}</th><th>\${per.age}</th></tr>`)
					})
					
				}
			})
		
		})
	})
</script>
</head>
<body>
<button id="btn">버튼</button>

<div id="team"></div>
<div id="area"></div>

<table  id="pers" border="1">
<tr><th>이름</th><th>나이</th></tr>
</table>
</body>
</html>