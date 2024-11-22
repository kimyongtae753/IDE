package kr.co.kim;

import java.io.PrintWriter;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class main_contoller {
	
	
	@Resource(name="memberdto")
	member_DTO dto;
	
	
	
	@Autowired
	private shopping_service ss; //interface를 최종 호출
	
	
	@PostMapping("/joinok.do")
	public String joinok(@ModelAttribute("join") member_DTO dto, HttpServletResponse res) {
		
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
