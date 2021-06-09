package it.mycompany.springresthib.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import it.mycompany.springresthib.entity.CustomerErrorResponse;
import it.mycompany.springresthib.exception.CustomerNotFoundException;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException ex) {
		CustomerErrorResponse error = new CustomerErrorResponse(
				HttpStatus.NOT_FOUND.value(), 
				ex.getMessage(),
				System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception ex) {
		CustomerErrorResponse error = new CustomerErrorResponse(
				HttpStatus.BAD_REQUEST.value(), 
				ex.getMessage(),
				System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
