export class delete_check{
	
	
	ajax_delete(arr){ //Form 데이터가 되어서 JSON으로는 안된다.
		console.log(arr);
		
		
				fetch("/ECMA/ecma8.do",{
					method : "POST",
					//headers : {"Content-type":"application/x-www-form-urlencoded"}, 
					//body : "list="+arr	//name값 형태
					//headers : {"list":"kim"},
					body : new URLSearchParams(arr)	//Form데이서에 한해서 사용가능하다.
				
				})
					
				.then(function(aa){ //Backend에서 응답을 받아서 값을 처리하는 역할 .json, .xml, .text, .html
					return aa.text();
				})
				.then(function(bb){//결과갑을 출력하는 역할
					console.log(bb);
						})
				.catch(function(error){ //예외처리로 오류 발생시 출력되는 역할
						console.log("통신 오류 발생!");
						})
		
		
		
		
		
		
	}
		
	
	
}