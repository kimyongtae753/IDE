<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//아이디, 고객명, 접속ip, 접속운영체제, 접속 브라우져
HttpSession sess = request.getSession();
sess.invalidate(); //session에 있는 모든 데이터를 삭제

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃 session</title>
</head>
<body>

</body>
</html>