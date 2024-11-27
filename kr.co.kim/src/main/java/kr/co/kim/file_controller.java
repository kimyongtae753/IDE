package kr.co.kim;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class file_controller {
	
	PrintWriter pw = null;
	
	//복합 파일 전송
	
	@PostMapping("/fileupok4.do")
	public String fileupok4(ServletResponse res, ServletRequest req, @RequestParam("mfile") List<MultipartFile> files) throws Exception {
		
		this.pw = res.getWriter();
		res.setContentType("text/html;charset=utf-8");
		
		int fileno = files.size(); //파일의 개수
		String url = req.getServletContext().getRealPath("/payfile/");
		int w = 0;
		
		while(w < fileno) {
			
			String oriname = files.get(w).getOriginalFilename();
			String types = oriname.substring(oriname.lastIndexOf("."));
			String filetype = files.get(w).getContentType();
			System.out.println(filetype);
			//UUID 암호화 알고리즘 클래스(Spring 전용)
			
			//UUID : version1 (PC - Macaddress 형태로 암호화)
			//UUID : version3 (MD5, hash)
			//UUID : version4 (Random)
			//UUID : version5 (SHA-1합수 이용)
			
			String uuid = UUID.randomUUID().toString();
			String newname = url + uuid + types;
			//UUID uuid3 = UUID.nameUUIDFromBytes(oriname.getBytes());
			if(files.get(w).getContentType().equals("")){
			FileCopyUtils.copy(files.get(w).getBytes(), new File(newname));
			}
			w++;
		}
		this.pw.print("<script>"
				+ "alert('파일이 정상적으로 등록되었습니다.'); "
				+ "history.go(-1);"
				+ "</script>");
		
		
		
		return null;
	}
	
		
	
	
	
	@PostMapping("/fileupok3.do")
	public String fileupok3(HttpServletRequest req, HttpServletResponse res, @RequestParam("mfile") MultipartFile files[]) throws Exception {
		
		this.pw = res.getWriter();
		res.setContentType("text/html;charset=utf-8");
		
		//파일 저장 경로
		String url = req.getServletContext().getRealPath("/upload/");
		int w = 0;
			
		//이름 변경하여 저장
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHms");
		String ymd = df.format(today); 
		
		//이름은 변경하여 저장하지만 db에는 오리지널 네임이 들어간 테이블도 함께 만들어서 사용자가 보기에는 오리지널 파일 네임으로 볼 수 있게 합니다.
		
		
		while(w < files.length) {
			
			String mm = files[w].getOriginalFilename().substring(files[w].getOriginalFilename().lastIndexOf("."));
			
			if(files[w].getSize() > 5242880) {
				this.pw.print("<script>"
						+ "alert('5MB 이하의 파일만 등록할 수 있습니다.'); "
						+ "history.go(-1);"
						+ "</script>");
				
				return null;
			}
			
			if(!mm.equals(".xml")) {
				this.pw.print("<script>"
						+ "alert('xml 파일만 등록할 수 있습니다.'); "
						+ "history.go(-1);"
						+ "</script>");
				
				return null;
				
			}
					
			
			
			if(!files[w].getOriginalFilename().equals("")) {
				int no = (int)Math.ceil(Math.random()*1000);
				
				System.out.println(files[w].getOriginalFilename().substring(files[w].getOriginalFilename().lastIndexOf("."))); //getOriginalFilename(); 는 string이기 때문에 substring이 사용가능하다.
																														// 파일명은 사람.jpg 처럼 한글명이 들어가면 서버에서 깨지기 때문에 숫자로 변환시켜줘야한다.
				
				String nm = files[w].getOriginalFilename().substring(files[w].getOriginalFilename().lastIndexOf("."));
				String rename = ymd + no + nm; //날짜 + 랜덤변수 + 파일속성까지 합쳐서 파일명이 안겹치게 해준다.
				FileCopyUtils.copy(files[w].getBytes(), new File(url + rename));  //
			}				
			
			w++;
			
		}
		this.pw.print("<script>"
				+ "alert('정상적으로 파일이 등록되었습니다.'); "
				+ "history.go(-1);"
				+ "</script>");
		
		
		
				
		return null;
	}
	
	
	@PostMapping("/fileupok2.do")
	public String fileupok2(HttpServletRequest req, HttpServletResponse res, @RequestParam("mfile") MultipartFile files[]) throws Exception {
		
		this.pw = res.getWriter();
		res.setContentType("text/html;charset=utf-8");
		
		//파일 저장 경로
		String url = req.getServletContext().getRealPath("/upload/");
		int w = 0;
		
		//이름 변경하여 저장
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHms");
		String ymd = df.format(today); 
		
		//이름은 변경하여 저장하지만 db에는 오리지널 네임이 들어간 테이블도 함께 만들어서 사용자가 보기에는 오리지널 파일 네임으로 볼 수 있게 합니다.
		
		
		while(w < files.length) {
			
			
			
			if(!files[w].getOriginalFilename().equals("")) {
				int no = (int)Math.ceil(Math.random()*1000);
				
				System.out.println(files[w].getOriginalFilename().substring(files[w].getOriginalFilename().lastIndexOf("."))); //getOriginalFilename(); 는 string이기 때문에 substring이 사용가능하다.
																														// 파일명은 사람.jpg 처럼 한글명이 들어가면 서버에서 깨지기 때문에 숫자로 변환시켜줘야한다.
				
				String nm = files[w].getOriginalFilename().substring(files[w].getOriginalFilename().lastIndexOf("."));
				String rename = ymd + no + nm; //날짜 + 랜덤변수 + 파일속성까지 합쳐서 파일명이 안겹치게 해준다.
				FileCopyUtils.copy(files[w].getBytes(), new File(url + rename));  //
			}				
			
			w++;
			
		}
		this.pw.print("<script>"
				+ "alert('정상적으로 파일이 등록되었습니다.'); "
				+ "history.go(-1);"
				+ "</script>");
		
		
		
				
		return null;
	}
	
	
	
	
	
	
	//단일 파일 전송
	@PostMapping("/fileupok1.do")
	public String fileupok1(@RequestParam("mfile") MultipartFile files, HttpServletResponse res, HttpServletRequest req) throws Exception {
		
		this.pw = res.getWriter();
		res.setContentType("text/html;charset=utf-8");
		
		String filenm = files.getOriginalFilename();
		long filesize = files.getSize();
		String filetype = files.getContentType();
		System.out.println(filenm);
		System.out.println(filesize);
		System.out.println(filetype);
		
		//프로퍼티스에서 파일 용량을 제한 걸어버리면(2mb) 제한을 넘는 파일을 첨부했을 시 서버가 죽어버린다.
		//그렇기에 프로퍼티스에서는 한 번에 올리는 용량을 최대로 늘리고 조건문으로 제약을 걸어버리는것.
		if(filesize > 2097152) {
			
			this.pw.print("<script>"
					+ "alert('첨부파일 용량은 최대 2MB까지만 등록 가능합니다.'); "
					+ "history.go(-1);"
					+ "</script>");
		
		}else {//첨부파일 image 또는 압축파일, pdf, xls, doc 허용 = 이것들 외의 파일 .java, .jsp, php, .asp, .ini 파일들은 해킹의 위험이 있어서 첨부할 수 없게 해야한다.
			
			if(filetype.equals("image/jpeg") || filetype.equals("image/png") || filetype.equals("image/gif") || filetype.equals("image/bmp") ) {
					
				System.out.println("이미지 맞음");
					String url = req.getServletContext().getRealPath("/upload/");
					File fe = new File(url+filenm); //경로 + 기존파일명
					byte bt[] = files.getBytes(); //바이트는 무조건 배열 써주자
					FileCopyUtils.copy(bt, fe);
					
					System.out.println(url);
					
					this.pw.print("<script>"
							+ "alert('정상적으로 파일이 등록되었습니다.'); "
							+ "history.go(-1);"
							+ "</script>");			
					
					
			}else {
				
				this.pw.print("<script>"
						+ "alert('이미지 파일만 등록 가능합니다.'); "
						+ "history.go(-1);"
						+ "</script>");				
			}
			
		}
		
		this.pw.close();
		
		return null;
	}

}
