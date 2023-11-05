package com.example.gigacf.v2.user;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVo {
	
	private String no;
    private String name;
    private String phone;
    private UserRole role;
    private String password;
    private String email;
	private String reg_day;
	private String mod_day;
	
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}
}
