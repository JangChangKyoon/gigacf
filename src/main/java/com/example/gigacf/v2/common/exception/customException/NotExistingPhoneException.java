package com.example.gigacf.v2.common.exception.customException;

public class NotExistingPhoneException extends RuntimeException {
	public NotExistingPhoneException(String message) {
		super(message); // for calling constructor of parent class
	}
}
