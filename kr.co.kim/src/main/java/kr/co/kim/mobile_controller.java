package kr.co.kim;

import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.print.attribute.standard.SheetCollate;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class mobile_controller {
   
   @Autowired
   mobile_service ms;
   
   
   
   @Resource(name="file_DTO")
   file_DTO fdto;

   PrintWriter pw = null;   //javascript
   Date date = new Date();      //오늘 날짜
   SimpleDateFormat si = new SimpleDateFormat("yyyyMMddhhmmss");   //새로운 파일명
   Random random = new Random();   //랜덤 숫자 하나 선택
   
   //@RequestPart : 필수가 아닌 선택으로 파일첨부 또는 값을 받는 형태
   //@RequestParam : 필수로 무조건 파일첨부 또는 값을 받는 형태
   
   @PostMapping("/excel_uploadok.do")
   public String excel_uploadok(@RequestPart(value = "mfile", required = false) MultipartFile files, HttpServletRequest req, HttpServletResponse res) throws Exception {
	   res.setContentType("text/html;charset=utf-8");
	   
	   //String url = req.getServletContext().getRealPath("/payfile/");
	   
	   int sign = 0;
	   
	   InputStream is = files.getInputStream();
	   
	   //XLSX,XLS를 읽어들이는 코드
	   Workbook workbook = WorkbookFactory.create(is);
	   
	   //EXCEL 시트를 가져와서 핸들링하는 코드
	   Sheet sheet = workbook.getSheetAt(0);
	   
	   //전체 row갯수를 파악
	   Iterator<Row> rows = sheet.iterator();
	   
	   while(rows.hasNext()) {//값이 있는 행을 반복문으로 모두 체크
		   Row row = rows.next();//값이 없는 행을
		   Iterator<Cell> cell = row.cellIterator();
		   if(row.getRowNum() > 0) {
			   
			   while(cell.hasNext()) {
				   Cell ce = cell.next();
				   System.out.println(ce.toString());
			   }
			   
			   
		   }
		   
	   }
	   
	   
	   
	   
	   return "/Excel_uplode";
   }
   
   
   
   @GetMapping("/event_list.do")
   public String event_list(Model m) {
	     
	   
	   List<file_DTO> all = ms.list_image();
	   m.addAttribute("ea", all.size()); //데이터 총 갯수
	   m.addAttribute("all",all); //데이터 내용
	   
	   
	   return "/event_list";
   }
   
   @PostMapping("/event_del.do")
   public String event_del(@RequestParam String eidx , HttpServletResponse res, HttpServletRequest req) {
	   res.setContentType("text/html;charset=utf-8");
	   
	   try {
		this.pw = res.getWriter();
		String result = ms.search_image(eidx);
	   
		//Path url =Paths.get("/mobile/"+result);
		String url = req.getServletContext().getRealPath("/mobile/");
		File fe = new File(url+result);
		fe.delete();
		
		int result2 = ms.delete_image(eidx);
		if(result2 > 0) {
			this.pw.write("<script>"
	                  + "alert('이미지 첨부 최대 크기는 5MB입니다.');"
	                  + "location.href='./event_list.do';"
	                  + "</script>");
			
		}
		   
	   }catch (Exception e) {
		   this.pw.write("<script>"
	                  + "alert('이미지 첨부 최대 크기는 5MB입니다.');"
	                  + "location.href='./event_list.do';"
	                  + "</script>");
	
	}finally {
		this.pw.close();
	}
	   
	   return null;
   }
   
   
   
   
   
   @PostMapping("/hpfile3.do")
   public String hpfile3() {
      
      return null;
   }
   
   @PostMapping("/hpfile2.do")
   public String hpfile2(@RequestParam("mfile") MultipartFile files, ServletRequest req, ServletResponse res) {
	   res.setContentType("text/html;charset=utf-8");
	   
	   
      return null;
   }
   
   
   
   
   //모바일 사진 이미지 : 용량 제한(10mb), 캠코더 : 시간제약 (100MB), 음성 : 50MB
   @PostMapping("/hpfile1.do")
   public String hpfile1(@RequestParam("mfile") MultipartFile files, ServletRequest req, ServletResponse res) {
      res.setContentType("text/html;charset=utf-8");
      try {
         this.pw = res.getWriter();
         
         String filenm = files.getOriginalFilename();
         long filesize = files.getSize();
         //파일 업로드 제한 용량 5242880 byte(=5MB)
         if(filesize > 5242880) {
            this.pw.print("<script>"
                  + "alert('이미지 첨부 최대 크기는 5MB입니다.');"
                  + "history.go(-1);"
                  + "</script>");
         } else {
            //Database에 저장 및 웹 디렉토리에 저장
            //이미지가 저장되는 경로
            String url = req.getServletContext().getRealPath("/mobile/");
            //파일 속성 타입을 가져오는 코드(확장자)
            String type = filenm.substring(filenm.lastIndexOf("."));
            //신규 파일명 직접 랜덤으로 생성 -1 난수 생성
            int no = random.nextInt(40)+1;   //1~40
            //신규 파일명 생성 -2 날짜
            String new_nm = si.format(date);
            //해당 디렉토리에 파일을 업로드 시킴
            FileCopyUtils.copy(files.getBytes(), new File(url + new_nm + no + type));
            
            //해당 URL 경로를 DB에 저장시킴 - 원본명, 사본명, 저장경로)
            fdto.setMfile_ori(filenm);   //사용자가 업로드한 원본 파일명
            fdto.setMfile_new(new_nm + no + type);   //개발자가 원본 파일명을 다른 이름으로 변경
            fdto.setMfile_url("./mobile/");
            
            int result = ms.insert_image(fdto);
            if(result > 0) {
               this.pw.print("<script>"
                     + "alert('정상적으로 이벤트에 참여하셨습니다.');"
                     + "location.href='./event_list.do';"
                     + "</script>");
            }
            else {
            	this.pw.print("<script>"
            	         + "alert('이미지 저장에 실패했습니다.');"
            	         + "history.go(-1);"
            	         + "</script>");
               
            }
         }
         
      } catch (Exception e) {
         this.pw.print("<script>"
               + "alert('이미지 저장에 따른 서비스가 불안정합니다.');"
               + "history.go(-1);"
               + "</script>");
      } finally {
         this.pw.close();
      }
      
      return null;
   }
}
