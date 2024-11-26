<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	  	String userid="dhs99089";
	 	String username="김용태";
	 	HttpSession sess = request.getSession();
	 	//로그인된 정보를 세션으로 생성하는 코드
	 	sess.setAttribute("id", userid);
	 	sess.setAttribute("name", username);
	 
 %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 하는 상황(session1)</title>
</head>
<body>

</body>
</html>