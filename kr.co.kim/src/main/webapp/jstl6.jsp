<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl 외부페이지 로드</title>
<%@ taglib prefix="aa" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  
jstl : Controller에서 각각의 import 된 page에 모두 전달이 가능함
*Controller에서 Model, ModelandView를 활용하면 외부ㅜ import된 jsp에서 jstl로 모든 결과값을 출력 가능합니다. 
-->

</head>
<body>


<aa:import url="./top.jsp"></aa:import>
${menu1}

</body>
</html>