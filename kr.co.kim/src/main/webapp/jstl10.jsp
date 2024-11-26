<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl 엔진 prefix에서 선언된 이름 : 태그명-->
<%@ taglib prefix="aa" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jstl에서 사용하는 함수 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- SQL을 연결하고 싶을 경우-->
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"
url="jdbc:mysql://192.168.240.3:13306/shopping"
user="shop"
password="shop1234"/>




<aa:set var="table" value="member"/>
<aa:set var="where" value="where mid='apink'"/>
<aa:set var="order" value="order by midx desc"/>
<sql:query var="ps" dataSource="${db}">
select * from ${table} ${order}
</sql:query>



<table border="1">
<tr>
<td>아이디</td>
<td>고객명</td>
<td>이메일</td>
</tr>
<!-- jstl sql에서 ddl로 실행된 값을 forEach문을 통해서 표현하는 방식 -->
<aa:forEach var="row" items="${ps.rows}">
<tr>
<td>${row['mid']}</td>
<td>${row['mname']}</td>
<td>${row['memail']}</td>
</tr>
</aa:forEach>
</table>


</body>
</html>