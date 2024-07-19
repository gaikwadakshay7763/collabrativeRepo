package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name= "userName", nullable = false)
	private String userName;
    @Column
    private String userPassword;

	public User() {
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	private User(Builder builder) {
		this.userId = userId;
		this.userName = userName;
        this.userPassword = userPassword;

	}

	public static class Builder{

		private int userId;
		private String userName;
        private String userPassword;

		public Builder(int userId) {
			this.userId = userId;
		}

		public Builder userName(String userName) {

			this.userName = userName;
			return this;

		}
        public Builder userPassword(String userPassword){
            this.userPassword = userPassword;
            return this;
        }

		public User build() {
			return new User(this);
		}
	}
}
