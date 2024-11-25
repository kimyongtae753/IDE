package kr.co.kim;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("notice_dto")
public class notice_DTO {

		int nidx;
		String nsubject, nwriter, npass, ntext, ndate;
	
}
