package com.example.controller;

import com.example.dto.MovieDto;
import com.example.model.Movie;
import com.example.model.Theater;
import com.example.service.MovieService;
import com.example.service.TheaterService;
import com.example.util.MyLogger;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater")
public class TheaterBookingController {
    @Autowired
    TheaterService theaterService;
    @Autowired
    MovieService movieService;
    @Autowired
    MyLogger logger;


    @PostMapping("/addTheater")
    public ResponseEntity<?> addTheater(@RequestBody Theater theater){
        if(!theater.equals(null)) {
            Theater newTheater = theaterService.saveTheater(theater);
            logger.info("theater is added");
            return new ResponseEntity<>(newTheater, HttpStatus.OK);
        }
        logger.info("adding theater got some trouble");
        return ResponseEntity.badRequest().build();

    }

    @PostMapping("/addMovie")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie, @RequestParam String theaterId) throws JsonProcessingException {
        if(!movie.equals(null)) {

            Integer th_id = Integer.parseInt(theaterId);
            logger.info("finding the theater ");
            MovieDto newMovie = movieService.saveMovie(movie, th_id);
            String soapmessage = movieService.xmlTester(movie);
            System.out.println(soapmessage);
            logger.info("movie is added to the data base");
            try {
                XmlMapper xmlMapper = new XmlMapper();
                xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                String xml = xmlMapper.writeValueAsString(newMovie);


                if (xml.contains("<taxes>")) {
                    xml = xml.replaceFirst("<taxes>", "<Taxes soapenc:arrayType=\"ws:TaxStruct[]\">");
                }


                String envelopeStart = "<?xml version=\"1.1\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">  <soap:Body>    <" +
                        ">";
                String envelopeEnd = "</" + ">  </soap:Body></soap:Envelope>";
                final String soapMessage = envelopeStart + xml + envelopeEnd;
                System.out.println(soapMessage);

            return new ResponseEntity<>(newMovie,HttpStatus.OK);
        } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return ResponseEntity.badRequest().build();

    }
        return null;
    }

    @GetMapping("/getTheaterById")
    public ResponseEntity<?>getTheaterById(@RequestParam String theaterId){
        if(!theaterId.isEmpty()){
            int th_id = Integer.parseInt(theaterId);
            Theater result = theaterService.getTheaterById(th_id);

            return new ResponseEntity<>(result, HttpStatus.OK);

        }
        return ResponseEntity.badRequest().build();
    }
}
