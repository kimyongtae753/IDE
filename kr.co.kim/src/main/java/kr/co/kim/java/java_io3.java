package kr.co.kim.java;

import static org.hamcrest.CoreMatchers.containsString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

//JABA I/O 종류에 따른 핸들링

/*
 
 Writer, Reader => ASCII
 Stream => 이미지, 동영상, 음악
 
 I/O : Reader, Writer, Stream, StreamReader, WriterStream
  writer(저장, 쓰기) => Stream (OutputStream)
  Reader(읽기) => Stream (InputStream)
 
 */


//WEV I/O => Reader, Writer => BufferedReader, BufferedWriter => 메모리

public class java_io3 {
	
	public static void main(String[] args) throws Exception{
		
		FileReader fr = new FileReader("C:\\spring\\IDE\\kr.co.kim\\src\\main\\webapp\\test.data");
		BufferedReader bf = new BufferedReader(fr);
		System.out.println(bf.readLine());
		
		String line = ""; //Buffered에 있는 데이터값을 문자로 받는 변수
		
		if(bf.readLine() == null) {
			System.out.println("읽을 수가 없써용 ㅠㅜ");
			
		}
		
		while((line=bf.readLine())!=null) {
			System.out.println(line);
			
			
			
		}
		
		
		fr.close();
	}

}
