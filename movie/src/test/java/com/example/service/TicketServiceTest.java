package com.example.service;

import com.example.dto.*;
import com.example.mappers.Mapper;
import com.example.repository.MovieRepo;
import com.example.repository.TheaterRepo;
import com.example.util.MyLogger;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class TicketServiceTest {

    @Mock
    private MovieService movieservice;
    @Mock
    private TheaterService theaterService;
    @Mock
    private MovieRepo movieRepo;
    @Mock
    private TheaterRepo theaterRepo;
    @Mock
    private Mapper mapper;
    @Mock
    private MyLogger logger;
    @InjectMocks
    TicketServiceImpl ticketService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);

    }

    MovieDto movieDto1 = new MovieDto(1,"Spider-Man","2","Action","English");
    List<MovieDto> movieDto = List.of(new MovieDto[]{movieDto1});
    TheaterDto theaterDto = new TheaterDto(2,"Big-cinemas","pune",movieDto);
    UserDto userDto = new UserDto(1,"akshay");
   TicketDto ticketDto = new TicketDto(1,24,theaterDto,movieDto1,userDto);
    @Test
    public void saveTicketTest() throws JsonProcessingException {
        BookingRequestDto ticket = new BookingRequestDto(ticketDto,1,2);


        BookingResponseDto expected = new BookingResponseDto(24,"Spider-Man","Action","English","Big-Cinemas","pune");

        BookingResponseDto Actual = ticketService.saveTicket(ticket);

        Assertions.assertEquals(expected,Actual);


    }



}
