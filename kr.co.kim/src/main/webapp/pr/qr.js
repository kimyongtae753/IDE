function qrmake(){
	
	var html;
	var data = document.getElementById("scode");
	if(data.value == ""){
		alert("주문번호를 입력하세요");
	}
	else{
		
		html = new XMLHttpRequest();
		html.onreadystatechange = function(){
			if(html.readyState == XMLHttpRequest.DONE && html.status == 200){
				if(this.responseText != "error"){
					document.getElementById("qrview").append(this.responseText);
					document.getElementById("qrimg").src=this.responseText;
					
					
				}
				
				console.log(this.response)
				
				
			}
			
		}
		
		
	}
	
	html.open("PUT","./qrmake/"+data.value, true);
	html.send();
	
	
}