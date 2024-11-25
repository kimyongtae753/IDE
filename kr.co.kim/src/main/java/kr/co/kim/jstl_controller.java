package kr.co.kim;

import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class jstl_controller {

	
	
	@GetMapping("/jstl6.do")
	public String jstl6(Model m) {
		String menu = "대메뉴 출력 파트!!";
		m.addAttribute("menu1",menu);
		
		
		return null;
		
	}
	/*
	 응용문제
	 다음 배열 데이터의 값을 이용하여 웹 페이지에 출력되도록 코드를 작성하시오
	 {"홍길동","강감찬","이순신","유관순","김유신"}
	 {"25","30","27","44","37"}
		
		해당 데이터를 다음과 같이 출력하시오
		홍길동 : 25
		강감찬 : 30
		이순신 : 27
		유관순 : 44
		김유신 : 37
		
		*긴급수정 : 사용자 리스트 중에서 30살 이상 되는 고객만 리스트 출력
		
		응용문제 : jstl9.do로 실행하여 jstl9.jsp 결과값 출력
		다음 배열의 대한 전체 합계를 출력하는 코드를 작성하시오
		{100,112,256,241,11,16,39,42,56,118,78}
	  
	 */
	
	
	
	@GetMapping("/jstl7.do")
	public ModelAndView jstl7() {
		ModelAndView mv = new ModelAndView(); // 클래스 인스턴스 = 객체;
		String product = "LG 냉장고";
		
		
		mv.addObject("pdname",product); //키이름으로 데이터값을 이관하여 => .jsp에 출력시키기 위함
		mv.setViewName("/jstl8"); //jsp view 파일명을 지정
		
		
		ArrayList<String> al = new ArrayList<>();
		al.add("홍길동");
		al.add("강감찬");
		al.add("이순신");
		al.add("유관순");
		al.add("김유신");
		
		ArrayList<String> old = new ArrayList<>();
		old.add("25");
		old.add("30");
		old.add("27");
		old.add("44");
		old.add("37");
		
		
		ArrayList<ArrayList<String>> ad = new ArrayList<ArrayList<String>>();
		
		 for(int z = 0; z <al.size(); z++){
			   ArrayList<String> redata =new ArrayList<String>(); 
			   
			   redata.add(al.get(z));
			   redata.add(old.get(z));	  
			   ad.add(redata);
		   }
		
		mv.addObject("ad", ad);
		
		ArrayList<ArrayList<String>> ad2 = new ArrayList<ArrayList<String>>();
		ad2.add(new ArrayList<>(Arrays.asList("홍길동", "25")));
		ad2.add(new ArrayList<>(Arrays.asList("강감찬", "30")));
		ad2.add(new ArrayList<>(Arrays.asList("이순신", "27")));
		ad2.add(new ArrayList<>(Arrays.asList("유관순", "44")));
		ad2.add(new ArrayList<>(Arrays.asList("김유신", "37")));
		
		mv.addObject("ad2", ad2);
		
		
		return mv;    //이 경우 페이지 값은 null과 같아서 겟매핑에 지정된 페이지를 절대 바꿀 수 없다.
	}
	
	@GetMapping("/jstl8.do")
	public ModelAndView jstl8() {
		ModelAndView mv = new ModelAndView(); // 클래스 인스턴스 = 객체;
	
		ArrayList<ArrayList<String>> userdata = new ArrayList<ArrayList<String>>();
		
		
		ArrayList<String> menu = new ArrayList<>();
		menu.add("아이디");
		menu.add("고객명");
		menu.add("이메일");
		menu.add("나이");
		menu.add("연락처");
		menu.add("주소");
		
		ArrayList<String> data = new ArrayList<>();
		data.add("hong");
		data.add("홍길동");
		data.add("hong@nate.com");
		data.add("35");
		data.add("010-2233-4507");
		data.add("서울 특별시 종로3가 국일빌딩");
		
		mv.addObject("data",data);
		mv.addObject("menu",menu);
		
		
		
		
		
		
		return mv;    //이 경우 페이지 값은 null과 같아서 겟매핑에 지정된 페이지를 절대 바꿀 수 없다.
	}
	
	/*
	 * 
	 * */
	
}
