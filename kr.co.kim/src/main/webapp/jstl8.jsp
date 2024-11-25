<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl7 외부페이지 로드</title>
<%@ taglib prefix="aa" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
상품명 : ${pdname}<br><br><br>


<aa:forEach var="userad" items="${ad}">
<aa:if test="${userad.get(1) >= 30}">
<span>${userad.get(0)} : ${userad.get(1)}</span><br>
</aa:if>
</aa:forEach>

<aa:forEach var="userad2" items="${ad2}">
<aa:if test="${userad2.get(1) >= 30}">
<span>${userad2.get(0)} : ${userad2.get(1)}</span><br>
</aa:if>
</aa:forEach>

<aa:set var="menu" value="${menu}"/>

<aa:forEach var="data" items="${userdata}">
<span>${data.get(0)} :	 ${data.get(1)} </span><br>
</aa:forEach>



</body>
</html>