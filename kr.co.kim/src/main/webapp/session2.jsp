<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

		HttpSession sess = request.getSession();
		out.print(sess.getAttribute("id"));
		out.print(sess.getAttribute("name"));
	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 후 세션(session2)</title>
</head>
<body>

</body>
</html>