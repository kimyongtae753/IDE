package kr.co.kim;



import org.springframework.stereotype.Component;

import lombok.Data;

//스프링 부트에서 사용하는 Data 어노테이션
@Component("memberdto")
@Data    //Getter, Settet, Hash, 즉시실행, tostring()
public class member_DTO {

	int midx;
	String mid, mpass, mname, telcorp, mhp, memail, mpost, mroad, maddr, magree1, magree2, mjoin;
}
