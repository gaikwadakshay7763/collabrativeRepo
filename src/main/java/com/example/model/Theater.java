//package com.example.model;
//
//import jakarta.persistence.*;
//
//import java.util.List;
//
//
//@Entity
//@Table(name="theater")
//
//public class Theater {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//
//	private int theaterId;
//	@Column(name="name", nullable = false , length =50)
//	private String name;
//	@Column(name="address" , nullable = false, length = 250)
//	private String address;
//
//	@ManyToMany(mappedBy = "theater")
//	List<Movie> moviesList;
//	public Theater() {
//	}
//
//	public List<Movie> getMoviesList() {
//		return moviesList;
//	}
//
//	public void setMoviesList(List<Movie> moviesList) {
//		this.moviesList = moviesList;
//	}
//
//	public Theater(int theaterId, String name, String address, List<Movie> moviesList) {
//		this.theaterId = theaterId;
//		this.name = name;
//		this.address = address;
//		this.moviesList = moviesList;
//	}
//
//	public int getTheaterId() {
//		return theaterId;
//	}
//
//	public void setTheaterId(int theaterId) {
//		this.theaterId = theaterId;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//		private Theater(Builder builder) {
//		this.name = name;
//		this.address = address;
//		this.theaterId = theaterId;
//	}
//
//	public static class Builder{
//
//		private String name;
//		private String address;
//		private int theaterId;
//
//		public Builder(String name) {
//			this.name= name;
//		}
//		public Builder theaterId(int theaterId) {
//			this.theaterId = theaterId;
//			return this;
//		}
//
//		public Builder address(String address) {
//			this.address = address;
//
//			return this;
//		}
//
//		public Theater build() {
//			return new Theater(this);
//		}
//
//	}
//
//	@Override
//	public String toString() {
//		return "Theater{" +
//				"theaterId=" + theaterId +
//				", name='" + name + '\'' +
//				", address='" + address + '\'' +
//				'}';
//	}
//}
package com.example.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "theater")
public class Theater {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theaterId;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "address", nullable = false, length = 250)
	private String address;

	@ManyToMany(mappedBy = "theater")
	List<Movie> moviesList;

	private Theater() {}

	private Theater(Builder builder) {
		this.theaterId = builder.theaterId;
		this.name = builder.name;
		this.address = builder.address;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public List<Movie> getMoviesList() {
		return moviesList;
	}

	@Override
	public String toString() {
		return "Theater{" +
				"theaterId=" + theaterId +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				'}';
	}

	public static class Builder {
		private String name;
		private String address;
		private int theaterId;

		public Builder(String name) {
			this.name = name;
		}

		public Builder theaterId(int theaterId) {
			this.theaterId = theaterId;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Theater build() {
			return new Theater(this);
		}
	}
}
