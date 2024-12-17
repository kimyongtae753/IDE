var http; //ajax 통신 변수
var data; //Backend 전달한 값을 받는 변수

http = new XMLHttpRequest();
http.onreadtsonreadystatechange = function(){
	 if(http.readyState == 4 && http.status == 200){
	     data = JSON.parse(this.response);
		 html_view(data);
		 
	   }
	}


http.open("GET","./event_all",false);
http.send();

function html_view(data){
	var hv = document.getElementById("datalist");
	var ea = data["event_member"].length;
	console.log(ea);
	
	var views = "";
	   var w = 0;
	   do{
	      views += `      
	         <tr>
	            <td>`+(ea-w)+`</td>
	            <td>`+data["event_member"][w]["mname"]+`</td>
	            <td>`+data["event_member"][w]["tel_no"]+`</td>
	            <td><input type="text" id="` + data["event_member"][w]["eidx"] + `" value="`+data["event_member"][w]["memail"]+`"></td>
	            <td>`+data["event_member"][w]["event_data"]+`</td>
	            <td>
				<input type="button" value="수정" onclick=member_update('`+data["event_member"][w]["memail"]+`')">
				<input type="button" value="삭제" onclick=member_delete('`+data["event_member"][w]["memail"]+`')">
				</td>
	         </tr>`;
	         w++;
	   }while(w < ea);
	   hv.innerHTML = views;
}

function member_update(eidx){
	var http, data;
	var dataload = document.getElementById(eidx);
	
	var arr = new Array();
	arr[0] = eidx;
	arr[1] = dataload.value;
	
	var patch_data = eidx+","+dataload.value;
	console.log(patch_data)
	
	
	http = new XMLHttpRequest();
	http.onreadtsonreadystatechange = function(){
		 if(http.readyState == 4 || http.status == 200){
		     data = JSON.parse(this.response);
			 html_view(data);
			 
		   }
		}
		http.open("PATCH","./event-update/",+patch_data, false);
		http.getResponseHeader("Content=Type","application/json");
		http.send();
	
}

function member_delete(eidx){
	
}