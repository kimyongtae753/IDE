export class email_check{
	
//Apache => Nginx	
		
	ajax_email(email){
		fetch("./ajax9.do?email="+email)
		.then(function(aa){
			return aa.text();
		})
		.then(function(bb){
			console.log(bb);
				})
		.catch(function(error){
				console.log("통신 오류 발생!");
				})
	
			
		
	}
		
	
}