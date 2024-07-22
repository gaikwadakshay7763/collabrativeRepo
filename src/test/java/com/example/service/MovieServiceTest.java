package com.example.service;


import com.example.dto.MovieDto;
import com.example.mappers.Mapper;
import com.example.model.Movie;
import com.example.repository.MovieRepo;
import com.example.util.MyLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
    public class MovieServiceTest {

        @Mock
        private MovieRepo movieRepo;

        @Mock
        private Mapper mapper;

        @InjectMocks
        MovieServiceImpl movieService ;

        @Mock
        MyLogger logger;




        @BeforeEach
        public void setup() {
            MockitoAnnotations.initMocks(this);

            doNothing().when(logger).info(anyString());

        }

    Movie movie1 = new Movie(2,"Spider-Man","2","Action","English");
    Movie movie2 = new Movie(1,"Bombay to Goa","1","comedy","Hindi");
    MovieDto movieDto1 = new MovieDto(2,"Spider-Man","2","Action","English");
    MovieDto movieDto2 = new MovieDto(1,"Bombay to Goa","1","comedy","Hindi");


    @Test
        public void testGetAllMovies() {
            // Mocking data

            List<Movie> mockMovies = Arrays.asList(movie1, movie2);
            when(movieRepo.findAll()).thenReturn(mockMovies);

            // Mocking mapper
            MovieDto movieDto1 = new MovieDto(2,"Spider-Man","2","Action","English");
            MovieDto movieDto2 = new MovieDto(1,"Bombay to Goa","1","comedy","Hindi");

            when(mapper.toDto(movie1)).thenReturn(movieDto1);
            when(mapper.toDto(movie2)).thenReturn(movieDto2);

            // Calling the method
            List<MovieDto> result = movieService.getAllMovies();

            // Verifying the calls
            verify(movieRepo, times(1)).findAll();
            verify(mapper, times(1)).toDto(movie1);
            verify(mapper, times(1)).toDto(movie2);

            // Assertions
            Assertions.assertEquals(2, result.size());
            Assertions.assertEquals(movieDto1, result.get(0));
            Assertions.assertEquals(movieDto2, result.get(1));
        }

        @Test
        public void getMovieByIdTest(){

            int movieId  = 1;

            when(movieRepo.getById(movieId)).thenReturn(movie1);
            when(mapper.toDto(movie1)).thenReturn(movieDto1);

            MovieDto result = movieService.getMovieById(movieId);

            Assertions.assertEquals(movieDto1,result);


        }

//        @Test
//        public void getMovieByNameTest(){
//        String movieName = "spider-man";
//        List<MovieDto>movies = Arrays.asList(movieDto1,movieDto2);
//        List<Movie> mockMovies = Arrays.asList(movie1,movie2);
//
//        when(movieRepo.findAll()).thenReturn(mockMovies);
//
//        when(mapper.toDto(any(Movie.class))).thenAnswer(invocation ->{
//             return movies.stream().filter(m -> m.getMovieTitle().equalsIgnoreCase(movieName)).collect(Collectors.toList());});
//
//            List<MovieDto> result = movieService.getMovieByName(movieName);
//
//            Assertions.assertEquals(movies,result);
//        }



    }



