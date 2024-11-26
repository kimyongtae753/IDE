package kr.co.kim;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.security.MessageDigest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller   //security interface를 로드함
public class security_controller implements security_service{
		
			
	
			@GetMapping("/userpass.do")
			public String userpass() {
				String pw = "dhs99089";
				try {
					StringBuilder result = secode(pw);
					System.out.println(result);
				}catch (Exception e) {
					System.out.println("패스워드 변경 오류");
				}
				
			
				return null;
			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 	@GetMapping("/se1.do")
	 	public String se1() {
	 		String pw = "a123456";
	 		byte pw2[] = pw.getBytes();
	 		//Decoder code = Base64.getDecoder();
	 		Encoder code = Base64.getEncoder();
	 		byte se[] = code.encode(pw2);
	 		String se_pw = new String(se);
	 		
	 		System.out.println(new String(se));
	 		
	 		return null;
	 	}
	 	
	 	@GetMapping("/se2.do")
	 	public String se2() {
	 		String pw = "YTEyMzQ1Ng==";
	 		Decoder dc = Base64.getDecoder();
	 		byte repw[] = dc.decode(pw);
	 		System.out.println(new String(repw));
	 		
	 		return null;
	 	}
	 	
	 	@GetMapping("/se3.do")
	 	public String se3() {
	 		String pw = "a123456";
	 		
	 		try {
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				md5.update(pw.getBytes());
				byte[] repw = md5.digest();
				
				StringBuilder sb = new StringBuilder();
				for(byte w : repw) {
					String word = String.format("%x", w);
					sb.append(word);
					//문자포맷 : %x (소문자+숫자), %X(대문자+숫자)
					//%02X 
				}
				System.out.println(sb);
				
	 			
			} catch (Exception e) {
				System.out.println("해당 문자는 암호화가 불가능 합니다");
			}
	 		
	 		
	 		return null;
	 	}
	 	
	 	
	 	@GetMapping("/se4.do")
	 	public String se4() {
	 		//MD5 < SHA1 < SHA-224 < SHA-256 < SHA-512 < SHA3-224
	 		//a123456 => base64 => MD5
	 		//MD5 => SHA1 => DB저장
	 		try {
	 			String pass = "a123456";
	 			MessageDigest sha = MessageDigest.getInstance("SHA-224");
	 			sha.update(pass.getBytes());
	 			byte[] m = sha.digest();
	 			StringBuilder sb = new StringBuilder();
	 			for(byte w : m) {
	 				String code = String.format("%x", w);
	 				sb.append(code);
	 				
	 			}
	 			System.out.println(sb);
				
			} catch (Exception e) {
				System.out.println("해당 문자는 암호화가 불가능 합니다");
			}
	 		
	 		
	 		
	 		return null;
	 	}
	 	
	 	
	 	
	 	
}
