package kr.co.kim.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;

//이미지를 복사
public class java_io9 {

	/*public static void main(String[] args) throws Exception{
		String img = "C:\\spring\\IDE\\kr.co.kim\\src\\main\\webapp\\moomin.jpg";
		
		FileInputStream fs = new FileInputStream(img);
		byte by[] = new byte[fs.available()];
		fs.read(by);
		
		String cpimg = "C:\\spring\\IDE\\kr.co.kim\\src\\main\\webapp\\moomin1.jpg";
		FileOutputStream os = new FileOutputStream(cpimg);
		os.write(by);
		os.close();
		fs.close();
		
		}
		*/
		
		
	public static void main(String[] args) throws Exception{
		String img = "C:\\spring\\IDE\\kr.co.kim\\src\\main\\webapp\\moomin.jpg";
		
		FileInputStream fs = new FileInputStream(img);
		byte by[] = new byte[fs.available()/100];
		fs.read(by);
		
		String cpimg = "C:\\spring\\IDE\\kr.co.kim\\src\\main\\webapp\\moomin1.jpg";
		FileOutputStream os = new FileOutputStream(cpimg);
		
		int i = 0;
		int check = 0;
		while(true) {
			
			i=fs.read(by);
			if(i == -1) {
				break;
			}
			else {
				
			os.write(by,0,i);
			
			}
			check++;
			if(check % 2 == 0) {
				System.out.println(check+"%");
			}
		}
	
		
		os.close();
		fs.close();
	
	}

}
