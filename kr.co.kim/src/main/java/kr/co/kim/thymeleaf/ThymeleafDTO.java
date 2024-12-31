package kr.co.kim.thymeleaf;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("ThymeleafDTO")
public class ThymeleafDTO {
	int uidx;
	String userid, usernm;

}
