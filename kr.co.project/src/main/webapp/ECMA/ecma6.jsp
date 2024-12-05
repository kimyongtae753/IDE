<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="frm">
데이터1 <input type="checkbox" value="data1"><br>
데이터2 <input type="checkbox" value="data1"><br>
데이터3 <input type="checkbox" value="data1"><br>
데이터4 <input type="checkbox" value="data1"><br>
<input type="button" value="데이터 삭제요청" id="btn">


</form>
</body>

<script type="modul">
import {delete_check} from "./ecma7.js";
document.querySelector("#btn").addEventListener("click",function(){
	var ea = document.getElementsByName("data").length;
	var count = 0; // 체크된 카운팅
	var w = 0;

	let arr = new Array();	

	while(w < ea){

	if(document.getElementsByName("data")[w].checked == true){
				arr[count] = document.getElementsByName("data")[w].value;
			
				count++;
		}
	w++;

	}
	
	new delete_check().ajax_delete(arr); //배열로 생성 값을 ajax 메소드로 인자값으로 전달
});


</script>
</html>