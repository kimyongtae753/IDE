<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%

 String user = "대메뉴 출력!!!";

%>
</head>
<body>
<header>

${name} 님 환영합니다. 메일 : ${emeil} <input type="button" value="로그아웃">
</header>

<%@ include file="./top.jsp" %>
<%@ include file="./notice.jsp" %>
</body>
</html>