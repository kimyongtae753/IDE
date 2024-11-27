<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여러개의 File 전송</title>
</head>
<body>
<form id="frm" method="post" action="./fileupok2.do" enctype="multipart/form-data">
<p>파일 전송</p>

<!-- 파일을 이런 식으로 각각 네임을 주면 실력없는 백앤드입니다. 
파일 첨부 : <input type="file" name="mfile1"><br>
파일 첨부 : <input type="file" name="mfile2"><br>
파일 첨부 : <input type="file" name="mfile3"><br>
-->

<!--
파일 첨부 : <input type="file" name="mfile"><br>
파일 첨부 : <input type="file" name="mfile"><br>
파일 첨부 : <input type="file" name="mfile"><br>
 같은 이름이면 배열로 들어가기 때문에 0, 1, 2로 변환된다. -->

파일 첨부 : <input type="file" name="mfile" onchange="maxfiles(this)" multiple="multiple"><br> *첨부파일은 최대 3개까지 가능합니다.<br>
<input type="button" value="전송아닙니다" onclick="fileup()">
<input type="button" value="전송" onclick="fileup2()">
</form>


</body>
<script>
function maxfiles(z) {
	var max = 3;
	if(z.files.length > max){
		alert('첨부파일 최대 3개까지만 입력이 가능합니다.')
		frm.mfile.value = "";
	} //files = 파일.. 크흠
	
	if(z.files.size >= 838860800){
		alert('첨부파일은 최대 100mb까지만 가능합니다.')
		frm.mfile.value = "";
	} //files = 파일.. 크흠
	
}

function fileup2() {

	frm.submit();
}


function fileup(){
	var count = 0; // r4 w2 x1 이것처럼 첫번째를 4 두번째를 2 첫번째를 1로 둬보자
	var w = 0;
	
	while(w < 3){
	if(frm.mfile[w].value!=""){
		if(w == 0){
			count = count + 4;
	
			}
			else if (w == 1) {
			count = count + 2;
			}	
			else if (w == 2) {
			count = count + 1;
			}
			
			}
			w++;
	}

			if(count == 4 || count == 6 || count == 7){
				frm.submit();
			}
			else {
				alert("파일 첨부는 순서에 맞게 입력하셔야 합니다.");
				return false;
			}
		
		
	  
}
</script>
</html>