package com.example.gigacf.comm.exception;

public class AlreadyExistingPhoneException extends RuntimeException {
	
	public AlreadyExistingPhoneException(String message) {
		super(message); // for calling constructor of parent class
	}
}
