package com.example.model;
import jakarta.persistence.*;

@Entity
@Table(name="ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ticketId;
	@Column(name ="seatNumber", nullable =false , length = 10)
	private int seatNumber;
	@OneToOne
	private Theater theater;
	@OneToOne
	public Movie movie;
	@OneToOne
	private User user;

	public Ticket() {
	}

	private Ticket(Builder builder) {
		this.ticketId = ticketId;
		this.seatNumber = seatNumber;
		this.theater = theater;
		this.movie = movie;
		this.user = user;

	}

	public long getTicketId() {
		return ticketId;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public Theater getTheater() {
		return theater;
	}

	public Movie getMovie() {
		return movie;
	}

	public User getUser() {
		return user;
	}

	public static class Builder{
		private long ticketId;
		private int seatNumber;
		private Theater theater;
		private Movie movie;
		private User user;

		public Builder(int seatNumber) {
			this.seatNumber = seatNumber;

		}
		public Builder ticketId(long id) {
			this.ticketId= ticketId;
			return this;
		}
		public Builder theater(Theater theater) {
			this.theater = theater;
				return this;
		}

		public Builder movie(Movie movie) {
			this.movie = movie;
			return this;

		}
		public Builder user(User user) {
			this.user = user;
			return this;
		}

		public Ticket build() {
			return new Ticket(this);
		}
	}

}
