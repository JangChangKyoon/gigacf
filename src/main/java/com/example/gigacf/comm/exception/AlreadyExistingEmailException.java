package com.example.gigacf.comm.exception;

public class AlreadyExistingEmailException extends RuntimeException {
	public AlreadyExistingEmailException(String message) {
		super(message); // for calling constructor of parent class
	}
}
