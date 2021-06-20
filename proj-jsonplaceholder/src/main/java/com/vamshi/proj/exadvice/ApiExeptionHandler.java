package com.vamshi.proj.exadvice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vamshi.proj.exception.ResourceNotFoundException;

@ControllerAdvice
public class ApiExeptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseBody
	public ResponseEntity<?> resolveException(ResourceNotFoundException exception) {
		
		return ResponseEntity.notFound().build();
	}
}
