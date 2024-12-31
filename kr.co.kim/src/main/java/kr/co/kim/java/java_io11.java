package kr.co.kim.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.input.ReaderInputStream;

//InputSteamReader, OutputStreamWriter (변환을 주로 하는 클래스)
//InputStream => InputStreamReader => BuffredReader
//BufferedReader => InputStreamReader => InputStream

//FileOutputStream => OutputstreamWriter => BufferedWriter
public class java_io11 {
	

	
	public static void main(String[] args) throws Exception {
		String url = "C:\\spring\\IDE\\kr.co.kim\\src\\main\\webapp\\test.data";
		/*
		InputStream is = new FileInputStream(url);
		System.out.println(is.available());
		//Buffered의 성격을 가지고 있으므로 read를 사용하는 순간 데이터를 loss가 발생 시작함
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr); //여기까지는 ASCII
		System.out.println(br.readLine());
		br.close();
		isr.close();
		is.close();
		*/
		//Reader[String] => Stream[Byte]
		FileReader fr = new FileReader(url);
		System.out.println(fr);
		BufferedReader br2 = new BufferedReader(fr);
		System.out.println(br2);
		InputStream is2 = new ReaderInputStream(br2);
		System.out.println(is2.available());
		is2.close();
		br2.close();
		fr.close();
		
		
	
		
	}

}
