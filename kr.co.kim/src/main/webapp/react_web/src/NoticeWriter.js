import React,{useState} from "react";
import { useDaumPostcodePopup } from "react-daum-postcode";

export var NoticeWriter = function(){
    //우편번호 및 도로명 주소를 담는 배열값
    const [posts, post_data] = useState('');
    const [roads, road_data] = useState('');

    const [sms_check, sms] = useState('Y');
    const [email_check, email] = useState('Y');

    //배열 형태의 checkbox
    const [ckbox,ckboxno] = useState([]); // 배열 형태로 체크박스에 있는 값을 저장형태


    
    //외부서버에 있는 js를 로드하여 API를 활용함
    var open =useDaumPostcodePopup("https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js");
   
   //우편번호, 주소를 input에 전달하는 함수
    var address = function(data){
        post_data(data.zonecode);
        road_data(data.readAddress);

        console.log(data);
    }
    //도로명 주소를 팝업창으로 오픈
    var post = function(){
        open({onComplete:address});

    }
    

    function put_ajax(){
        if(document.getElementById("coupon_no").value == ""){
            alert("쿠폰 번호를 입력해라");
            document.getElementById("coupon_no").focus();
        }
        else if(document.getElementById("add_post").value == ""){
            alert("주소를 입력해라");
        }
        else{
            let fd = new FormData(); //form 전송
            fd.append("COUPON_NO",document.getElementById("coupon_no").value);
            fd.append("MNAME",document.getElementById("mname").value);
            fd.append("MEMAIL",document.getElementById("memail").value);
            fd.append("TEL_CORP",document.getElementById("tel_corp").value);
            fd.append("TEL_NO",document.getElementById("tel_no").value);
            fd.append("ADD_POST",document.getElementById("add_post").value);
            fd.append("ADD_LOAD",document.getElementById("add_lode").value);
            fd.append("ADD_ADDRESS",document.getElementById("add_address").value);
            fd.append("sms_check");
            fd.append("email_check");

            console.log(sms_check);
            
            fetch('/restapi/noticewriter',{
                method : 'PUT',
                body : fd
            }).then(function(result){
                return result.text(); //API회신내용 문자

            }).then(function(msg){
                if(msg == "ok"){
                    alert("이벤트 참여가 완료되었데이")
                }
                else{
                    alert("아이고 서비스 오류가 발생했다카이")
                }
            }).catch(function(error){
                console.log(error);
            })
            
        }
    }
    //HTML 코드에서 onChange 클릭시 해당 useState 함수 setter 함수에 값을 이관
    function smsfn(z){
        sms(z.target.value);

    }
    function emailfn(z){
        email(z.target.value);

    }

return(
<>
<dl>
    <dt>이벤트 참여하기</dt>
    <dd>쿠폰번호 : <input type="text" id="coupon_no"/></dd>
    <dd>고객명 : <input type="text" id="mname"/></dd>
    <dd>이메일 : <input type="text" id="memail"/></dd>
    <dd>통신사 :
        <select id="tel_corp">
            <option value="">통신사 선택</option>
            <option value="SKT">SKT</option>
            <option value="KT">KT</option>
            <option value="LGT">LGT</option>
            <option value="알뜰폰">알뜰폰</option>
        </select>
    </dd>
    <dd>연락처 : <input type="text" id="tel_no"/></dd>
    <dd>우편번호 : <input type="text" id="add_post" readOnly maxLength={5} value={posts}/></dd>
    <button type="button" onClick={post}>주소찾기</button>

    <dd>도로명 : <input type="text" id="add_lode" readOnly value={roads}/></dd>
    <dd>상세주소 : <input type="text" id="add_address"/></dd>
    
    <dd>SMS 수신여부 : <input type="radio" name="sms" value="Y" defaultChecked onChange={smsfn}/>동의함
    <input type="radio" name="sms" value="N" onChange={smsfn}/>동의안함</dd>
    <dd>Email 수신여부 : <input type="radio" name="email" value="Y" defaultChecked onChange={emailfn}/>동의함
    <input type="radio" name="email" value="N" onChange={emailfn}/>동의안함</dd>
    
</dl>
<br/><br/>
<input type="button" value="이벤트 참여" onClick={put_ajax}/>
</>

);


}