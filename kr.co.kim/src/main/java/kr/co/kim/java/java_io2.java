package kr.co.kim.java;

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



public class java_io2 {
	
	public static void main(String[] args) {
		
		try {
		String user[] = {"kim","jung","lee","그 사람이 좋은데, 그 사람은 다 좋은데 나에게 보내야 할 것을 보내지 않는다. 나는 그에게 지속적으로 미숙한 항의를 했다"};
		FileWriter fw = new FileWriter("C:\\spring\\IDE\\kr.co.kim\\src\\main\\webapp\\test.data");
		
		for(int f=0; f< user.length; f++) {
			fw.write(user[f]);
			
		}
		
		
		fw.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
