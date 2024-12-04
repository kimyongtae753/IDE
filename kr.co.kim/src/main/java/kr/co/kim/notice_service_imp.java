package kr.co.kim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class notice_service_imp implements notice_service {

		@Autowired
		public notice_mapper nm;
	
	
		@Override
		public int notice_insert(notice_DTO nd) {
			int result = nm.notice_insert(nd);
			return result;
		}
		
		@Override
		public int noticein(notice_DTO nd) {
		int result = nm.noticein(nd);
		return result;
		}
}
