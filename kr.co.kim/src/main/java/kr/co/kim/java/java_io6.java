package kr.co.kim.java;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class java_io6 {

	public static void main(String[] args) {
		
		try {
			String file1 = "C:\\spring\\IDE\\kr.co.kim\\src\\main\\webapp\\test";
			String file2 = "C:\\spring\\IDE\\kr.co.kim\\src\\main\\webapp\\test.data";
			//Files.copy(new File(file1).toPath(),new File(file2).toPath(),StandardCopyOption.REPLACE_EXISTING);
			
			
			//File f1 = new File(file1);   //파일 경로를 확인 및 가져오는 역할 
			//File f2 = new File(file2);
			
			//Files.copy(f1.toPath(),f2.toPath(),StandardCopyOption.REPLACE_EXISTING);
			
			RandomAccessFile rf = new RandomAccessFile(file1, "r");
			RandomAccessFile rw = new RandomAccessFile(file2, "rw");
			
			//byte 클래스 배열
			FileChannel fc = rf.getChannel();
			
			FileChannel fc2 = rw.getChannel();
			
			//fc.transferFrom 다른 파일의 내용을 해당 파일로 복사
			fc.transferTo(0, fc.size(), fc2);
			
			
		}catch (Exception e) {
		
		}

	}

}
