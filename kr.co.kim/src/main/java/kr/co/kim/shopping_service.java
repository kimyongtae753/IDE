package kr.co.kim;

import java.util.List;

public interface shopping_service {
	String search_id(String mid); //Controller에서 Mapper 전당
	public int member_join(member_DTO dto);
	public List<member_DTO>login_id(String mid);
}
