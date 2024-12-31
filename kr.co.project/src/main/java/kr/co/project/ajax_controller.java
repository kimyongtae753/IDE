package kr.co.project;

import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;





@Controller
public class ajax_controller {
	
	
	PrintWriter pw = null;
	
	
		//POST 기본으로 name을 적용하여 통신할 경우
	//public String ecma7(@RequestParam("list")String list, HttpServletResponse res) throws Exception {
	
	//POST 기본으로 JSON 형태로 통신할 경우
	@RequestMapping(value="/ECMA/ecma8.do", method = RequestMethod.POST)
	public String ecma8(@RequestParam("data") String data[], HttpServletResponse res) throws Exception {
		ArrayList<String> all = new ArrayList<>(Arrays.asList(data));
		
		System.out.println(all);
		try {
			this.pw = res.getWriter();
			this.pw.print("ok");
			
		}catch (Exception e) {
			this.pw.print("error");
		}finally {
			this.pw.close();
		}
		
				
	return null;	
	}

	
	//ECMA - Ajax - 기본형태, JSON
	@RequestMapping(value="/ECMA/ecma7.do", method = RequestMethod.POST)
	//POST 기본으로 name을 적용하여 통신할 경우
	//public String ecma7(@RequestParam("list")String list, HttpServletResponse res) throws Exception {
	
	//POST 기본으로 JSON 형태로 통신할 경우
	public String ecma7(@RequestBody String list, HttpServletResponse res) throws Exception {
		try {
			this.pw = res.getWriter();
			this.pw.print("ok");
			
		}catch (Exception e) {
			this.pw.print("error");
		}finally {
			this.pw.close();
		}
		
		
		
	return null;	
	}

	
	
	
	
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/ecma/ajax9.do")
	public String ajax9(@RequestParam("email")String email, HttpServletResponse res) {
		try {
			this.pw = res.getWriter();
			System.out.println();
		}catch (Exception e) {
			this.pw.print("error");
		}finally {
			this.pw.close();
		}
		
		
		
	return null;	
	}
}
