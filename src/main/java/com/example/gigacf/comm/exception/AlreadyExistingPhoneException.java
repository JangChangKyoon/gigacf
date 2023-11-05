package com.example.gigacf.comm.exception;

// phone 중복검사 예외
public class AlreadyExistingPhoneException extends RuntimeException {
	
	public AlreadyExistingPhoneException(String message) {
		super(message); // for calling constructor of parent class
	}
}
