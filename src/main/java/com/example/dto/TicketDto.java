package com.example.dto;
import com.example.model.User;

public class TicketDto {

    private long ticketId;
    private int seatNumber;
    private TheaterDto theaterDto;
    private MovieDto movieDto;
    private UserDto userDto;

    public TicketDto(long ticketId, int seatNumber, TheaterDto theaterDto, MovieDto movieDto, UserDto userDto) {
        this.ticketId = ticketId;
        this.seatNumber = seatNumber;
        this.theaterDto = theaterDto;
        this.movieDto = movieDto;
        this.userDto = userDto;
    }

    public TicketDto() {
        super();
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public TheaterDto getTheaterDto() {
        return theaterDto;
    }

    public void setTheaterDto(TheaterDto theaterDto) {
        this.theaterDto = theaterDto;
    }

    public MovieDto getMovieDto() {
        return movieDto;
    }

    public void setMovieDto(MovieDto movieDto) {
        this.movieDto = movieDto;
    }

    public UserDto getUser() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public String toString() {
        return "TicketDto{" +
                "ticketId=" + ticketId +
                ", seatNumber=" + seatNumber +
                ", theaterDto=" + theaterDto +
                ", movieDto=" + movieDto +
                ", userDto=" + userDto +
                '}';
    }
}
