package kr.co.kim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class product_mini_serviceIpm implements product_mini_service{

	@Autowired
	public product_mini_mapper pmm;
	
	@Override
	public int product_mini_insert(product_mini_DTO pmd) {
		int result = pmm.product_mini_insert(pmd);
		return result;
	}
	
	
}
