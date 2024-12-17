package kr.co.kim;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



//@RestController의 가장 큰 단점은 View JSTL, JSP 로드가 힘듦
@RestController
public class ApiController {
   
   @Resource(name="apidto")
   ApiDTO dto;
   
   @Autowired
   ApiService apiservice;
   
   
   //propaerties의 값을 가져오는 역할을 하는 어노테이션
   @Value("${domain}")
   private String domain;
   
   
   PrintWriter pw;
   
   
   
   @GetMapping("/pr/qrscan.do") // QR을 스캔하여 접속되는 메소드
   public ModelAndView qrscan(@RequestParam(name="scode", required = false) String scode, Model m) {
	
	   
	   ModelAndView mv = new ModelAndView("/pr/qrscan");
	   m.addAttribute("scode",scode);
	   m.addAttribute("username","홍길동");
	   m.addAttribute("delivery",this.domain);
	   
	   	   	   	   
	   	   
	  	   return mv;
   }
   
   
   
   //@ExceptionHandler : @PathVariable한하여 오류 발생시 처리하는 어노테이션
   @ExceptionHandler(MethodArgumentTypeMismatchException.class)
   @PutMapping("/pr/qrmake/{scode}")
   public String qr_api(@PathVariable(name="scode") String scode
		   , HttpServletResponse res, HttpServletRequest req) throws Exception{
	   String url = "http://"+this.domain+":8081/pr/qrscan.do?scode="+scode;
	   int size = 200; //qr이미지 가로 세로 사이즈
	   int asize = 50; //qr이미지 가로 세로 사이즈
	   
	   
	   //code__93 부터는 바코드
	   BitMatrix bm = new MultiFormatWriter().encode(url, BarcodeFormat.CODE_93, size, asize);
	   
	   int qrcolor = 0xFFFF8629;		//QR 색상선택
	   int qrbgcolor = 0xFF000000;	//QR 배경색상
	   //해당 QR생성시 해당 색상을 적용하여 셋팅을 하는 객체
	   MatrixToImageConfig mc = new MatrixToImageConfig(qrcolor, qrbgcolor);
	  
	   //저장 및 이미지를 바로 출력하기 위한 OutputStream
	   ByteArrayOutputStream bs = null;
	   this.pw = res.getWriter();
	   
	   try {
		   
		   bs = new ByteArrayOutputStream();
		   MatrixToImageWriter.writeToStream(bm, "PNG", bs, mc);
		   
		   //QR이미지 저장소
		   String fileurl = req.getServletContext().getRealPath("/qrcode/");
		   //QR 생성 이미지를 해당 경로에 저장
		   FileCopyUtils.copy(bs.toByteArray(), new File(fileurl + scode + ".png"));
		  		   
		   bs.flush();
		   
		   this.pw.print(fileurl + scode + ".png");
		   this.pw.close();
		   
	   }catch (Exception e) {
		   System.out.println(e);
		this.pw.print("error");
		System.out.println("QR라이브러리 생성 오류 발생!!");
	}
	   
	   
	   
	   return null;
   }
   
   
   
   
   
   
   
  
   @GetMapping("/ajax/cdn_fileview/{filenm}")
   public @ResponseBody byte[] cdn_ftp2(@PathVariable String filenm, ServletResponse res) throws Exception {
	   String imgurl = null;
	   
	   
	   
	   imgurl = "http://34.22.72.122/cdn/moomin.jpg"; //DB에 CDN Server 이미지 경로라는 가정
	   byte[] img = null; //Front에서 요청한 이미지 파일명 적용시키는 변수
	   
	   try {
		   URL url = new URL(imgurl);
		   // HttpURLConnection : http
		   //  HttpsURLConnection : https
		   HttpURLConnection httpcon = (HttpURLConnection)url.openConnection();
		   //해당 경로에 있는 파일을 전체 용량을 읽어서 출력하는 역할
		   InputStream is = httpcon.getInputStream();
		   img = IOUtils.toByteArray(is);
		   
		   
		   is.close();	// I/O 종료
		   httpcon.disconnect(); // http프로토콜을 종료
		   
	   }catch (Exception e) {
		   System.out.println("CDN URL연결 실패");
		
		   
	   }
		
	   
	   
	   
	   return img;
  }
   
   
   
