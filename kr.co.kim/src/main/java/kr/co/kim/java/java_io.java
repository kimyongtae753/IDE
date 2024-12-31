package kr.co.kim.java;

import java.io.FileReader;
import java.util.Scanner;

//JABA I/O 종류에 따른 핸들링

/*
 
 Writer, Reader => ASCII
 Stream => 이미지, 동영상, 음악
 
 I/O : Reader, Writer, Stream, StreamReader, WriterStream
  writer(저장, 쓰기) => Stream (OutputStream)
  Reader(읽기) => Stream (InputStream)
 
 */



public class java_io {
	
	public static void main(String[] args) {
		
		
		try {
			//FileReader : 기본 단어를 한개씩 읽어들이는 형태
			FileReader fr = new FileReader("C:\\spring\\IDE\\kr.co.kim\\src\\main\\webapp\\test");
			Scanner sc = new Scanner(fr);
			
			
			while(sc.hasNext()) {
				int m = fr.read();
				String word = sc.nextLine();
				System.out.println(word);
									
			}
			fr.close();
			
		} catch (Exception e) {
		System.out.println("해당 파일이 없습니다.!!");
			
			
		}
		
	}

}
