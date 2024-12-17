<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QR 생성기 - 주문번호</title>
</head>
<body>
주문번호 <input type="text" id="scode" maxlength="6"><br>
<input type="button" value="QR생성" onclick="qrmake()">
<div id ="qrview"></div>
<div id ="qrimg"></div>

</body>

<script src="./qr.js?v=1"></script>
</html>