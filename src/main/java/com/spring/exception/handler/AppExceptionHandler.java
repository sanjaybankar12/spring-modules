package com.spring.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleClientException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getFieldErrors().stream().sorted((o1, o2) -> o1.getField().compareTo(o2.getField()))
				.forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
