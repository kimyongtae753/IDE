import React,{} from "react";
import {Link} from "react-router-dom";
import './App.css';


export var Top = function(){
    return(
        <header>
            <nav>
                   <span className="spancss"> <Link to="/noticeList">이벤트 리스트</Link></span>
                   <span className="spancss"><Link to="/noticeWriter">이벤트 참여하기</Link></span>
                   <span className="spancss"><Link to="/noticeCheck">이벤트 참여여부 확인</Link></span>

            </nav>
        </header>
    );
}