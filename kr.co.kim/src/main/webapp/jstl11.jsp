<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl 엔진 prefix에서 선언된 이름 : 태그명-->
<%@ taglib prefix="aa" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jstl에서 사용하는 함수 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- SQL을 연결하고 싶을 경우-->
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>    
 <!-- 
 사용자 : shop
 DB : shopping
 table : notice
  -->   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl + db연결 + 출력</title>


</head>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"
url="jdbc:mysql://192.168.240.3:13306/shopping"
user="shop"
password="shop1234"/>

<aa:set var="table" value="notice"></aa:set>
<aa:set var="querys" value="order by nidx desc"></aa:set>
<sql:query var="qe" dataSource="${db}">
select nidx,nsubject,nwriter,ndate from ${table} ${querys}
</sql:query>
<sql:query var="total" dataSource="${db}">
select count(*) cnt from ${table}
</sql:query>

<body>
현재 총 게시물이 <span id="count"></span>개 있습니다.

<table border="1">
<tr>
<td>NO</td>
<td>제목</td>
<td>글쓴이</td>
<td>등록일</td>
</tr>
<aa:set var="total" value="${total.rows[0].cnt}"/>
<!-- jstl sql에서 ddl로 실행된 값을 forEach문을 통해서 표현하는 방식 -->
<aa:forEach var="row" items="${qe.rows}" varStatus="idx"> <!-- rows = jstl의 고정된 값 -->
<tr>
<td>${total - idx.index}</td><!-- 0부터 시작 +1씩 카운팅을 적용함 -->
<aa:set var="subject" value="${fn:length(row['nsubject'])}"/>
<aa:if test="${subject > 20}">
<aa:set var="com" value="..."/>
</aa:if>
<aa:if test="${subject < 20}">
<aa:set var="com" value=""/>
</aa:if>
<th>${fn:substring(row['nsubject'],0,30)} ${com}</th>
<th>${row['nwriter']}</th>
<th>${fn:substring(row['ndate'],0,10)}</th>

</tr>
</aa:forEach>
</table>


</body>
<script>
//jstl 변수값을 javascript변수값으로 이관 후 해당 HTML태그로 값을 출력시킴
var total = ${total};
document.getElementById("count").innerText = total;
</script>
</html>