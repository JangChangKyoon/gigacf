package com.example.gigacf.v2.common.exception.customException;

/*로그인할 경우 오류 처리*/
public class NotMatchingPasswordException extends RuntimeException {
	public NotMatchingPasswordException(String message) {
		super(message); // for calling constructor of parent class
	}
}
