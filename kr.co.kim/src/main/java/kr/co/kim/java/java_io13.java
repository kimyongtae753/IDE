package kr.co.kim.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import org.apache.commons.io.output.WriterOutputStream;

//응용문제
/*
  
 Scanner를 이용하려 고객 이메일을 입력시킬 시 
 
 */
public class java_io13 {

	
	public static void main(String[] args) throws Exception{
		
		
		String url = "C:\\spring\\IDE\\kr.co.kim\\src\\main\\webapp\\member.txt";
		
		
		 // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);
        
        // 사용자로부터 메시지 입력 받기
        System.out.println("메시지를 입력하세요:");
        String msg = scanner.nextLine(); // 사용자 입력을 msg에 저장
		
        File file = new File(url);
        
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("파일이 생성되었습니다: " + url);
        }
		
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		OutputStream os2 = new WriterOutputStream(bw);
		os2.write(msg.getBytes());
		os2.flush(); //Buffered 메모리 비우는 작업
		os2.close();
		
		//bw.close();
		//fw.close();
		
		PrintWriter pw = new PrintWriter(url);
		pw.write(msg);
		pw.close();
		
		
	}
	
	
}
