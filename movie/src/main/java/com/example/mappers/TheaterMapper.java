package com.example.mappers;

import com.example.dto.MovieDto;
import com.example.dto.TheaterDto;
import com.example.model.Theater;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TheaterMapper {

    public TheaterDto toDto(Theater theater) {

        int theaterId = theater.getTheaterId();
        String name = theater.getName();
        String address = theater.getAddress();
        List<MovieDto> movieList = theater.getMoviesList().stream().map(movie -> {
            MovieDto movieDto = new MovieDto();
            movieDto.setId(movie.getId());
            movieDto.setMovieGener(movie.getMovieGenre());
            movieDto.setMovieTitle(movie.getMovieTitle());
            movieDto.setMovieLanguage(movie.getMovieLanguage());
            return movieDto;
        }).collect(Collectors.toList());

        return new TheaterDto(theaterId,name,address,movieList);
    }
}
