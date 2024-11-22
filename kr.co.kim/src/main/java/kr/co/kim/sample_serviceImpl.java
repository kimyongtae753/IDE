package kr.co.kim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sample_serviceImpl implements sample_service {
	
	@Autowired // 매퍼와 연결함
	private sample_mapper sm;
	
	@Override
	public String datainsert(sample_DTO dto) {
		String result = sm.datainsert(dto);
		return result;
	}
	
}
