package com.company.counterapi.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CounterExceptionHandler extends ResponseEntityExceptionHandler{

		@ExceptionHandler(CounterException.class)		
	    public ResponseEntity<?>counterExceptionHandler(CounterException dcnfe, WebRequest request) {
	        ErrorDetails errorDetails = ErrorDetails.builder()
	                .timeStamp(new Date())
	                .details(request.getDescription(false))
	                .message(dcnfe.getMessage())
	                .build();
	        //log.info("Exception Details :: {}", errorDetails.toString());
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);  
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
	        ErrorDetails errorDetails = ErrorDetails.builder()
	                .timeStamp(new Date())
	                .details(request.getDescription(false))
	                .message("Counter Not Found").build();
	        //log.info("Exception Details :: {}", errorDetails.toString());
	        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	
}
