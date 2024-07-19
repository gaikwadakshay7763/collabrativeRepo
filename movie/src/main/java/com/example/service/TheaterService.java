package com.example.service;

import java.util.List;

import com.example.dto.TheaterDto;
import org.springframework.stereotype.Component;
import com.example.model.Theater;

@Component
public interface TheaterService {
	

	public List<TheaterDto> getAllTheater();
	
	public Theater getTheaterById(int id);
	
	//public Theater getTheaterByName(String name);
	
	public Theater saveTheater(Theater theater);

	public String deleteAllTheater();

}
