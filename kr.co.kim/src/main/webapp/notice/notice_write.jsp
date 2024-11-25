<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 입력파트</title>
</head>
<body>
<form id="f" method="post" action="${action}">
제목 : <input type = "text" name="nsubject"><br>
작성자 : <input type = "text" name="nwriter" value="${user}" readonly="readonly"><br>
패스워드 : <input type="password" name="npass"><br>
내용 : <input type="text" name="ntext"><br>
<button type="button">공지사항 등록</button>
</form>

</body>

<script>
function writeok(){
	f.submit();
} 

</script>
</html>