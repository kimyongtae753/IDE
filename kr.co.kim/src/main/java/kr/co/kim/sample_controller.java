package kr.co.kim;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class sample_controller {

	@Autowired 
	private sample_service ss;
	
	@Resource(name="sampledto")
	private sample_DTO sdto;
	
	
	PrintWriter pw = null;
	
	
	@PostMapping("/sampleok.do")
	public String sampleok(@ModelAttribute("sample") sample_DTO sdto, HttpServletResponse res) {                               //(@ModelAttribute("sample") sample_DTO sdto) 세터가 됨
		res.setContentType("text/html;charset=utf-8");
		try {
			this.pw = res.getWriter();
			//insert, update, delete 최종결과를 무조선 int로 받아야 Exception에 걸리지 않음
			String result = ss.datainsert(sdto);
			
		}catch (Exception e) {
			this.pw.print("<script>"
					+ "alert('DB 오류');"
					+ "history.go(-1)"
					+ "</script>"
					);
			
			
			
			
		} finally {
			this.pw.close();
			
		}
		
		
		
		
		
		return null;
	}
	
	
}
