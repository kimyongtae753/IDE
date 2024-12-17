function cdn_file(){
	var myfile = document.getElementById("mfile");
	var ajax; //ajax 통신 변수
	let formdata = new FormData(); //form 형태의 태그를 이용함
	formdata.append("mfile",myfile.files[0]); //첫번째 파일을 mfile키명으로 등록
	
	ajax = new XMLHttpRequest();
	ajax.onreadystatechange = function(){
		if(ajax.readyState==4 && ajax.status ==200){
			console.log(this.response);
			
		
		}else{
			alert("통신오류 발생!");
		}
		
		
	}
	
	ajax.open("POST", "./cdn_fileok.do",true);
	ajax.send(formdata); //form에 있는 데이터를 Backend로 전송
	
}