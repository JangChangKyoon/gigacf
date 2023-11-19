package com.example.gigacf.comm.exception;

public class NotExistingPhoneException extends RuntimeException {
	public NotExistingPhoneException(String message) {
		super(message); // for calling constructor of parent class
	}
}
