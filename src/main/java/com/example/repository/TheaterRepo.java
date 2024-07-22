package com.example.repository;

import com.example.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepo extends JpaRepository<Theater, Integer> {
	List<Theater> findTheaterByTheaterId(Integer theaterId);


	//Theater findTheaterByName(String name);
	
	//List<Theater> findTheaterByTheaterId(Integer theaterId);

}
