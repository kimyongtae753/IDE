package kr.co.kim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service  //해당 인터페이스를 로드하면 해당 클래스를 실행시키는 어노테이션입니다.
public class shopping_serviceImpl implements shopping_service {

	@Autowired
	private shopping_query sm;
	
	
	@Override
	public int member_join(member_DTO dto) {
		int result = sm.member_join(dto);
		return result;
	}
	
	@Override
	public String search_id(String mid) {
		String result = sm.search_id(mid);
		return result;
	
		
		
	}
	
}
