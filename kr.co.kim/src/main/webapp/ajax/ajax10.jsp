
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%

//가전제품 목록 생성
ArrayList<String> product = new ArrayList<>();
product.add("냉장고");
product.add("세탁기");
product.add("에어컨");
product.add("전자레인지");
product.add("청소기");
product.add("TV");

%>

<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
<title>Javascript - Ajax배열값 넘기기</title>
</head>
<body>
<input type="checkbox" id ="all" onchange="all_select(this.checked)">전체선택<br>
<c:forEach var="pdname" items="<%=product%>" varStatus="idx">
<input type="checkbox" datano="${idx.index}" value="${pdname}" class="pd" onchange="one_select(this.value,this)">${pdname}
<input type="text" class="pdea" value=""><br>
</c:forEach>
<input type="button" value="전송" onclick="ajax()">

</body>
<script>
var pds = document.getElementsByClassName("pd");
var pdsea = document.getElementsByClassName("pdea");
var ps = document.querySelectorAll(".pd");
console.log(ps);


function all_select(z) {
	var ea = "<%=product.size()%>";
	var w = 0;
	while(w < ea){
		
		pds[w].checked = z;		
		w++;
		
	}
	
}



function one_select(pdnm,pdthis) {
	var node = pdthis.getAttribute("datano");
	var pdea = pdsea[node].value;
	if(pdea == ""){
		alert("해당 갯수를 입력해주시기 바랍니다.")
		pds[node].checked = false;		
	}	
}



function ajax(){
	//check된 항목만 배열에 선언
	var arr = [];
	var ww = 0;
	var ea = "<%=product.size()%>";
	while(ww < ea){
		if(pds[ww].checked == true && pdsea[ww].value !==""){		
			arr.push({"pdname":pds[ww].value, "pdea":pdsea[ww].value})
					
		}
		ww++;
				
	}
	console.log(arr);
	
	
	
	
	var html;
	var data;
	html = new XMLHttpRequest();
	html.onreadystatechange = function(){
		if(html.readyState==4 && html.status==200){
		console.log(this.response);
				
		}
	}
	console.log("data" + data);
	html.open("POST","/ajax/product.do",true);
	html.send(JSON.stringify(arr));
	
}

</script>

</html>