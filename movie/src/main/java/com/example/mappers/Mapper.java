package com.example.mappers;

import com.example.dto.MovieDto;
import com.example.dto.TheaterDto;
import com.example.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class Mapper {

    public MovieDto toDto(Movie movie){

        MovieDto movieDTO = new MovieDto();
        movieDTO.setId(movie.getId());
        movieDTO.setScreen(movie.getScreen());
        movieDTO.setMovieTitle(movie.getMovieTitle());
        movieDTO.setMovieGener(movie.getMovieGenre());
        movieDTO.setMovieLanguage(movie.getMovieLanguage());

        // Map the associated theaters to TheaterDTOs
        List<TheaterDto> theaterDTOs = movie.getTheater()
                .stream()
                .map(theater -> {
                    TheaterDto theaterDTO = new TheaterDto();
                    theaterDTO.setTheaterId(theater.getTheaterId());
                    theaterDTO.setName(theater.getName());
                    theaterDTO.setAddress(theater.getAddress());
                    return theaterDTO;
                })
                .collect(Collectors.toList());

        movieDTO.setTheater(theaterDTOs);
        return movieDTO;
    }
}
