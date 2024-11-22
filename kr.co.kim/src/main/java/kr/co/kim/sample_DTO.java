package kr.co.kim;

import org.springframework.stereotype.Repository;

import lombok.Data;



@Data
@Repository("sampledto")
public class sample_DTO {
	
	int sidx;
	String subject, stext, sdate;
	
	
}
