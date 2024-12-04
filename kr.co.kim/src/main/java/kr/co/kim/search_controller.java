package kr.co.kim;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import dto.product_dto;
import jakarta.annotation.Resource;
import service.product_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@ComponentScan(basePackages = {"dto","service","serviceimp"})
@Controller
public class search_controller {
	
	@Resource(name="product_dto")
	product_dto dto;
	
	@Autowired
	product_service ps;
	
	@PostMapping("/search.do")
	public String search(product_dto dto) {
		Map<String, String > keycode = new HashMap<>();
		keycode.put("part",dto.getPart());
		keycode.put("search",dto.getSearch());
		List<product_dto> all = ps.all(keycode);
		
		System.out.println(all.get(0).getPcode());
		System.out.println(all.get(0).getPname());
		
		return null;
	}
	
	

}
