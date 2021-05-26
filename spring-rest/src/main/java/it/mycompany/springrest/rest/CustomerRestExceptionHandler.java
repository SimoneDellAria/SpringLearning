package it.mycompany.springrest.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import it.mycompany.springrest.entity.CustomerErrorResponse;
import it.mycompany.springrest.exception.CustomerNotFoundException;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException ex) {

		CustomerErrorResponse response = new CustomerErrorResponse();

		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage(ex.getMessage());
		response.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception ex) {

		CustomerErrorResponse response = new CustomerErrorResponse();

		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage(ex.getMessage());
		response.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
