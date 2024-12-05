<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
연락처 : <input type="text" id="tel1" maxlength="3"> -
<input type="text" id="tel2" maxlength="4"> - <input type="text" id="tel3" maxlength="4">
<input type="button" value="인증번호 받기" id="btn">
<br><br><br>
<form id="frm" method="post" action="./ecmaok.do">
아이디 : <input type="text" name="mid"><br>
비밀번호 : <input type="password" name="mpass"><br>
<button type="submit">로그인</button>
</form>
</body>
<script type="modul">
import {tels} from "./ecma5.js";

document.quertSelector("#frm").addEventListener("submit",function(z){
			z.preventDefault();
			new tels()
			console.log(z);     //해당 클래스를 로드 후 해당 메소드를 실행

});


//addEventListener : 이벤트를 발생시키기 위한 대기모드
document.quertSelector("#btn").addEventListener("click",function(){
			new tels().tel_check();     //해당 클래스를 로드 후 해당 메소드를 실행

});



</script>
</html>