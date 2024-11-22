package kr.co.kim;

import org.apache.ibatis.annotations.Mapper;



@Mapper //myvatis .xml과 동기화
public interface shopping_query {
	String search_id(String mid); //사용자 ID 체크 하기 위한 정보
	int member_join(member_DTO dto);
	
}
