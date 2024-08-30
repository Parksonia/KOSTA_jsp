<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
 let obj = {id:'1001', name:'hong', age:30}
 console.log(typeof obj);
 console.log(obj);

 // 자바 스크립트 객체 변수를 백엔드로 보내기 위해 JSON형태의 문자열로 변환해야함
 // 자바 스크립트 객체 => JSON 문자열 : JSON.stringify
let objJson = JSON.stringify(obj); // obj타입을 String 문자열타입으로 바꿔줌
console.log(typeof objJson);
console.log(objJson);
 
 // 백엔드로부터 프론트로 넘겨 받은 데이터로  JSON 형태의 문자열을 자바스크립트 객체 타입으로 변환 한 것임.
 //JSON 문자열 => 자바스크립트 객체: JSON.parse
 let reObj = JSON.parse(objJson);
 console.log(typeof reObj);
 console.log(reObj);
</script>

</head>
<body>


</body>
</html>