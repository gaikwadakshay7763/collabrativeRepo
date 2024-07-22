package com.example.service;

import com.example.dto.*;
import com.example.mappers.Mapper;
import com.example.mappers.TheaterMapper;
import com.example.mappers.TicketMapper;
import com.example.model.Theater;
import com.example.model.Ticket;
import com.example.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TicketMapper ticketMapper;
    @Autowired
    MovieService movieService ;
    @Autowired
    TheaterService theaterService;
    @Autowired
    Mapper mapper;
    @Autowired
    TheaterMapper theaterMapper;


    @Override
    public BookingResponseDto saveTicket(BookingRequestDto bookingRequest) {

        String match = null;

        int movieId= bookingRequest.getId();
        int theaterId = bookingRequest.getTheaterId();
        MovieDto movieDto = movieService.getMovieById(movieId);
        Theater theater = theaterService.getTheaterById(theaterId);
        TheaterDto theaterDto = theaterMapper.toDto(theater);

        TicketDto ticket = new TicketDto();

        ticket.setTicketId(bookingRequest.getTicketDto().getTicketId());
        ticket.setSeatNumber(bookingRequest.getTicketDto().getSeatNumber());

        ticket.setMovieDto(movieDto);
        ticket.setTheaterDto(theaterDto);


        BookingResponseDto userCopyOfTicket = new BookingResponseDto();
        userCopyOfTicket.setSeatNumber(ticket.getSeatNumber());
        userCopyOfTicket.setMovieTitle(ticket.getMovieDto().getMovieTitle());
        userCopyOfTicket.setMovieGener(ticket.getMovieDto().getMovieGener());
        userCopyOfTicket.setMovieLanguage(ticket.getMovieDto().getMovieLanguage());
        userCopyOfTicket.setName(ticket.getTheaterDto().getName());
        userCopyOfTicket.setAddress(ticket.getTheaterDto().getAddress());

        return userCopyOfTicket;
    }

    @Override
    public TicketDto getTicketById( long ticketId) {

        List<Ticket> allTickets = ticketRepository.findAll();
        Ticket ticket = allTickets.stream().filter(t->t.getTicketId() == ticketId).findAny().orElseThrow(()-> new NoSuchElementException("Ticket Id is not valid"));

        return ticketMapper.toDto(ticket);
    }
}
