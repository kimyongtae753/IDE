<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="aa" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl 기본문법(if)</title>
</head>
<body>
<!-- if문 선언 및 test가 조건을 사용하는 속성 : var(true, false) 결과형태 -->
<aa:if test="${5>10}" var="result">
5가 큽니다.
</aa:if>
결과 : ${result}<br><br>
<aa:if test="${5<10}" var="result">
10이 큽니다.
</aa:if>
<br><br><br>
결과 : ${result}
<!-- jstl은 if와 else는 있지만 else if는 없다 -->
<aa:set var="no" value="100"/>
<aa:if test="${no == 100}">
no는 100입니다.
</aa:if>

<%--  <aa:choose>: 조건문을 시작하는 태그입니다.
<aa:when>: 조건이 참일 경우 실행되는 블록을 정의합니다.
<aa:otherwise>: 모든 <c:when> 조건이 거짓일 때 실행되는 블록을 정의합니다.
이렇게 하면 no가 100 이하일 때와 초과할 때의 경우를 모두 처리할 수 있습니다.
 --%>

<!-- 조건식의 그룹 태그 : choose 
* choose안에 절대 html 주석을 사용하지 못함 주석을 꼭 쓰고싶으면 jsp 주석을 사용합시다
 eq, ne, or(||), and(&&)
 -->
 <aa:set var="no2" value="n"/>
<aa:choose>
	<aa:when test="${no2 == 'a'}">
	신용카드 결제
	</aa:when>
	<aa:when test="${no2 == 'b'}">
	현금 결제
	</aa:when>
	<aa:when test="${no2 == 'c'}">
	무통장 결제
	</aa:when>
	<aa:otherwise>
	포인트로 결제합니다
	</aa:otherwise>
</aa:choose>

<br><br><br>
<aa:set var="mid" value="hong111"></aa:set>
<!-- eq(equals) : 같음, ne(not) : 다른문자 **문자 검토시 ''를 이용해서 검토합니다. -->

<aa:if test="${mid eq 'hong'}">
로그인 하셨습니다.
</aa:if>

<aa:if test="${mid eq 'hong'}">
가입되지 않은 사용자입니다.
</aa:if>


</body>
</html>