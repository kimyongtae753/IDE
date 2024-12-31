var host = window.location.host;
console.log(host);


var chat = new StompJs.Client({
	brokerURL : "ws://"+host+"/gs-websocket"
});

//소켓 서버 연결 실패시 출력되는 함수
chat.onWebSocketError = function(error){
	alert("소켓 서버에 연결 실패!!"+error)
}


//메세지를 주고 송 수신 오류 발생
chat.onStompError = function(error){
	alert("메세지 전송 오류!!"+error)
}


//소켓서버 연결 성공시 출력되는 함수
chat.onConnect = function(z){
	setConnect(true);
	alert("소켓 연결 서버 : " +z);
	chat.subscribe("/room/geeting",function(z){
		showmsg(JSON.parse(z.body).content);  //Back-end 해당 메세지를 JSON 형태로 받음
		
	});
}	
	
function showmsg(msg){ //웹에 출력하는 역할
	$("#greetings").append("<tr><td>"+msg+"</td></tr>");
	
}	

function connect(){ // ws에 접속 허가하는 역할
	console.log("test");
	chat.activate();
}	
function disconnection(){ //접속 종료
	chat.deactivate();
	setConnect(false);
	alert("소켓 서버 종료!!");
}
//메세지 주고받는 API경로
function sends(){
	chat.publish({   		//Ajax형태
		destination : "/app/conchat",
		body : JSON.stringify({
			'name':$("#name").val(),
			'msg':$("#msg").val()	
			
		})
		
		
	});
	
	
}


$(function(){		//이벤트 핸들링
	$("form").on('submit', (e) => e.preventDefault());
	$("#connect").click(() => connect());
	$("#disconnect").click(()=>disconnection());
	$("#send").click(function(){
		sends();		//메세지를 전송하는 함수를 작동시킴
	});
});
	

function setConnect(c){
		
		$("#connect").prop("disabled",c);
		$("#disconnect").prop("disabled",!c);
		if(c == true){
			$("#conversation").show();
		}
		else{	
			$("#conversation").hide();
		}
		$("#greetings").html("");	
}