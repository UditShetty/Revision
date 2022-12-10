package com.masai.exception;

public class PasswordMisMatchException extends RuntimeException {

	public PasswordMisMatchException() {

	}

	public PasswordMisMatchException(String msg) {
		super(msg);
	}
}
