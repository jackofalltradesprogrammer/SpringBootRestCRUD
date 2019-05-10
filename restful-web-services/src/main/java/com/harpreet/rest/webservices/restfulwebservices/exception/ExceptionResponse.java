package com.harpreet.rest.webservices.restfulwebservices.exception;

import java.util.Date;

// A template for a generic Exception handling for all resources 
public class ExceptionResponse {
	 private Date timestamp;
	 private String message;
	 private String details;
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public final Date getTimestamp() {
		return timestamp;
	}
	public final void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public final String getMessage() {
		return message;
	}
	public final void setMessage(String message) {
		this.message = message;
	}
	public final String getDetails() {
		return details;
	}
	public final void setDetails(String details) {
		this.details = details;
	}
	 
	 
}
