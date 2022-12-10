package com.masai.exception;

public class NoMailFound extends RuntimeException {

	public NoMailFound() {

	}

	public NoMailFound(String msg) {
		super(msg);
	}
}
