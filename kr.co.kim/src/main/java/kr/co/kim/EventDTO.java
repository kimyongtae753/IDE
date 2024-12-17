package kr.co.kim;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("eventDTO")
public class EventDTO {
	
		Integer EIDX;	//Oracle number 자료형일 경우 int 대신 Integer
		String COUPON_NO, MNAME, MEMAIL, TEL_CORP, TEL_NO, ADD_POST, ADD_LOAD, ADD_ADDRESS;
		String SMS, EMAIL, EVENT_DATE;
	

}
