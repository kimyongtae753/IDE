package kr.co.kim;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface product_mini_mapper {
	int product_mini_insert(product_mini_DTO pmdto);
}
