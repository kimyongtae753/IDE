<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여러개의 File 전송</title>
</head>
<body>
<form id="frm" method="post" action="./fileupok4.do" enctype="multifile/form-data">
<div id="box">
<p>첨부파일 : <input type="file" name="mfile" onchange="maxfile(this)"><input type="button" value="+" onclick="file_plus()"></p>

</div>
<button type="button" onclick="fileup()">파일전송</button>
</form>
</body>
<script src="./File.js?v=3"></script>
</html>