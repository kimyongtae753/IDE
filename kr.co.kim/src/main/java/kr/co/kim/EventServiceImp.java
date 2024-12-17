package kr.co.kim;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImp implements EventService {
	
	@Autowired
	EventMapper em;

	@Override
	public Integer event_join(EventDTO dto) {
		Integer result = em.event_join(dto);
		return result;
	}
	
	@Override
	public List<EventDTO> event_lists() {
		Map<String, String> pg = new HashMap<>();
		pg.put("startno",String.valueOf(EventController.startno));
		pg.put("endno",String.valueOf(EventController.endno));
		List<EventDTO> cnt = em.event_lists(pg);
		return cnt;
	}
	
	@Override
	public Integer table_count(Map<String, String> smap) {
		
		Integer all = em.table_count(smap);
		return all;
	}

	

}
