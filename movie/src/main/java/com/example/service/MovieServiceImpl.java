package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.example.dto.MovieDto;
import com.example.mappers.Mapper;
import com.example.mappers.TheaterMapper;
import com.example.model.Theater;
import com.example.repository.TheaterRepo;
import com.example.util.MyLogger;
import com.example.util.ScreenNotAvaliableException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.hibernate.type.format.jackson.JacksonXmlFormatMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Movie;
import com.example.repository.MovieRepo;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	MovieRepo  movieRepo;
	@Autowired
	TheaterRepo theaterRepo;
	@Autowired
	Mapper mapper;
	@Autowired
	TheaterMapper theaterMapper;
	@Autowired
	MyLogger logger;

	public MovieServiceImpl(MovieRepo movieRepo, TheaterRepo theaterRepo, Mapper mapper, TheaterMapper theaterMapper, MyLogger logger) {
		this.movieRepo = movieRepo;
		this.theaterRepo = theaterRepo;
		this.mapper = mapper;
		this.theaterMapper = theaterMapper;
		this.logger = logger;
	}

	public  List<MovieDto> getAllMovies(){

		List<Movie> movies = movieRepo.findAll();

		return movies.stream().map(mapper::toDto).collect(Collectors.toList());
		
		
		
	}

	
	public MovieDto getMovieById(int id) {


		Movie movie = movieRepo.getById(id);
		MovieDto movieDto = mapper.toDto(movie);
		return movieDto;
	}


	public List<MovieDto> getMovieByName(String name) {

		Predicate<MovieDto> moviePredicate = m -> m.getMovieTitle().equalsIgnoreCase(name);
		logger.info("creating the predicate for filter");

		List<MovieDto> movies = getAllMovies().stream().filter(moviePredicate).collect(Collectors.toList());
		logger.info1("Filter the movie",movies);
		return movies;
	}




	public MovieDto saveMovie(Movie movie, Integer theaterId) {
		try {
			List<Theater> theater = theaterRepo.findTheaterByTheaterId(theaterId);
			movie.setTheater(theater);
			logger.info1("setting the theater", theater);
			List<Movie> movieList = movieRepo.findAll();

			List<Movie> isMovieExist = movieList.stream().filter(m -> m.getMovieTitle().equalsIgnoreCase(movie.getMovieTitle())).collect(Collectors.toList());
			logger.info1("isMovieExist", isMovieExist);
			//Filter for the movie present in the database but having different language store them in different ids.
			//Optional<?> isMovieGenerMatch =  movieList.stream().filter(m -> m.getMovieLanguage().equalsIgnoreCase(movie.getMovieLanguage())).findAny();
			boolean isScreenAvaliable = isMovieExist.stream().anyMatch(m -> m.getScreen() == movie.getScreen());
			Movie newMovie = null;
			if (isMovieExist.isEmpty() && !(isScreenAvaliable)) {

				newMovie = movieRepo.save(movie);

				logger.info1("movie saved", newMovie);

				return mapper.toDto(newMovie);


			} else {
				logger.info("Screen is not avaliable");

				throw new ScreenNotAvaliableException("Screen is not available for the movie");
			}
		} catch (Exception e) {

			e.printStackTrace();
			throw new ScreenNotAvaliableException("Screen is not avaliable for movie", e);

		}



	}

	public String xmlTester(Movie movie) throws JsonProcessingException {
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		String xml = xmlMapper.writeValueAsString(movie);

		if (xml.contains("<Legs>") && xml.contains("Passengers")) {
			xml = xml.replace("<Legs>", "<Legs soapenc:arrayType=\"ws:LegStruct[]\">");
			xml = xml.replace("<Passengers>", "<Passengers soapenc:arrayType=\"ws:PassengerStruct[]\">");
		}
		if(xml.contains("<taxes>")){
			xml = xml.replaceFirst("<taxes>","<Taxes soapenc:arrayType=\"ws:TaxStruct[]\">");
		}

		String envelopeStart = "<?xml version=\"1.1\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">  <soap:Body>    <"
				+ ">";
		String envelopeEnd =  " </soap:Body></soap:Envelope>";
		final String soapMessage = envelopeStart + xml + envelopeEnd;
		return soapMessage;
	}
}






