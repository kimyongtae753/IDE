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
총 합 : ${hap}

<aa:set var="total" value="0"/>
<aa:forEach var="sum" items="${sum}">
 <aa:set var="total" value="${total + sum}"/>
</aa:forEach>
총 합 : ${total}


</body>
</html>