package com.muarine.mapper;

import java.util.List;

import com.muarine.entity.LogApi;


public interface LogApiMapper {
    
	List<LogApi> select();
	
	Long insert(LogApi logApi);
	
}