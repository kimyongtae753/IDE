package kr.co.kim;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class notice_controller {

	PrintWriter pw;
	
	//DTO 파일 로드
	@Resource(name="notice_dto")
	notice_DTO nd;

	@Autowired
	notice_service ns;
	
	
	@GetMapping("/notice/notice_list.do")
	public String notice_list() {
		
		
		return null;
	}
	
	
	
	@PostMapping("/notice/notice_writeok")
	public void notice_writeok(@ModelAttribute("nt") notice_DTO nd, HttpServletResponse res) throws Exception {
		
		res.setContentType("text/html;charset=utf-8");
		this.pw = res.getWriter();
	 
		int result = ns.notice_insert(nd);
		if(result > 0) {
			this.pw.print("<script>"
					+ "alert('정상적으로 등록 완료 되었습니다.');"
					+ "location.href='./notice_list.do';"
					+ "</script>");
		}else {
			this.pw.print("<script>"
					+ "alert('시스템 오류로 인하여 중지 되었습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		this.pw.close();
		
		
	}

	@GetMapping("/notice/notice_write.do")
	public String notice_write(Model m) {
		//setAttribute, getAttribute
		m.addAttribute("user", "관리자" );
		m.addAttribute("action", "writeok.do" );
		return null; //view notice_write.jsp
	}
	
	
	
}
