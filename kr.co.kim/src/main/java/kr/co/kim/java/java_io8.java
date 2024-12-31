package kr.co.kim.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//Stream 활용(FileInputStream, FileOutputStream) =>byte
public class java_io8 {

	public static void main(String[] args) {		
		try {
				String url = "C:\\spring\\IDE\\kr.co.kim\\src\\main\\webapp\\data.txt";
				File f = new File(url);
				
				f.createNewFile(); //파일을 생성하는 역할
				
				FileOutputStream fs = new FileOutputStream(f,true);
				
				int w = 1;
				
				while (w <=9 ) {
					int sum = 7* w;
					
					byte[] total = String.valueOf("7x"+w+"="+sum+"\n").getBytes();
					fs.write(total);
					w++;		
					
				}
				
				
				
		}catch (Exception e) {
			System.out.println("파일을 로드하지 못하였습니다.");
			
			
			
		}
		
	}

}


