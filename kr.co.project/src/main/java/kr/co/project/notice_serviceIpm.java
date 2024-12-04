package kr.co.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class notice_serviceIpm implements notice_service {

	
			@Autowired
			notice_mapper notice_mapper;
	
	
			@Override
			public List<notice_DTO> noticelist() {
				
				List<notice_DTO> notice_DTO =  notice_mapper.noticelist();
				
				
				return notice_DTO;
			}
			
			@Override
			public int noticedel(String nidx) {
			
				int result = notice_mapper.noticedel(nidx); 
				
			return result;
			}
			
		@Override
		public int noticein(notice_DTO ndto) {
			 int result = notice_mapper.noticein(ndto);
		return result;
		}
}
