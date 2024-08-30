<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function() {
	let jsonstr = `{
		"data": [ {
    				"type": "articles",
    				"id": "1",
    				"attributes": {
      					"title": "JSON:API paints my bikeshed!",
      					"body": "The shortest article. Ever.",
      					"created": "2015-05-22T14:56:29.000Z",
      					"updated": "2015-05-22T14:56:28.000Z"
    				},
    				"relationships": {
    	  				"author": {
        					"data": {"id": "42", "type": "people"}
      					}
    				}
  				}],
		"included": [ {
      					"type": "people",
      					"id": "42",
      					"attributes": {
        					"name": "John",
        					"age": 80,
        					"gender": "male"
      					}
    				  }]
		}`;
		
	console.log(jsonstr)
	
	//name,age,gender, id,type
	let jsonObj = JSON.parse(jsonstr);
	
	let included = jsonObj.included;
	let included_0 = included[0];
	let id = included_0.id;
	let type = included_0.type;
	let attributes = included_0.attributes;
	let name = attributes.name;
	let age = attributes.age;
	let gender = attributes.gender;
	
	console.log(id);
	
	$.ajax({
		url:"json8",
		type:'post',
		async:true,
		data:{data:jsonstr},
		success:function(result) {
			
		}
	})
})	
</script>
</head>
<body>

</body>
</html>