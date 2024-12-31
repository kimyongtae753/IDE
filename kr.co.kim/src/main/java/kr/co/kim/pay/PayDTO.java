package kr.co.kim.pay;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("paydto")
public class PayDTO {
	String product_code,product_nm,product_money,product_ea;
	
	//이니시스에서 필요한 name형태의 값
	String goodcode, goodname, goodea, goodprice;
	String buyername, buyertel, buyeremail, rec_way, rec_addr, rec_post;
	String gopaymethod;
	Integer price;

}
