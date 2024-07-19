package com.course.utile;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {	
	
	private LocalDateTime timestamp;
	private String message;
	private String detail;
	public ErrorDetails(LocalDateTime localDateTime, String message, String detail) {
		super();
		this.timestamp = localDateTime;
		this.message = message;
		this.detail = detail;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	

}
