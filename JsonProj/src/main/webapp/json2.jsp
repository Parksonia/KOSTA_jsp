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
      $('#checkJson1').click(function() {
         let obj = {name:['홍길동', '김길동', '송길동']}
         console.log(obj)
         
         let jsonArr = JSON.stringify(obj);
         console.log(jsonArr)
         
         let nameArr = JSON.parse(jsonArr);
         nameArr.name.forEach(function(name) {
            $('#output').append(`<tr><td>\${name}</td></tr>`)
         })
      })
      $('#checkJson2').click(function() {
         let obj = ['홍길동', '김길동', '송길동']
         //checkJson1과 다른 타입 
         console.log(obj)
         
         let jsonArr = JSON.stringify(obj);
         console.log(jsonArr)
         
         let nameArr = JSON.parse(jsonArr);
         nameArr.forEach(function(name) {
            $('#output').append(`<tr><td>\${name}</td></tr>`)
         })
         
      })
   })
</script>
</head>
<body>
   <a id="checkJson1">출력1</a>
   <a id="checkJson2">출력2</a>
   <table  id="output" border="1">
      <tr><th>회원이름</th></tr>
   </table>
</body>
</html>