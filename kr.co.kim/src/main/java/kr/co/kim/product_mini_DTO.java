package kr.co.kim;

import org.springframework.stereotype.Repository;

import lombok.Data;


@Data
@Repository("product_mini_dto")
public class product_mini_DTO {

	int pmidx, pmmoney, pmsales;
	String pmname, pmdate;
}
