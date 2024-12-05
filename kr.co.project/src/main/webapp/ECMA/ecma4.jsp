<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" name="mid" id="mid"><br>
<input type="button" value="중복확인" id="btn">
<br><br><br>
해당 숫자의 범위 안에 있는 모든 값을 더하여 결과를 출력하는 코드 작성
첫번째값 : <input id="min" type="text" maxlength="2" ><br>
두번째값 : <input id="max" type="text" maxlength="2"><br>
<input type="button" value="계산하기" id="btn1">


</body>
<script type="module">
import { idcheck, plus } from "./ecma4.js?v=1";


document.querySelector("#btn").addEventListener("click", function(){
		var data = document.querySelector("#mid");
		idcheck(data.value);
});


</script>

</html>