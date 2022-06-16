package com.alzohareshopee.webservice.Exception;

public class CustomerNotFound extends RuntimeException{

	private static final long serialVersionUID = 1l;

	public CustomerNotFound(String message) {
		super(message);
	}
}
