package com.alzohareshopee.webservice.Exception.handler;

import java.util.Date;

public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;

	public ErrorDetails(Date timestamp, String message, String error) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = error;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
