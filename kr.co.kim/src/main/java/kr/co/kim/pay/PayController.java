package kr.co.kim.pay;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.annotation.Resource;

@Controller
public class PayController {

	//결제시스템 (PG)
	//1.웹페이지가 있어야함
	//2.Copyright => 대표번호, 사업자번호, 통신사업자, 사업자주소, 개인정보책임자
	//3.술, 담배, 사행성 게임, 아이템(x) -> 실물 판매만 가능
	//4.국내PG : KG이니시스, NHN KCP, 토스, 나이스, 카카오페이, 다날(모바일-통신사)
	//5.국외PG : (VISA, MASTER) - Paypal, 스퀘어, 엑심베이, 이노페이, 알리페이, 삼성페이, 애플pay
	
	//-국내 : 2.8%, 3.2%
	//-국외 : 7%
	
	
	@Resource(name="paydto")
	PayDTO dto;
	
	
	@PostMapping("/pay/pay3.do")
	public String pay3(Model m, @ModelAttribute PayDTO dto) {
		System.out.println(dto.getGoodcode());
		System.out.println(dto.getGoodea());
		m.addAttribute("dto", dto);
		return "pay3";
	}
	
	
	@PostMapping("/pay/pay2.do")
	public String pay2(Model m, @ModelAttribute PayDTO dto) {
		m.addAttribute("dto", dto);
		//System.out.println(dto.getPrice());
		System.out.println(dto.getProduct_ea());
		
		
		return "/pay/pay2.html";
	}
	
	
	
	
	@GetMapping("/pay/pay1.do")
	public String pay1(Model m) {
		Random rd =new Random();
		String pgcode ="";
		int a = 0;
		while(a<6) {
			
			pgcode += rd.nextInt(9);
			a++;
			
		}
		
		
		
		//상품코드, 상품명, 상품금액, 상품수량, 총 결제금액이 첫번째 페이지에 표시되어야 한다.
		Map<String, String> paylist = new HashMap();	
		
		paylist.put("pgcode", pgcode);
		paylist.put("product_nm", "아진당 떡상점 화과자 세트");
		paylist.put("product_money", "50000");
		
		m.addAttribute("paylist",paylist);
		
		
		
		
		return "/pay/pay1.html";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
