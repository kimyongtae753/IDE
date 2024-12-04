package kr.co.kim;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface notice_mapper { //xml 과 연동은 되어 있다.
	int notice_insert(notice_DTO nd);
	public int noticein(notice_DTO nd);
	
}
