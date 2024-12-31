package kr.co.kim.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.apache.commons.io.output.WriterOutputStream;

//OutputStream => Writer
//Writer => OutputStream
public class java_io12 {

		public static void main(String[] args) throws Exception{
			
			String url = "C:\\\\spring\\\\IDE\\\\kr.co.kim\\\\src\\\\main\\\\webapp\\\\test.data";
			
			/*
			String msg = "그 사람이 좋은데/ 이상하게 그 사람은 다 좋은데/ 나에게 보내야 할 것을 보내지 않는다";
			
			OutputStream os = new FileOutputStream(url);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.append(msg);
			bw.flush();      //Buffered 메모리 비우는 작업
			bw.close();
			osw.close();
			os.close();
				*/
			String msg = "그 사람이 좋은데/ 이상하게 그 사람은 다 좋은데/ 나에게 보내야 할 것을 보내지 않는다";
			FileWriter fw = new FileWriter(url);
			BufferedWriter bw = new BufferedWriter(fw);
			OutputStream os2 = new WriterOutputStream(bw);
			os2.write(msg.getBytes());
			os2.close();
			os2.flush(); //Buffered 메모리 비우는 작업
			bw.close();
			fw.close();
			
			
		}
	
}
