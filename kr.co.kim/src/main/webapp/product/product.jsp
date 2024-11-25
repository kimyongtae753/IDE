<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form id="f" method="post" action="${action}">
상품명 : <input type = "text" name="pmname"><br>
상품가격 : <input type = "text" name="pmmoney"><br>
할인가격 : <input type="text" name="pmsales"><br>
<button type="button" onclick="product_miniok()">상품등록</button>
</form>

</body>

<script>
function product_miniok(){
	f.submit();
} 
</script>
</html>