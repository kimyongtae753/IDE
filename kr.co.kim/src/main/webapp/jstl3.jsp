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
 //자바 배열을 jstl로 출력
 	String data[] = new String[]{"hong","kim","park"};
	request.setAttribute("data", data); // 키가 있는 값을 셋팅
 	ArrayList<String> al = new ArrayList<String>();
	al.add("홍길동");
	al.add("이순신");
	al.add("장보고");
	al.add("을지문덕");
	
	/* 응용문제
	해당 배열값에 맞는 jstl 출력코드를 작성하시오.
	단, 해당 숫자 배열값 중 2의 배수 및 5의 배수 조건에 맞는 결과값만 웹이 출력되도록 합니다.*/
	
	Integer number[] = new Integer[]{22,10,19,27,25,33,35,40,2,55,50};
	request.setAttribute("number", number);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 기본문법 (배열) + 반복문(foreach)</title>
</head>
<body>
<!-- jsp에서 생성된 가장 기본적으로 쓰는 반복문 형태를 jstl foreach문을 이용해서 데이터를 출력하는 방식 -->
<ol>
<cr:forEach var="z" items="<%=data%>">
<li>${z}</li>
</cr:forEach>
</ol>
<br><br><br>
<!--  begin : 시작값, end : 종료값 ** 기본은 오름차순으로 출력됨-->
<ol>
<cr:forEach var="zz" begin="1" end="5" step="1">
<li>${zz}</li>
</cr:forEach>
</ol>
<p>고객 리스트 정보</p>
<!-- ArrayList 배열값을 받아서 forEach으로 출력합니다. 단, 조건문에 맞는 값만 출력 -->
<cr:forEach var="user" items="<%=al%>">
<cr:if test="${user == '이순신'}">
<span>고객명 : ${user}</span><br>
</cr:if>
</cr:forEach>
<br><br>

<cr:forEach var="number" items="<%=number%>">
<cr:if test="${0 ==(number%2)  || (number%5) == 0}">
<span>숫자 : ${number}</span><br>
</cr:if>
</cr:forEach>

<!-- 역순으로 출력 -->
<cr:set var="kno" value="5"></cr:set>
<cr:forEach var="k" begin="0" end="4" step="1">
<div>${kno-k}</div>
</cr:forEach>


</body>
</html>