package com.example.dto;

import java.util.List;

public class MovieDto {

    private int id;
    private String screen;
    private String movieTitle;
    private String movieGener;
    private String movieLanguage;
    private List<TheaterDto> theater;

    public MovieDto(int id, String screen, String movieTitle, String movieGener, String movieLanguage, List<TheaterDto> theater) {
        this.id = id;
        this.screen = screen;
        this.movieTitle = movieTitle;
        this.movieGener = movieGener;
        this.movieLanguage = movieLanguage;
        this.theater = theater;
    }

    public MovieDto(int id, String screen, String movieTitle, String movieGener, String movieLanguage) {
        this.id = id;
        this.screen = screen;
        this.movieTitle = movieTitle;
        this.movieGener = movieGener;
        this.movieLanguage = movieLanguage;

    }

    public MovieDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getScreen(){
        return screen;
    }
    public void setScreen(String screen){
        this.screen = screen;
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

    public List<TheaterDto> getTheater() {
        return theater;
    }

    public void setTheater(List<TheaterDto> theater) {
        this.theater = theater;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "id=" + id +
                "screen="+ screen + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                ", movieGener='" + movieGener + '\'' +
                ", movieLanguage='" + movieLanguage + '\'' +
                ", theater=" + theater +
                '}';
    }
}
