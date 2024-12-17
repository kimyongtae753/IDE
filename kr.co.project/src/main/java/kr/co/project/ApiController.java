package kr.co.project;

import java.io.PrintWriter;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;


@RestController
public class ApiController {
   
   @Resource(name="apidto")
   ApiDTO dto;
   
   @Autowired
   ApiService apiservice;
   
   
   PrintWriter pw;
   
   //@PATCH : 업데이트, @PUT : 데이터 입력, @DELETE : 데이터 삭제, @GET, @POST
   
   @PatchMapping("/ajax/event_update/{eidx}")
   public String event_update(@PathVariable(name="eidx") String eidx, HttpServletResponse res) {
	   String calldata[] =eidx.split(",");
	   System.out.println(calldata[0]);
	   System.out.println(calldata[1]);
	   
	   
	   return null;
   }
   
   @GetMapping("/ajax/event_all")
   public String event_all(HttpServletResponse res) {
	   System.out.println("API연결 확인");
	   try {
			   this.pw = res.getWriter();
			   List<ApiDTO> all = apiservice.api_alldata();
			   System.out.println(all.size());
			   
			   
			   
			   //프론트엔드 : event_member 대표키 각 키별로 데이터 형태의 배열로 api 만들어주세요.
			   JSONObject jo = new JSONObject();
			   //jo.put("event_member", false);
			   JSONArray ja = new JSONArray(); // 배열[]
			   /*
			   for(ApiDTO data : all) {
				   
				   JSONObject jj = new JSONObject();
				   
				   jj.put("eidx", data.getEIDX());
				   jj.put("mname", data.getMNAME());
				   jj.put("tel_no", data.getTEL_NO());
				   jj.put("email", data.getMEMAIL());
				   jj.put("event_date", data.getEVENT_DATE().substring(0, 10));
				   ja.add(jj);
				   
			   }
			   jo.put("event_member", ja);
			   	   
			   this.pw.print(jo); //print는 데이터를 출력할 때
	  */
	   }catch (Exception e) {	  
		   this.pw.print(e);
	   }finally {
		   this.pw.close();
		
	}
	   
	   
	   
	  return null; 
   }
   
   //GET 배열을 생성 JSONArray, JSONObject
   /*
    * "news" : [
    * ["SK C&C 채용연계 교육생 모집","헤럴드 경제"]
    * ["오픈 AI Chat GTP 먹통","머니 S"]
    * 
    * ]
    */
   
   @GetMapping("/ajax/event_test")
   public String event_test(HttpServletResponse res) {
	   
	   
	   try {
	   this.pw = res.getWriter();
	   List<ApiDTO> all = apiservice.api_alldata();
	   //프론트엔드 : event_member 대표키 각 키별로 데이터 형태의 배열로 api 만들어주세요.
	   JSONObject jo = new JSONObject();
	   //jo.put("event_member", false);
	   JSONArray ja = new JSONArray(); // 배열[]
	   
	   for(ApiDTO data : all) {
		   
		   JSONObject jj = new JSONObject();
		   
		   jj.put("eidx", data.getEIDX());
		   jj.put("mname", data.getMNAME());
		   jj.put("tel_no", data.getTEL_NO());
		   jj.put("email", data.getMEMAIL());
		   jj.put("event_date", data.getEVENT_DATE().substring(0, 10));
		   ja.add(jj);
		   
	   }
	   jo.put("event_member", ja);
	   this.pw.print(jo);
	   
	   
	   
	   this.pw.print(jo); //print는 데이터를 출력할 때
	   
	   this.pw.write("ok"); //write 데이터를 찍어볼 때
	  
	   }catch (Exception e) {
		// TODO: handle exception
		   this.pw.write("no");
	  
	   }finally {
		   this.pw.close();
		
	}
	   
	   
	   
	  return null; 
   }
   
   
   
   
   
   
   
   
   
   
   
}