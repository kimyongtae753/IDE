package kr.co.kim.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//Stream 활용(FileInputStream, FileOutputStream) =>byte
public class java_io7 {

	public static void main(String[] args) {		
		try {
				String url = "C:\\\\spring\\\\IDE\\\\kr.co.kim\\\\src\\\\main\\\\webapp\\\\test";
				File f = new File(url);
				FileInputStream fs = new FileInputStream(url); 
				System.out.println(fs.available());
				//byte word[] = new byte[fs.available()];
				byte word[] = new byte[1024*2]; //1024=1KB 
				fs.read(word); //byte에 있는 배열을 숫자를 모두 읽어들임
				//스트림은 한 번 읽어줘야 한다.
				
				String print = new String(word); //byte => String
				System.out.println(print);
				fs.close();
				
				new fs2().abc();
		}catch (Exception e) {
			
			
			
			
		}
		
	}

}

class fs2{
	public void abc() throws Exception {
		String url = "C:\\spring\\IDE\\kr.co.kim\\src\\main\\webapp\\test.data";
		FileOutputStream fo = new FileOutputStream(url, true);
		String word = "[개인정보 보호 정책] 2024년도에 추가로 개인정보정책이 강화되었습니다 \n";
		
		byte data[] = word.getBytes();
		
		fo.write(data);
		fo.close();
	}
}
