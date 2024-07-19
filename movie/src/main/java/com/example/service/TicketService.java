package com.example.service;

import com.example.dto.BookingRequestDto;
import com.example.dto.BookingResponseDto;
import com.example.dto.TicketDto;
import com.example.model.Ticket;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

@Component
public interface TicketService {

    BookingResponseDto saveTicket(BookingRequestDto bookingRequest) throws JsonProcessingException;
    TicketDto getTicketById(long ticketId);
}
