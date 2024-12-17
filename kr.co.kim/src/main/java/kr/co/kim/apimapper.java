package kr.co.kim;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface apimapper{
	public List<ApiDTO> api_alldata();
	
	public Map<String, Object> api_update(Map<String, Object> map);
}