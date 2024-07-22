package com.example.dto;

public class BookingRequestDto {

    private TicketDto ticketDto;
    private int id;
    private int theaterId;

    public BookingRequestDto(TicketDto ticketDto, int id, int theaterId) {
        this.ticketDto = ticketDto;
        this.id = id;
        this.theaterId = theaterId;
    }

    public TicketDto getTicketDto() {
        return ticketDto;
    }

    public void setTicketDto(TicketDto ticketDto) {
        this.ticketDto = ticketDto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    @Override
    public String toString() {
        return "BookingRequest{" +
                "ticketDto=" + ticketDto +
                ", id=" + id +
                ", theaterId=" + theaterId +
                '}';
    }
}
