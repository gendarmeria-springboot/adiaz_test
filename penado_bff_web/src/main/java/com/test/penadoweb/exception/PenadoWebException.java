package com.test.penadoweb.exception;

import org.springframework.http.HttpStatus;

public class PenadoWebException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpStatus MyError;

	public HttpStatus getMyError() {
		return MyError;
	}

	public PenadoWebException(String message, HttpStatus myError) {
		super(message);
		this.MyError = myError;
	}
}
