package serviceimp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.product_dto;
import service.product_service;

@Service
public class product_serviceimp implements product_service{
	
	
	 @Autowired
	   kr.co.kim.mapper.product_mapper product_mapper;

	
	@Override
	public List<product_dto> all(Map<String, String> keycode) {
		
		 List<product_dto> all = product_mapper.all(keycode);
		return all;
	}
	

}
