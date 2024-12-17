package kr.co.kim;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface EventMapper {
	
	Integer event_join(EventDTO dto);
	Integer table_count(Map<String, String> smap);
	
	List<EventDTO> event_lists(Map<String, String> pg);
	
	
}
