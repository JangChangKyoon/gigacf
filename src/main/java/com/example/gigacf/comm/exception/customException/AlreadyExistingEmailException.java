package com.example.gigacf.comm.exception;

//이메일 중복 검사 예외
public class AlreadyExistingEmailException extends RuntimeException {
	public AlreadyExistingEmailException(String message) {
		super(message); // for calling constructor of parent class
	}
}
