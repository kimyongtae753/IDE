
import React,{} from 'react'; //리액트에서 사용되는 모든 라이브러리를 쓰겠다는 말
import {Route,Routes} from 'react-router-dom';
import {Top} from './Top' //상단메뉴
import { NoticeWriter } from './NoticeWriter'; //이벤트 참여
import {NoticeCheck} from './NoticeCheck'; 
function App() {
  
  return (
 <>
 <Top/>

<Routes>
  <Route path="/NoticeList" element=""></Route>
  <Route path="/NoticeWriter" element={<NoticeWriter/>}></Route>
  <Route path="/NoticeCheck" element={<NoticeCheck/>}></Route>
</Routes>

 </>
  );
}

export default App;
