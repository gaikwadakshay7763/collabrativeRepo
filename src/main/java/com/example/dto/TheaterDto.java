package com.example.dto;

import java.util.List;

public class TheaterDto {
    private int theaterId;
    private String name;
    private String address;
    private List<MovieDto> movieList;


    public TheaterDto(int theaterId,  String name, String address, List<MovieDto> movieList) {
        this.theaterId = theaterId;
        this.name = name;
        this.address = address;
        this.movieList = movieList;
    }

    public TheaterDto() {
        super();
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
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

    public List<MovieDto> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MovieDto> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return "TheaterDto{" +
                "theaterId=" + theaterId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", movieList=" + movieList +
                '}';
    }
}
