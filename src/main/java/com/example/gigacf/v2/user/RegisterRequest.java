package com.example.gigacf.v2.user;

import lombok.Getter;
import lombok.Setter;

/** 
 * 이 클래스의 역할 : formData 유효성 검사할 Model
 * 1. formData를 바인딩한 값 검사
 * 2. Validatior로 그 값 검사
 * 3. Mapper에 퀴리문에 입력한 변수값 보내기(Dao)
 **/
@Getter
@Setter
public class RegisterRequest {
	
	// Validatior에서 검증하거나 디비에 보낼 value property
    private String phone;
    private String email;
    private String name;
    private String password;
    private String passwordConfirm;

	
	public boolean isPwEqualToCheckPw() {
		return password.equals(passwordConfirm);
	}
	
	// Controller에서 RegisterRequest를 로그로 찍었을 때 들어온 값을 확인하는 용도
	@Override
	public String toString() {
	    return "RegisterRequest{" +
	            ", phone='" + phone + '\'' +
	            ", email='" + email + '\'' +
	            ", password='" + password + '\'' +
	            ", passwordConfirm='" + passwordConfirm + '\'' +
	            '}';
	}
}
