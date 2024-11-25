<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 
   jstl은 JSP에서 업그레이드 된 View 이며, 단독으로 실행하지 않는다.
   jstl은 엔진 및 함수(코어)가 필요한 부분이 발생한다
   jstl : Jsp Standard Tag Library
-->

<!-- jstl 엔진 prefix에서 선언된 이름 : 태그명-->
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jstl에서 사용하는 함수 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- SQL을 연결하고 싶을 경우-->
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%
	String user = "정미경,김용태,이선정,이태진";	
 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 기초문법 function</title>
</head>
<body>
<cr:set var="product" value="삼성 냉장고 - 삼성 시그니처"></cr:set>
${fn:length(product)} : 데이터 텍스트 길이갯수<br>
${fn:replace(product,"삼성","LG")} : 해당 데이터 중 설정된 단어를 변경하는 속성<br>
<br><br>
<cr:set var="money" value="123456789"></cr:set>
${fn:substring(money,4,6)} : 해당 데이터 중 4번째에서 6번째 사이의 단어를 출력<br>

${fn:substringAfter(money,3)} <br>
${fn:substringBefore(money,5)} 
<br><br>
<cr:set var="tel" value="${fn:replace('010 3163 7549',' ','-')}"/>
${tel}
<br><br>
<!-- fn안에는 jsp코드를 사용하지 못함 -->
<cr:set var="data" value="<%=user%>"/>
<cr:set var="user11" value="${fn:split(data,',')}"/>

<cr:forEach var="username" items="${user11}">
${username}
</cr:forEach>


</body>
</html>