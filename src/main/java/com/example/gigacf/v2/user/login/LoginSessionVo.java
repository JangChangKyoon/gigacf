package com.example.gigacf.v2.user.login;

import com.example.gigacf.v2.user.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginSessionVo {
	// 회원 정보 세션 유지

	private String phone;
	private String email;
	private UserRole role;

}
