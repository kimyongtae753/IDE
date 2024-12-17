<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="widtj=device-width, initial-scale=1.0">
<title>QR 관련 정보 출력</title>
</head>
<body>
<table border="1">

<thead>
<tr>
<th>주문번호</th>
<th>고객명</th>
<th>배송현황</th>
</thead>
</tr>
<tbody>
<tr>
<td>${scode}</td>
<td>${username}</td>
<td>${delivery}</td>
</tr>
</tbody>
</table>
</body>
</html>