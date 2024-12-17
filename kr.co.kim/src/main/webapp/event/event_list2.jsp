<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>이벤트 참여 리스트 페이지</title>
</head>
<body>
<!-- Pageing

1. select 시 limit
2. 페이지당 출력 갯수
3. desc형태로 (최신등록 형태 기준)
4. count(*) 필요  -->
<table border="1" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
		<th>번호</th>
		<th>고객명</th>
		<th>고객이메일</th>
		<th>전화번호</th>
		<th>SMS 수신여부</th>
		<th>Email 수신여부</th>
		<th>이벤트 참여일</th>	
	</tr>	
	</thead>	
	<tbody>
	<cr:set var="ino" value="${total-userpage}"/>
	<cr:forEach var="data" items="${all}" varStatus="idx">
	<tr>		
		<th>${ino-idx.index + 1}</th>
		<th>${data.MNAME}</th>
		<th>${data.MEMAIL}</th>
		<th>${data.TEL_NO}</th>
		<th>${data.SMS}</th>
		<th>${data.EMAIL}</th>
		<th>${fn:substring(data.EVENT_DATE,0,10)}</th>		
	</tr>
	</cr:forEach>
	</tbody>
</table>
<br><br><br><br>
<!-- 데이터 검색기능 -->
<form id="frm" method="get" action="./event_list.do" onsubmit="return sh(1)">
검색:
<select>
<option>고객명</option>
<option>연락처</option>
</select>
<input type="text" name="search">
<input type="submit" value="검색">
<input type="button" value="전체 리스트" onclick="sh(2)">
</form>
<!-- 데이터 검색가능 -->
<script>
function sh(p) {
	if(p==1){
		if(frm.search.value==""){
			alert("검색어를 입력하세요!");
			return false;
		}
		else{
			frm.submit();
		}
	}
	else if (p==2) { //전체리스트
		location.href='./event_list.do'		
	}
}

</script>

<!-- 페이징 번호 jstl -->
<table border="1" cellpadding="0" cellspacing="0">
<tbody>
<tr>
<!-- 2인 이유는 한 페이지당 2개씩 적용하도록 설정했기 때문에 -->
<cr:set var="pages" value="${total / 2 +(1 -((total / 2) % 1)) % 1}"/>
<cr:forEach var="no" begin="1" end="${pages}" step="1">
    <td width="30" align="center" onclick="page_go(${no})">${no}</td>
</cr:forEach>
</tr>	
</tbody>
</table>
</body>
<script>
function page_go(n) {
	
	location.href='./event_list2.do?pageno='+n;	
}
</script>
</html>