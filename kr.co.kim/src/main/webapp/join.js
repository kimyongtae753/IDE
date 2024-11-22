
//ajax로 아이디 체크하는 함수
function idcheck(){
	
	
	if(f.mid.value==""){
		alert("아이디를 입력하셔야만 중복체크 하실 수 있습니다.")
		f.mid.focus();
	}
	else{
		
		var data = f.mid.value.replaceAll(" ","");
		
		if(data.length == 0){
			alert("정상적인 아이디를 입력하세요!");
		}
		else{
		var http, result;        //http = 통신 result = 받는값
		http = new XMLHttpRequest();
		http.onreadystatechange = function(){
			if(http.readyState==4 && http.status==200){
				
				
				result = this.response;  //Back-end 전달 해주는 값을 받는 역할
				if(result=="0"){
					alert("해당 아이디는 사용할 수 있습니다.");
				}
				else{
					alert("중복된 아이디 입니다.");
				}
			
				}	
			}
		}
		
		http.open("post","./idcheck.do",true); //해당 Backend 경로로 비동기통신 사용함
			http.setRequestHeader("content-type","application/x-www-form-urlencoded");//POST 전용
			http.send("mid="+f.mid.value);
			
		
	}
	
	
	
	
	
}

//회원가입 버튼 클릭시 작동되는 함수
			function member_check(){
				var pw = document.getElementById("mpass2").value;
				
				if(f.mid.value == ""){
					alert("아이디를 입력하세요")
					return false;
				}//end
	
			    else if(f.mname.value == ""){
					alert("이름을 입력하세요")
					return false;
				
				}//end
	
	
				else if(f.mpass.value == ""){
					alert("패스워드를 입력하세요")
					return false;
				
				}//end
	
	
				else if(f.mpass.value != pw){
					alert("동일한 패스워드를 입력하셔야 합니다")
					return false;
				}//end	 
		
		
			   else if (f.telcorp.value == "") {
			        alert("통신사를 선택해주세요");
			        return false;
			    }//end
		
				var hp1 = document.getElementById("hp1").value;
			    var hp2 = document.getElementById("hp2").value;
			    var hp3 = document.getElementById("hp3").value;

			    f.mhp.value = hp1 + "-"+ hp2 + "-"+ hp3;
			
			  if (hp1.length != 3 || f.mhp.value.length != 13) {
			        alert("휴대폰 번호를 제대로 입력해주십시오." );
			        return false;
			    }//end
				
			  else if (f.memail.value == "") {
				        alert("이메일을 입력해주세요");
				        return false;
				}//end
					
			  else if (f.madrr.value == "") {
					        alert("상세주소를 입력해주세요");
					        return false;
				}//end
		
}


//카카오 도로명 주소

// 우편번호 찾기 찾기 화면을 넣을 element
   var element_wrap = document.getElementById('wrap');

   function foldDaumPostcode() {
       // iframe을 넣은 element를 안보이게 한다.
       element_wrap.style.display = 'none';
   }

   	//도로명 주소 레이어팝업
   function sample3_execDaumPostcode() {
       // 현재 scroll 위치를 저장해놓는다.
       var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
       new daum.Postcode({
           oncomplete: function(data) {
               // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

               // 각 주소의 노출 규칙에 따라 주소를 조합한다.
               // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
               var addr = ''; // 주소 변수
               var extraAddr = ''; // 참고항목 변수

               //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
               if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                   addr = data.roadAddress;
               } else { // 사용자가 지번 주소를 선택했을 경우(J)
                   addr = data.jibunAddress;
               }

             /*  // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
               if(data.userSelectedType === 'R'){
                   // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                   // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                   if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                       extraAddr += data.bname;
                   }
                   // 건물명이 있고, 공동주택일 경우 추가한다.
                   if(data.buildingName !== '' && data.apartment === 'Y'){
                       extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                   }
                   // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                   if(extraAddr !== ''){
                       extraAddr = ' (' + extraAddr + ')';
                   }
                   // 조합된 참고항목을 해당 필드에 넣는다.
                   document.getElementById("sample3_extraAddress").value = extraAddr;
               
               } else {
                   document.getElementById("sample3_extraAddress").value = '';
               }  */

               // 우편번호와 주소 정보를 해당 필드에 넣는다.
               document.getElementById('mpost').value = data.zonecode;
               document.getElementById("mroad").value = addr;
               // 커서를 상세주소 필드로 이동한다.
               document.getElementById("maddr").focus();

               // iframe을 넣은 element를 안보이게 한다.
               // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
               element_wrap.style.display = 'none';

               // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
               document.body.scrollTop = currentScroll;
           },
           // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
           onresize : function(size) {
               element_wrap.style.height = size.height+'px';
           },
           width : '100%',
           height : '100%'
       }).embed(element_wrap);

       // iframe을 넣은 element를 보이게 한다.
       element_wrap.style.display = 'block';
   }








		   

		 
		