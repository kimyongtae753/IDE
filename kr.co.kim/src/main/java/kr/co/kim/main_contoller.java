package kr.co.kim;

import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import okhttp3.Request;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class main_contoller implements security_service{
	
	
	@Resource(name="memberdto")
	member_DTO dto;
	
	
	
	@Autowired
	private shopping_service ss; //interface를 최종 호출
	
	PrintWriter pw = null;
	HttpSession se = null;
	//장바구니 페이지
	
	@GetMapping("/basket.do")
	public String basket(Model m) {
				
		m.addAttribute("id",this.se.getAttribute("id"));
		m.addAttribute("name",this.se.getAttribute("name"));
		m.addAttribute("email",this.se.getAttribute("email"));
		
		return null;
		
	}
	
	
	
	
	//메인페이지
	@GetMapping("/main.do")
	public String main(Model m) {
					
		m.addAttribute("id",this.se.getAttribute("id"));
		m.addAttribute("name",this.se.getAttribute("name"));
		m.addAttribute("email",this.se.getAttribute("email"));
		
		return null;
	}
	
	
	
	@PostMapping("/loginok.do")
	public String loginok(@RequestParam String mid, String mpass, String idsave, ServletResponse res, HttpServletRequest req) throws Exception {
	List<member_DTO> mdto = ss.login_id(mid);
	res.setContentType("text/html;charset=utf-8");
	this.pw = res.getWriter();
	this.se = req.getSession();
	
	if(mdto.size() == 0) {//만약에 해당 DTO에 해당 내용이 없을 경우
		System.out.println("값없음");
		
	}else {
		StringBuilder repass = secode(mpass);
		
		if(mdto.get(0).mpass.equals(repass.toString())) {
			HttpSession se = req.getSession();
			
			se.setAttribute("id", mdto.get(0).mid);
			se.setAttribute("name", mdto.get(0).mname);
			se.setAttribute("email", mdto.get(0).memail);
			System.out.println(idsave);
			//체크박스같은 null코드는 먼저 쓰는것이 좋습니다.
			if(idsave==null) {
				
				this.pw.print("<script>"
						+ "window.localStorage.removeItem('mid');"
						+ "</script>");
				
			}else {
				
				this.pw.print("<script>"
						+ "window.localStorage.setItem('mid','"+mid+"');"
						+ "</script>");
				
			}
			
			
			
			pw.print("<script>"
					+ "alert('로그인 되었습니다.');"
					+ "location.href='./main.do';"
					+ "</script>"
				    );
			
			
		}else {
			pw.print("<script>"
					+ "alert('비밀번호가 틀렸습니다.');"
					+ "history.go(-1)';"
					+ "</script>"
				    );
			
		}
		
	}
			this.pw.close();
		return null;
	}
	
	
	
	@PostMapping("/joinok.do")
	public String joinok(@ModelAttribute("join") member_DTO dto, HttpServletResponse res) throws Exception {
		
		res.setContentType("text/html;charset=utf-8"); //script 한글깨짐 방지
		PrintWriter pw =null;
		
		
		//setter에 신규값을 갱신하는 조건문
		if(dto.getMagree1()==null) {
			dto.setMagree1("N");  // getMagree1()이 null일 경우 "N"으로 설정
			System.out.println(dto.getMagree1());
		}
		if(dto.getMagree2()==null) {
			dto.setMagree2("N");  // getMagree2()이 null일 경우 "N"으로 설정
			System.out.println(dto.getMagree2());
		}
		
		
		String passwd = dto.getMpass();
		StringBuilder repass = secode(passwd);
		dto.setMpass(repass.toString());
		
		
		
		
		
		int result =ss.member_join(dto);
		
		try {
		 pw = res.getWriter();
		
		if(result > 0) { pw.print("<script>"
					+ "alert('데이터 오류로 인하여 가입이 되지 않습니다.');"
					+ "location.href='./login.html';"
					+ "</script>"
				    );
		}else {
			
			pw.print("<script>"
					+ "alert('아이디 및 휴대폰 번호 중복으로 인하려 회원가입이 되지 않습니다.');"
					+ "history.go(-1);"
					+ "</script>"
				);
		}
		 
		 
		
		}
		
		catch (Exception e) {
			
				
				
			
			
		}finally {
			
		}
		
		return null;
	}
	
	

	
	//아이디 중복체크
	@CrossOrigin("*") //도메인이 바뀌어도 작동하게 해준다
	@PostMapping("/idcheck.do")
	public String idcheck(@RequestParam String mid, HttpServletResponse res) throws Exception {
	
		
		PrintWriter pw = res.getWriter();
		
		String result="ok"; //프론트에게 전달할 변수
		
		if(mid.equals("")) {
			System.out.println("값이 없음");
		}
		
		else {
			//DB의 값을 검토
			result = ss.search_id(mid);
			
			System.out.println(result);
			pw.print("ok");
			pw.close();
		}
		
		
		
		return null;
	}
	
	
	
	
	
	
	
	

}
