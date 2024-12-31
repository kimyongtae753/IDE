<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String coupon = "M1234412";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>React - CDN</title>
<script src="https://unpkg.com/react@18.3.0/umd/react.production.min.js"></script>
<script src="https://unpkg.com/react-dom@18.3.0/umd/react-dom.production.min.js"></script>
<script src="https://unpkg.com/@babel/standalone@7.26.4/babel.min.js"></script>
</head>
<body>
<c:set var="user" value="신사숙녀여러분"/>
<input type="text" value="${user}"><br>
<input type="text" value="<%=coupon%>">
<div id="box"></div>
<div id="box2"></div>
<div id="box3"></div>
</body>
<script type="text/babel" data-type="module">
	import { a, b } from "./react.js?v=2";		//ECMA와 동일한 import
	var htmlcode = document.getElementById("box");
	//var htmlcode = document.querySelector("#box");
	ReactDOM.render(a(),htmlcode);

	var html2code = document.getElementById("box2");
	ReactDOM.render(b(),html2code);

	var html3code = document.getElementById("box3");
	function c(){
	return(
		
		<div><input type="text" id="user"/></div>
				
		);
	}
	ReactDOM.render(c(),html3code);
</script>
</html>