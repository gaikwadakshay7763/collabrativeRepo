package com.example.dto;

public class BookingResponseDto {

    private int seatNumber;
    private String movieTitle;
    private String movieGener;
    private String movieLanguage;
    private String name;
    private String address;

    public BookingResponseDto(int seatNumber, String movieTitle, String movieGener, String movieLanguage, String name, String address) {
        this.seatNumber = seatNumber;

        this.movieTitle = movieTitle;
        this.movieGener = movieGener;
        this.movieLanguage = movieLanguage;
        this.name = name;
        this.address = address;
    }

    public BookingResponseDto() {
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieGener() {
        return movieGener;
    }

    public void setMovieGener(String movieGener) {
        this.movieGener = movieGener;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "BookingResponseDto{" +
                "seatNumber=" + seatNumber +
                ", movieTitle='" + movieTitle + '\'' +
                ", movieGener='" + movieGener + '\'' +
                ", movieLanguage='" + movieLanguage + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
