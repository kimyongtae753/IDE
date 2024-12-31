package kr.co.kim.react;

import java.io.PrintWriter;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.kim.EventDTO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ReactController {
	
	@Resource(name="eventDTO")
	EventDTO dto;
	
	PrintWriter pw = null;
	
	
	
	@PostMapping("/reactapi/noticecheck")
	public String noticecheck(@RequestParam(value = "MEMAIL", required = false) String MEMAIL,
			@RequestParam(value = "TEL_NO", required = false) String TEL_NO,
			HttpServletResponse res) {
		try {
			this.pw =res.getWriter();
			
			
			System.out.println(MEMAIL+":"+TEL_NO);
			this.pw.print("ok");				
		} catch (Exception e) {
		
			this.pw.print("error");
		}finally {
		
			this.pw.close();
		}
		
		
		return null;
	}
	
	
	
	
	
	@GetMapping("/restapi/noticewriter")
			public String noticewriter(@ModelAttribute EventDTO dto, HttpServletResponse res) {
			
		try {
			this.pw = res.getWriter();
			//Oracle DB 저장
			
			
			System.out.println(dto.getADD_POST());
			this.pw.print("ok");
		} catch (Exception e) {
			this.pw.print("error");
			
		}finally {
			this.pw.close();
		}
		
		
		return null;
	}
}
