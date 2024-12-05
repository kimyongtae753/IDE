

document.querySelector("#btn").addEventListener("click",function(){
	console.log("id 버튼 핸들링");
	new zzz().zbox();
});

document.querySelector(".btn").addEventListener("click",function(){
	console.log("class 버튼 핸들링");
});

//class 선언식 (React, Vue)

var zzz = class box{
	zbox(){ //가상의 메소드
		console.log("연습입니다.");		
		
	}
	
	kbox(v){
		let sum = v +100;
		console.log(sum)
	}
	
	
}

