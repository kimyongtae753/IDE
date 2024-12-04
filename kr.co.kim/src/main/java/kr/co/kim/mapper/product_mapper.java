package kr.co.kim.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import dto.product_dto;


@Mapper
public interface product_mapper {
	
	List<product_dto> all(Map<String, String> keycode);

}
