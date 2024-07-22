package com.example.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Movie;
@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer>{



	//@Query("SELECT b.movieTitle FROM Movie b WHERE b.title = :name ")
	// Movie findMovieByTitle( String name);
	
	
	
}
