package kr.co.kim;

import java.util.List;
import java.util.Map;

public interface EventService {

		Integer event_join(EventDTO dto);
		Integer table_count(Map<String, String> smap);
		public List<EventDTO> event_lists();
	
}
