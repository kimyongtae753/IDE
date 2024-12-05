class box{ //클래스
	
		abc(data){
			
			this.msg = data + "님 환영합니다."    //this를 활용하여 해당 메소드에 가상변수
			return this.msg
		}

  		
}


class box2 extends box{ 	//외부 클래스를 해당 클래스로 상속받음
	bbb(user){
		
		this.bx = this.abc(user);
		console.log(this.bx) 
	}
	
	
}


var oc = new box2(); // 클래스를 객체화 하여, 인스턴스로 사용
oc.bbb("홍길동");  	//해당 메소드를 호출

