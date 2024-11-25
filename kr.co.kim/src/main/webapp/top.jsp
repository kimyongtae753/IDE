<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Integer money = 50000;
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>상단 페이지(메뉴 부분)</p>
${menu1}<br> ${menu1} <!-- EL(expression language) 방식 -->
<%=money%> <!-- 표현방식 -->
</body>
</html>