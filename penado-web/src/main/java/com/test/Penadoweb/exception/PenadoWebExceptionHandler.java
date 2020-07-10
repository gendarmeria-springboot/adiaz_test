package com.test.Penadoweb.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class PenadoWebExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse response = new ExceptionResponse();

		response.setMessage(ex.getMessage());
		response.setDetail(request.getDescription(false));
		response.setTimestamp(new Date());

		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Object> handleAllException(RuntimeException ex, WebRequest request) throws Exception {
		ExceptionResponse response = new ExceptionResponse();

		response.setMessage(ex.getMessage());
		response.setDetail(request.getDescription(false));
		response.setTimestamp(new Date());

		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(PenadoWebException.class)
	public final ResponseEntity<Object> handleChallengeWebException(PenadoWebException ex, WebRequest request)
			throws Exception {
		ExceptionResponse response = new ExceptionResponse();

		if (response.getError() == null) {
			response.setError(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.setMessage(ex.getMessage());
		response.setDetail(request.getDescription(false));
		response.setTimestamp(new Date());
		response.setError(ex.getMyError());

		return new ResponseEntity<>(response, response.getError());
	}
}
