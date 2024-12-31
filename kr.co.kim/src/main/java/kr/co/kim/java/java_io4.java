package kr.co.kim.java;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//Files 로 해당 내용을 저장하는 형태 방식 
//자신의 디스크에서 실행 시 \\를 두번 사용한다/ Files (nio) => Web(X) => \\경로 입력시
//(io)
public class java_io4 {

	public static void main(String[] args) throws Exception {
		

			List<String> data = Files.readAllLines(Paths.get("C:\\spring\\IDE\\kr.co.kim\\src\\main\\webapp\\test.data"));
				System.out.println(data);
				
				byte[] data2 = Files.readAllBytes(Paths.get("C:\\spring\\IDE\\kr.co.kim\\src\\main\\webapp\\test.data"));
				System.out.println(data2);
				System.out.println(new String(data2));
				System.out.println(data2.toString());
	}

}
