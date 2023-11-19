package com.example.gigacf.comm;

public class MyExceptionRuntime extends RuntimeException {

	public MyExceptionRuntime(String s) {
		super("My Exception : "+ s);
	}
	
	public MyExceptionRuntime(String s, String sClass) {
		super("My Exception : "+ s);
	}
	
}
