package com.example.model;


import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="movie")
public class Movie {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(name = "title")
	    private String movieTitle;
		@Column(name="genre")
	    private String movieGenre;
		@Column(name = "language")
	    private String movieLanguage;
		@Column(name ="screen")
		private String screen;

	    /*@ManyToOne
		@JoinColumn(name="theaterId")
		@JsonProperty("theaterId")*/

	@ManyToMany
		@JoinTable(
				joinColumns = @JoinColumn(name = "theater_id"),
				inverseJoinColumns = @JoinColumn(name = "movie_id"))
	    private List<Theater> theater;

	public String getMovieGenre() {
		return movieGenre;
	}

	public int getId() {
		return id;
	}

	public String getScreen(){return screen;};

	public String getMovieTitle() {
		return movieTitle;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public List<Theater> getTheater() {
		return theater;
	}

	public Movie() {
	}

	public Movie(int id, String movieTitle,String screen, String movieGenre, String movieLanguage, List<Theater> theater) {
		this.id = id;
		this.movieTitle = movieTitle;
		this.movieGenre = movieGenre;
		this.movieLanguage = movieLanguage;
		this.theater = theater;
		this.screen = screen;
	}
	public Movie(int id, String movieTitle,String screen, String movieGenre, String movieLanguage) {
		this.id = id;
		this.movieTitle = movieTitle;
		this.movieGenre = movieGenre;
		this.movieLanguage = movieLanguage;
		this.screen = screen;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public void setScreen(String screen){
		this.screen = screen;

	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public void setTheater(List<Theater> theater) {
		this.theater = theater;
	}

	//	private Movie(Builder builder) {
//	        this.title = builder.title;
//	        this.genre = builder.genre;
//	        this.id = builder.id;
//	        this.language = builder.language;
//	        this.theater = builder.theater;
//
//	    }
//
//	public static class Builder {
//	    	private int id;
//	        private String title;
//	        private String genre;
//	        private String language;
//	        private Set<Theater> theater;
//
//
//	        public Builder(int id) {
//	        	this.id = id;
//
//	        }
//
//	        public Builder theater(Set<Theater> theater) {
//	        	this.theater = theater;
//	        	return this;
//
//	        }
//
//	        public Builder title(String title) {
//	            this.title = title;
//	            return this;
//	        }
//	        public Builder language(String language) {
//	        	this.language = language;
//	        	return this;
//	        }
//
//	        public Builder genre(String genre) {
//	            this.genre = genre;
//	            return this;
//	        }
//
//
//
//	        public Movie build() {
//	            return new Movie(this);
//	        }
//	    }


	@Override
	public String toString() {
		return "Movie{" +
				"id=" + id +
				", screen=" + screen +'\''+
				", movieTitle='" + movieTitle + '\'' +
				", movieGenre='" + movieGenre + '\'' +
				", movieLanguage='" + movieLanguage + '\'' +
				", theater=" + theater +
				'}';
	}
}


