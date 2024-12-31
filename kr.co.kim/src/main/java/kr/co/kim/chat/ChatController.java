package kr.co.kim.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ChatController {
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@MessageMapping("/conchat")
	@SendTo("/room/geeting")
	public Greeting geeting(ChatDTO dto) throws Exception {
		
		Thread.sleep(1000); //딜레이
		
		String mid = HtmlUtils.htmlEscape(dto.getName());
		String msg = HtmlUtils.htmlEscape(dto.getMsg());
		
		System.out.println(dto.getName());
		System.out.println(dto.getMsg());
		
				
		
		return new Greeting(mid + ":" + msg);
	}

}
