var max = 0;

function file_plus(){
	// 새로운 파일 입력 요소 생성
	
		
	if(max==0){
		
	  // 새 줄 추가
	  var newLine = document.createElement("p");
	  newLine.innerHTML = '첨부파일 : <input type="file" name="mfile" onchange="maxfile(this)"><input type="button" value="ㅡ" onclick="file_del()">';
	  	  	  
	  // 박스에 추가
	  document.getElementById("box").appendChild(newLine);
		  	
		max++;
	}
	
	else if(max>=1 && max < 2){
		
		var newLine = document.createElement("p");
		  newLine.innerHTML = '첨부파일 : <input type="file" name="mfile">';
		  	  	  
		  // 박스에 추가
		  document.getElementById("box").appendChild(newLine);
			  	
			max++;		
	}
	else{
		alert('첨부할 파일을 더 추가하실 수 없습니다.');
		return false;
		}
	
	
	
}//file_plus()

function file_del(){
	
	var box = document.getElementById("box");
	var a = box.getElementsByTagName("p");
	
	if(max > 0){
		box.removeChild(a[a.length - 1]); // 마지막 <p> 태그 제거
		max--; // 현재 파일 입력 필드 개수 감소		
	}else {
	return false;
		
	}
	
	
}

	


function fileup(){
	
	
	
	frm.submit();
	
	
}