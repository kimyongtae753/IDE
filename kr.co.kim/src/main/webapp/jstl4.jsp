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
	/*응용문제 각각의 1차배열값을 2차배열로 입력되도록 합니다.
	1번 데이터 : 홍길동, 강감찬, 이순신, 유관순
	2번 데이터 : A형, O형, AB형, A형
	아웃프린트로 찍었을 때 {"홍길동","A형"}순으로 끝까지 나오게 합니다.
	*/

 	ArrayList<String> al = new ArrayList<String>();
	al.add("홍길동");
	al.add("강감찬");
	al.add("이순신");
	al.add("유관순");
	
	/* 응용문제
	해당 배열값에 맞는 jstl 출력코드를 작성하시오.
	단, 해당 숫자 배열값 중 2의 배수 및 5의 배수 조건에 맞는 결과값만 웹이 출력되도록 합니다.*/
	
	ArrayList<String> blo = new ArrayList<String>();
	blo.add("A형");
	blo.add("O형");
	blo.add("AB형");
	blo.add("A형");
	
	request.setAttribute("al", al);
    request.setAttribute("blo", blo);
   //각각의 1차배열 - > 2차배열 변화(2차원시배열, 2차 클래스 배열)
   // String data3[][] = new String[3][1];
   //data3[0][0] = "홍길동";
   //data3[0][1] = "A형";
   String data3[][] = new String[al.size()][2];
   
   for(int k =0; k < al.size(); k++){
	   data3[k][0] = al.get(k);
	   data3[k][1] = blo.get(k);	   
   }
    
    
    ArrayList<String> ad = new ArrayList<String>();
    
   for(int i = 0; i <al.size(); i++){
	   String a = al.get(i);
	   String b = blo.get(i);	  
	   ad.add('"'+a+'"'+","+'"'+b+'"');
   }
   
   ArrayList<ArrayList<String>> ad2 = new ArrayList<ArrayList<String>>();
   
   for(int z = 0; z <al.size(); z++){
	   ArrayList<String> redata =new ArrayList<String>(); 
	   
	   redata.add(al.get(z));
	   redata.add(blo.get(z));	  
	   ad2.add(redata);
   }
   
   request.setAttribute("ad2", ad2);
   request.setAttribute("ad", ad);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 기본문법 (2차배열)</title>
</head>
<body>

<cr:forEach var="user" items="<%=al%>">
<cr:if test="${user == '이순신'}">
<span>고객명 : ${user}</span><br>
</cr:if>
</cr:forEach>


<ol>
<cr:forEach var="index" begin="0" end="${fn:length(al) - 1}">
    <cr:set var="user" value="${al[index]}"/>
    <cr:set var="blood" value="${blo[index]}"/>
    <li> {"${user} ", "${blood}"}</li>
</cr:forEach>
</ol>

<cr:forEach var="userad" items="<%=ad%>">
<span>{${userad}}</span><br>
</cr:forEach>

<cr:forEach var="userad2" items="<%=ad2%>">
<span>{${userad2}}</span><br>
</cr:forEach>


</body>
</html>