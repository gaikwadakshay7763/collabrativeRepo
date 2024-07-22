package com.example.service;

import java.util.List;

import com.example.dto.MovieDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

import com.example.model.Movie;

@Component
public interface MovieService {
	
	


	public List<MovieDto> getAllMovies();
	
	public MovieDto getMovieById(int id);
	
	public List <MovieDto> getMovieByName(String name);
	
	public MovieDto saveMovie(Movie movie, Integer theaterId);
	public String xmlTester(Movie movie) throws JsonProcessingException;





}
