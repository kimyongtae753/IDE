<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ajax파일전송</title>
</head>
<body>
<form id="frm" method="post" enctype="multipart/form-data">
사진 이미지 파일 전송 : <input type="file" name="mfile" accept="image/*" capture="camera"><br>
<input type="button" value="전송" onclick="fileup1()">
<br><br><br>
동영상 전송 : <input type="file" name="mfile2" accept="video/*" capture="camcoder"><br>
<input type="button" value="전송" onclick="fileup2()">
<br><br><br>
동영상 전송 : <input type="file" name="mfile3" accept="audio/*" capture="microphone"><br>
<input type="button" value="전송" onclick="fileup3()">
</form>
<script>
	function fileup1() {
		frm.action = "./hpfile1.do";
		frm.submit();
	
	}
	function fileup2() {
		frm.action = "./hpfile2.do";
		frm.submit();

		
	}
	function fileup3() {
		frm.action = "./hpfile3.do";
		frm.submit();

	
	}


</script>

</body>
</html>