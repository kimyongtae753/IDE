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
public class product_mini_controller {

	PrintWriter pw;
	
	@Resource(name="product_mini_dto")
	product_mini_DTO pmd;
	
	@Autowired
	product_mini_service pms;
	
	
	@PostMapping("/product/product_miniok.do")
	public void product_miniok(@ModelAttribute("pm") product_mini_DTO pmd, HttpServletResponse res) throws Exception {
		
		res.setContentType("text/html;charset=utf-8");
		this.pw = res.getWriter();
	 
		int result = pms.product_mini_insert(pmd);
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
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/product/product.do")
	public String product_write(Model m) {
		//setAttribute, getAttribute
		m.addAttribute("action", "/product/product_miniok.do" );
		return null; //view notice_write.jsp
	}
	
}
