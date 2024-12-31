package kr.co.kim.chat;

import lombok.Data;

@Data
public class ChatDTO {

		public String name, msg; //이름, 메세지
		
		
		public ChatDTO(){
			
			
		}
		
		public ChatDTO(String name, String msg){
			this.name = name;
			this.msg = msg;
		}
		
		
}
