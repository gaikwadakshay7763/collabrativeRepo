package com.example.controller;

import com.example.dto.BookingRequestDto;
import com.example.dto.BookingResponseDto;
import com.example.dto.MovieDto;
import com.example.dto.TheaterDto;
import com.example.repository.MovieRepo;
import com.example.service.MovieService;
import com.example.service.TheaterService;
import com.example.service.TicketService;
import com.example.util.MyLogger;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class TicketController {

	@Autowired  MovieService movieService;
	
	@Autowired  TheaterService theaterService;

	@Autowired  TicketService ticketService;
	@Autowired  MyLogger logger;
	@Autowired
	MovieRepo movieRepo;



	@GetMapping("/getTheater")
	ResponseEntity<?> getTheater(){
		List<TheaterDto> listTheater = theaterService.getAllTheater();
		return new ResponseEntity<>(listTheater,HttpStatus.OK);
	}
	
	@GetMapping("/getMovies")
	ResponseEntity<?> getMovies(){
		
		List<MovieDto> listedMovies = movieService.getAllMovies();

		if(!listedMovies.isEmpty()) {
			logger.info("movie list");
		return new ResponseEntity<>(listedMovies,HttpStatus.OK) ;



		
	}else {
		
		
		return ResponseEntity.notFound().build();
	}

		}
	@GetMapping("/getMovieByName")
	public ResponseEntity<?> getMovieByMovieTitle(@RequestParam String name){
		if(name != null) {
			List<MovieDto> movies = movieService.getMovieByName(name);

			logger.info("movies");
			return new ResponseEntity<>(movies,HttpStatus.OK);
		}
		else{
			return ResponseEntity.notFound().build();
		}

	}



	@PostMapping("/getTicket")

	public ResponseEntity<?>bookTicket(@RequestBody BookingRequestDto bookingRequest) throws JsonProcessingException {

		BookingResponseDto newTicket = ticketService.saveTicket(bookingRequest);
			logger.info("ticket is generated");
		return new ResponseEntity<>(newTicket,HttpStatus.OK);


	}
	@GetMapping("/movieTitle")

	public ResponseEntity<?> getMovieByTitle(@RequestParam String name){

		List<MovieDto> newMovie = movieService.getMovieByName(name);

		return new ResponseEntity<>(newMovie,HttpStatus.OK);
	}


	
	@GetMapping("/theaterInfo")
	public ResponseEntity<?> getTheaterInfo(@PathVariable("movie") String movie) {

		if(movie == null) {

			return ResponseEntity.notFound().build();
		}
		//initilize the list of show time then
		//list of show time where i can filter using movie and the theater and time
		List<TheaterDto> theaterInfo = theaterService.getAllTheater();
		logger.info("theater information is displayed");

		return new ResponseEntity(theaterInfo,HttpStatus.OK);
	}

	@GetMapping("deleteAllTheater")
	public ResponseEntity<?> deleteAllTheater(){
		theaterService.deleteAllTheater();
		movieRepo.deleteAll();
		return new ResponseEntity<>("successful", HttpStatus.OK);
	}
}
