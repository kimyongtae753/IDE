import React,{useEffect, useState} from "react";

export var NoticeCheck = function(){
   
    function event_check(){
        if(document.getElementById("MEMAIL").value==""){
                alert("이메일 입력 안하나")
        }
        else if(document.getElementById("TEL_NO").value==""){
            alert("전화번호는 무너졌냐")
    }
    //URLSearchParams : 직접 배열값을 설정하여 Backend에 전달하는 형태의 함수
    else{
        fetch("/reactapi/noticecheck",{
            method : "POST",
            headers : {
                'content-type' : 'application/x-www-form-urlencoded'
            },
            body : new URLSearchParams(
                {
                    MEMAIL : document.getElementById("MEMAIL").value,
                    TEL_NO : document.getElementById("TEL_NO").value
                }

            )


//화살표 함수는 즉시실행이라서 사용법을 숙지하고 사용
        }).then((result_data)=>{
                return result_data.text();
        }).then((msg)=>{
            console.log(msg);
        }).catch((error)=>{
            console.log("API 서버 오류");
        });



    }


    }
   
   
   
    return(
        <>
        <p>이벤트 참여 여부 확인</p>
        <span>
            이메일 : <input type="text" id="MEMAIL"/><br/>
            휴대폰번호 : <input type="text" id="TEL_NO" maxLength={11}/><br/>
            <button type="button" onClick={event_check}>조회하기</button>
        </span>
        
        </>
    );



    
}