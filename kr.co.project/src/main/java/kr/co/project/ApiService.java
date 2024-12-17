package kr.co.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {
	
   @Autowired
   apimapper ams;
   
   public List<ApiDTO> api_alldata(){
	   List<ApiDTO> all = ams.api_alldata();
	   return all;
   }
   
   
}