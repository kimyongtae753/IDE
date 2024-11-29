package kr.co.kim;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface mobile_mapper {
	
	public int insert_image(file_DTO dto);
	public List<file_DTO> list_image();
	public int delete_image(String eidx);
	public String search_image(String eidx); //한 개의 데이터에 한 개의 컬럼만 가져올 경우(아니라면 DTO를 활용하시죠)

}
