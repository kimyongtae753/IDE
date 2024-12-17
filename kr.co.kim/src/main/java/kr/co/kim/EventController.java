package kr.co.kim;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletResponse;


@Controller
public class EventController {

	public static int startno = 1;
	public static int endno = 2;
	
	@Autowired
	EventService es;
	
	@Resource(name="eventDTO")
	EventDTO edto;
	
	PrintWriter pw = null;
	
	
	//이벤트 참여 리스트를 출력 및 페이징 처리
	@GetMapping("/event/event_list2.do")
	public String eventlist(Model m, @RequestParam(value = "pageno", required = false) Integer pageno,
			@RequestParam(value = "part", required = false) String part,
			@RequestParam(value = "search", required = false, defaultValue = "") String search
			) { //intger로 null을 받는다 int는 null을 받을 수 없다.
		
		
		
		
		if(pageno == null) { //uri에 파라미터값이 있을 경우
			this.startno = 1;
			this.endno = 2;
		}else {//uri에 파라미터값이 없는 경우
			this.startno = ((pageno-1)*2)+1;
			this.endno = pageno * 2;
		}
		
		
		//String table_name = "EVENT"; //테이블명 선언
		Map<String, String> smap = new HashMap<>();
		Integer cnt = null;
		List<EventDTO> all = null;
		smap.put("TABLE_NAME", "EVENT");//테이블명 선언
		
		if(!search.equals("")) { //검색어가 있을 경우
			smap.put("part", part);
			smap.put("search", search);
			
			cnt = es.table_count(smap);
			m.addAttribute("toral",cnt);
			
		}else {  //검색어가 을 경우
			System.out.println(2);
			cnt = es.table_count(smap);
			m.addAttribute("toral",cnt);
			
			all = es.event_lists();
			m.addAttribute("all",all);
			
		}
		
		//조건문 잡히는
		//총 데이터 갯수
		//cnt = es.table_count(smap);
		//m.addAttribute("total",cnt);
		
		//데이터 리스트 출력
		//all = es.event_lists();
		//m.addAttribute("all",all);
		
		//사용자가 클릭한 페이지 번호
		m.addAttribute("userpage", this.startno);
		//구조
				
		
		return null;
	}
	@PostMapping("/eventlist2.do")
	public String event_join(@ModelAttribute EventDTO dto, ServletResponse res) {
		res.setContentType("text/html;charset=utf-8");
		
		try {
			this.pw = res.getWriter();
			Integer result = es.event_join(dto);
			
			if(result > 0) {
				this.pw.print("1");
				
			}else {
				this.pw.print("2");
			}
			
		} catch (Exception e) {
			this.pw.print("3");
			
		}finally {
			this.pw.close();
		}
		
	
		return null;
	}
}