   //CDN 서버로 파일 전송
   @PostMapping("/ajax/cdn_fileok.do")
   public String cdn_ftp(@RequestParam(name = "mfile") MultipartFile mfile) {
	   
	   System.out.println(mfile.getOriginalFilename());
	   //34.22.72.122
	   //kim
	   //rladydxo7!
	   //9021
	   FTPClient ftp = new FTPClient(); //외부에서 FTP서버로 접속하는 메소드
	   ftp.setControlEncoding("utf-8"); //FTP 전송 언어셋 
	   FTPClientConfig cf = new FTPClientConfig(); //FTP 환경설정 메소드
	   try {
		   
		   String filenm = mfile.getOriginalFilename(); //사용자가 업로드 하는 파일명을 읽어들임
		   String host = "34.22.72.122";
		   String user = "kim";
		   String pass = "rladydxo7!";
		   int port = 9021;
		   ftp.configure(cf);
		   ftp.connect(host, port);
		   System.out.println(ftp);
		   
		   if(ftp.login(user, pass)) {
			   //FTP.BINARY_FILE_TYPE : 이미지, 동영상, ppt, zip, pdf...
			   //FTP.ASCII_FILE_TYPE : .html, .css, .js, .txt, .jsp
			   
			   ftp.setFileType(FTP.BINARY_FILE_TYPE);
			   ftp.enterLocalPassiveMode();
			   int result = ftp.getReplyCode();
			  
			   
			   
			   /*if(result == 200) { //FTP로 정상적으로 로그인 한 후
				   ftp.makeDirectory("/home/kim/img");	//다토리 생경
				   ftp.removeDirectory("/home/kim/hack"); //디렉토리 삭제
				   
			   }*/

			   if(result == 200) { //FTP로 정상적으로 로그인 한 후
				  // ftp.deleteFile("/home/kim/cdn/moomin");	//파일 삭제				   
				   
			   }
				 
			   
				   //FTP 접속 경로
			   boolean ok = ftp.storeFile("/home/kim/cdn/"+filenm, mfile.getInputStream());
			   
			   System.out.println(ok);
			   
			   if(ok == true) {
				   System.out.println("정상적으로 업로드 되었습니다.");
			   }else {
				   System.out.println("퍼미션 및 FTP 경로가 잘못되었습니다.");
			   }
			   
			   
		   }
		   
	   }catch (Exception e) {
		   
		   System.out.println("FTP 접속 정보가 올바르지 않습니다.");
		   
	   }finally {
		   try {ftp.disconnect();
		   
		   }catch (Exception e) {
			System.out.println("서버 루프가 발생하여 접속이 종료되었습니다.");
		}
	   }
	   
	   

	   return null;
   }
   		
   
   
   
   //@PATCH : 업데이트, @PUT : 데이터 입력, @DELETE : 데이터 삭제, @GET, @POST
  /* 
   @PatchMapping("/ajax/event_update/{eidx}")
  // public String event_update(@PathVariable(name="eidx") String eidx, HttpServletResponse res) {
	   String calldata[] =eidx.split(",");
	   ApiDTO apidto = new ApiDTO();
	  // System.out.println(calldata[0]);
	   //System.out.println(calldata[1]);
	   Map<String, String> map = new HashMap<>();
	  //.setEIDX(Integer.parseInt(calldata[0]))
	   try {
		this.pw = res.getWriter();
	  // int result = apiservice.api_update(map);
	   
	  // System.out.println(result);
	  // if(result.equals("0")) {// 실패
		   this.pw.print("error");
		   
	  // }else {//성공
		   this.pw.print("ok");
		   
	  // }
	  
	   
   //}catch (Exception e) {	  
	  // this.pw.print(e);
  // }finally {
	//   this.pw.close();
	
  // }
	   
	   
	//   return null;
  // }
   */
   @GetMapping("/ajax/event_all")
   public String event_all(HttpServletResponse res) {
	   System.out.println("API연결 확인");
	   try {
			   this.pw = res.getWriter();
			   List<ApiDTO> all = apiservice.api_alldata();
			   System.out.println(all.size());
			   
			   
			   
			   //프론트엔드 : event_member 대표키 각 키별로 데이터 형태의 배열로 api 만들어주세요.
			   JSONObject jo = new JSONObject();
			   jo.put("event_member", false);
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
			   	   
			   this.pw.print(jo); //print는 데이터를 출력할 때
	  
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
   
  
   
   
   
   
   
   
   
   
   
}