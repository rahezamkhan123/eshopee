package com.alzohareshopee.webservice.Exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alzohareshopee.webservice.Exception.CustomerNotFound;
import com.alzohareshopee.webservice.Exception.EmployeeNotFound;
import com.alzohareshopee.webservice.Exception.ProductNotFound;

@ControllerAdvice
public class GlobalExceptionHandler {

	ExceptionResponse response;

	@ExceptionHandler(value = ProductNotFound.class)
	public ResponseEntity<ExceptionResponse> productNotFound(ProductNotFound exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = CustomerNotFound.class)
	public ResponseEntity<ExceptionResponse> customerNotFound(CustomerNotFound exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = EmployeeNotFound.class)
	public ResponseEntity<ExceptionResponse> employeeNotFound(EmployeeNotFound exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Error",
				exception.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
