function fileview(z){
   var reader = new FileReader();//바이트 단위로 객체를 새롭게 생성
   
   
   reader.onload = function(e){//해당 페이지가 로드 되었을 때 실행되는 함수
	//해당 아이디에 src <img> 태그 이므로
	close.log(e);
		
	//document.getElementById("views").src = e.target.result;
      document.getElementById("views").src = e.srcElement.result;
   };
   //첨부 파일의 실제 경로를 로드하려 출력하는 형태.
   reader.readAsDataURL(z.files[0]);
   
}


//CDN API로 파일전송
function cdn_file(){
	document.getElementById('frm').submit();
	
	
	

}