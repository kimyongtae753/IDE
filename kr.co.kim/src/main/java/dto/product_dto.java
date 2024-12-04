package dto;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("product_dto")
public class product_dto {

	int pidx;
	String pcate, pcode, pname, pmoney, psales, puse, pdate;
		
	String part, search;
}
