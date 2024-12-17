<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CDN Server 전송</title>
</head>
<body>

   <!-- pdf, hwp -->
   
   <form id="frm" method="POST" action="./cdn_fileok.do" enctype="multipart/form-data">
      이미지 등록 : <input type="file" name="mfile" onchange="fileview(this)"><br>
      <img id="views" style="width: 150px; height: 150px;">
      <input type="button" value="전송" onclick="cdn_file()">
   </form>
   
</body>

<script src="./cnd.js"></script>
</html>