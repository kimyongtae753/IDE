package service;

import java.util.List;
import java.util.Map;

import dto.product_dto;

public interface product_service {
	
	List<product_dto> all(Map<String, String> keycode);

}
