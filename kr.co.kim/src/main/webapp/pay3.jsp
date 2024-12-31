<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.inicis.std.util.SignatureUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="goodcode" value="${dto.goodcode}"/>
<c:set var="price" value="${dto.price}"/>
<%
String mid = "INIpayTest";
String signKey = "SU5JTElURV9UUklQTEVERVNfS0VZU1RS";
String goodcode = (String)pageContext.getAttribute("goodcode"); 

String mKey = SignatureUtil.hash(signKey, "SHA-256");
String timestamp = SignatureUtil.getTimestamp();
String orderNumber = mid + "_" + goodcode;	
String price = pageContext.getAttribute("price").toString();


Map<String, String> signParam = new HashMap<String, String>();
signParam.put("oid", orderNumber);
signParam.put("price", price);
signParam.put("timestamp", timestamp);

String signature = SignatureUtil.makeSignature(signParam);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 및 결제 최종 정보 확정으로 결제 시스템 API 연동완료!!</title>

</head>
<script src="https://stgstdpay.inicis.com/stdjs/INIStdPay.js"></script>
<body>
<form id="frm">
<input type="hidden" name="version" value="1.0"> <!-- api 버전 -->
<!-- 결제 수단 -->
<input type="hidden" name="gopaymethod" value="${dto.gopaymethod}">
<!-- PG에 제공받은 아이디 -->
<input type="hidden" name="mid" value="<%=mid%>">
<!-- 상품명 -->
<input type="hidden" name="goodname" value="${dto.goodname}">
<!-- 상품코드 및 아이디 결합 값 -->
<input type="hidden" name="oid" value="<%=orderNumber%>">
<!-- 결제 금액 -->
<input type="hidden" name="price" value="${dto.price}">

<input type="hidden" name="timestamp" value="<%=timestamp%>">
<!-- 결제 금액 단위 -->
<input type="hidden" name="currency" value="WON">
<!-- 결제 비밀번호 key -->
<input type="hidden" name="mKey" value="<%=mKey%>">
<!-- 결제 정보에 대한 암호화 코드 -->
<input type="hidden" name="signature" value="<%=signature%>">
<!-- 결제자 정보 -->
<input type="hidden" name="buyername" value="${dto.buyername}">
<!-- 결제자 연락처 -->
<input type="hidden" name="buyertel" value="${dto.buyertel}">
<!-- 결제자 이메일 -->
<input type="hidden" name="buyeremail" value="${dto.buyeremail}">
<!-- 우편번호 -->
<input type="hidden" name="rec_post" value="${dto.rec_post}">
<input type="hidden" name="rec_way" value="${dto.rec_way}">
<input type="hidden" name="rec_addr" value="${dto.rec_addr}">

<input type="hidden" name="returnUrl" value="http://192.168.10.149/:8081/return_url.jsp" >
<input type="hidden" name="closeUrl" value="http://192.168.10.149/:8081/close.jsp" >



<p>--------상품정보---------</p>

상품코드 : ${dto.goodcode } <br>
상품명 : ${dto.goodname } <br>
상품갯수 : ${dto.goodea} <br>

<p>--------결제자정보---------</p>

결제자명 : ${dto.buyername } <br>
연락처 : ${dto.buyertel } <br>
이메일 : ${dto.buyeremail } <br>

<p>--------배송정보---------</p>

수령 우편번호 : ${dto.rec_post } <br>
도로명 주소 : ${dto.rec_way } <br>
상세주소 : ${dto.rec_addr } <br>

<p>--------결제금액 및 결제수단---------</p>

최종 결제금액 : ${dto.price }<br>
결제수단 : ${dto.gopaymethod }<br>


<input type="button" value="결제하기" onclick="payok()">
</form>
</body>
</html>
<script>
function payok() {
	INIStdPay.pay("frm");
	
}
</script>
