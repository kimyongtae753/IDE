export class tels{ // 클래스 선언 기본 메소드
	
	constructor(){
		console.log("즉시 실행 되는 메소드");
		
	}
	
	tel_check(){
		this.tel1 = document.querySelector("#tel1").value;
		this.tel2 = document.querySelector("#tel2").value;
		this.tel3 = document.querySelector("#tel3").value;
		this.total = this.tel1+this.tel2+this.tel3;
		if(this.total.length < 10){
			alert("휴대폰 번호를 모두 입력해 주셔야 합니다.")
		}
		else{
			alert("인증번호가 발송 되었습니다.");
		}	
		
	}
	
	
}