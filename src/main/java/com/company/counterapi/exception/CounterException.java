package com.company.counterapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class CounterException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public CounterException(String counter) {
        super(counter);
    }

}
