package com.example.mappers;

import com.example.dto.MovieDto;
import com.example.dto.TheaterDto;
import com.example.dto.TicketDto;
import com.example.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public TicketDto toDto(Ticket ticket){
        TicketDto ticketDto = new TicketDto();
        ticketDto.setTicketId(ticket.getTicketId());

        MovieDto movieDto = new MovieDto();
        movieDto.setId(ticket.getMovie().getId());
        movieDto.setMovieGener(ticket.getMovie().getMovieGenre());
        movieDto.setMovieTitle(ticket.getMovie().getMovieTitle());
        movieDto.setMovieLanguage(ticket.getMovie().getMovieLanguage());

        ticketDto.setMovieDto(movieDto);

        TheaterDto theaterDto = new TheaterDto();
        theaterDto.setTheaterId(ticket.getTheater().getTheaterId());
        theaterDto.setAddress(ticket.getTheater().getAddress());
        theaterDto.setName(ticket.getTheater().getName());

        ticketDto.setTheaterDto(theaterDto);


        return ticketDto;
    }
}
