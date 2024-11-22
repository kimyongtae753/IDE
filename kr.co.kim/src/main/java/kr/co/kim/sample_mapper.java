package kr.co.kim;

import org.apache.ibatis.annotations.Mapper;


//interface는 절대 private를 사용안함
@Mapper
public interface sample_mapper {
	public String datainsert(sample_DTO dto);
}
