package kr.co.kim.thymeleaf;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;


@Controller
public class ThymeleafController {
	
	@Resource(name ="ThymeleafDTO")
	ThymeleafDTO tdto;
	
	
	
	@GetMapping("/datalist.do")
	public String datalist(Model m) {
				
		List<String> all = new ArrayList<>();
		all.add("JAVA");
		all.add("HTML");
		all.add("JSP");
		m.addAttribute("all",all);
		
		Map<String, String> member = new HashMap<>();
		member.put("mid", "apink");
		member.put("mname", "에이핑크");
		member.put("memail", "apink@gmail.");
		
		m.addAttribute("member",member);
		
		//DTO를 이용하여 출력
		tdto.setUidx(10);
		tdto.setUserid("hong");
		tdto.setUsernm("홍길동");
		
		m.addAttribute("info",tdto);
		
		//이벤트 참여 여부
		String agree = "N";
		m.addAttribute("agree" , agree);	
		
		//근무현황
		String work = "대기";
		m.addAttribute("work", work);
				
		return "/datalist.html";
	}
	
	//src/main/weep View
	@GetMapping("/leaf3.do")
	public String leaf3(Model m) {
		
		String data = "JSP + JSTL 출력!!";
		m.addAttribute("data",data);
		
		
		return "WEB-INH/view/dolleaf3";		//templates 경로에 leaf2/jsp 잦음 만약 null
	}
	
	
	
	
	//templates View
	@GetMapping("/leaf2.do")
	public String leaf2(Model m) {
		
		String data = "JSP +타임리프 출력!!";
		m.addAttribute("data",data);
		
		
		return "/leaf2";		//templates 경로에 leaf2/jsp 잦음 만약 null
	}
	
	
	
	@GetMapping("/leaf.do")
	public String leaf(Model m) {
		java.util.Date dt = new java.util.Date();
		m.addAttribute("date", dt);
		
		
		return "/leaf.html";
	}
	
	
	
	
	//실제 메인화면
	@GetMapping(value={"/mainpage.do","/login.do","/sample.do"})
	public String mainpage(Model m, HttpServletRequest req) {
		//System.out.println(req.getServletPath());
		String copyright = "Copyright @ 2024 Maker By abc.co.kr All Reserved.";
		m.addAttribute("copyright",copyright);
		
		Map<String, String> mdlist = new HashMap<String, String>();
		mdlist.put("productnm", "삼성 냉장고");
		mdlist.put("money", "680,000");			
		m.addAttribute("mdlist",mdlist);
		
		List<String> board = new ArrayList<String>();
		board.add("공지사항1");
		board.add("공지사항2");
		board.add("공지사항3");
		board.add("공지사항4");
		
		m.addAttribute("board",board);
		
		String webpage = req.getServletPath().replace(".do", "");
		
		
		return "/"+webpage+".html";
	}
	
	
	
	
	
	@GetMapping("/subpage.do")
	public String subpage(Model m) {
		String copyright = "Copyright @ 2024 Maker By abc.co.kr All Reserved.";
		m.addAttribute("copyright",copyright);
		
		
		return "/subpage.html";
	}
	
	
	
		@GetMapping("/layout.do")
		public String layout(Model m) {
			String copyright = "Copyright @ 2024 Maker By abc.co.kr All Reserved.";
			m.addAttribute("copyright",copyright);
			
			Map<String, String> mdlist = new HashMap<String, String>();
			mdlist.put("productnm", "삼성 냉장고");
			mdlist.put("money", "680,000");			
			m.addAttribute("mdlist",mdlist);
			
			List<String> board = new ArrayList<String>();
			board.add("공지사항1");
			board.add("공지사항2");
			board.add("공지사항3");
			board.add("공지사항4");
			
			m.addAttribute("board",board);
			
			
			return "/layout.html";
		}
		
}
