package kr.co.kim.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

//이미지를 복사
public class java_io10 {
		
	public static void main(String[] args) throws Exception{
		
		String url = "C:\\spring\\IDE\\kr.co.kim\\src";
		File f = new File(url);
		File all_list[] = f.listFiles();
		System.out.println(Arrays.asList(all_list));
		
		String filename = all_list[0].getName();
		System.out.println(filename);
		
		int n = filename.lastIndexOf("."); //.마지막 "." 기준으로 위치를 파악하는 코드
		String att = filename.substring(n);
		System.out.println(att);
	
	
	}

}
