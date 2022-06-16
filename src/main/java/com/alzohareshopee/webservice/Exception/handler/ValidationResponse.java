package com.alzohareshopee.webservice.Exception.handler;

import java.util.Date;

public class ValidationResponse {

	private Date timestamp;
	private String message;
	private String details;

	public ValidationResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
}
