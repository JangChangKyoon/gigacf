package com.example.gigacf.v2.user.login;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class LoginVo {
	
	@NotEmpty(message = "휴대폰번호를 입력해주세요")
	private String phone;
	
	@NotEmpty(message = "비밀번호를 입력해주세요")
	private String password;
	private boolean rememberPhone;
	
}
