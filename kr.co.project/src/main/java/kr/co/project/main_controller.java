package kr.co.project;

import java.io.PrintWriter;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;



@Controller
public class main_controller {

	PrintWriter pw = null;
	
	@Resource(name="notice_DTO")
	notice_DTO nd;
	
	@Autowired
	notice_service ns;
	
	@GetMapping("/notice_delete.do")
	public String notice_delete(@RequestParam String nidx, String key, ServletResponse res) throws Exception {
		res.setContentType("text/html;charset=utf-8");
		this.pw = res.getWriter();
		
		Decoder dc = Base64.getDecoder();
		byte keycheck[] = dc.decode(key);
		String keycode = new String(keycheck);
		if(keycode.equals("kr.co.project")) {
			
			byte nidxcheck[] = dc.decode(nidx);
			String nidxcode = new String(nidxcheck);
			
			int result = ns.noticedel(nidxcode);
			
			if(result>0) {
				this.pw.print("<script>"
						+ "alert('해당 게시물을 정상적으로 삭제하였습니다.');"
						+ "location.href='./notice_list.do';"
						+ "</script>");
				
			}else {
				this.pw.print("<script>"
						+ "alert('해당 게시물을 삭제하지 못했습니다.');"
						+ "location.href='./notice_list.do';"
						+ "</script>");
				
			}
			
			
		}else {
			this.pw.print("<script>"
					+ "alert('해커는 집으로 가세요');"
					+ "history.go(-1)"
					+ "</script>");
			
		}
		
		this.pw.close();
		
		return null;
	}
	
	
	
	
	
	
	//Model jstl 사용시 Responce를 사용하지 못함
	@GetMapping("/notice_list.do")
	public String notice_list(Model m, ServletResponse res) throws Exception {//모델을 썼다는건 jstl을 쓰겠다는 것
		res.setContentType("text/html;charset=utf-8");
		
		
		try {
			//this.pw = res.getWriter();
			List<notice_DTO> all = ns.noticelist();
			m.addAttribute("total", all.size());
			m.addAttribute("all",all);
			
			
		} catch (Exception e) {
			this.pw = res.getWriter();
			this.pw.print("<script>"
					+ "location.href='./test.jsp"					
					+ "</script>");
			this.pw.close();
		}finally {
			
		}		
		
		
		return "notice_list";
	}
}
