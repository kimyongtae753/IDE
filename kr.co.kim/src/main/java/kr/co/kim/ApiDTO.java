package kr.co.kim;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("apidto")
public class ApiDTO {
   Integer EIDX;
   String COUPON_NO, MNAME, MEMAIL, TEL_CORP, TEL_NO;
   String ADD_POST, ADD_LOAD, ADD_ADDRESS, SMS, EMAIL, EVENT_DATE;
}
