package com.example.gigacf.v2.user;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVo {
	
	private String id;

    private String name;

    private String password;

    private String passwordConfirm;
 
    private String email;

    private String phone;
    
    private UserRole role;
    
	private String reg_day;
	
	private String mod_day;
}
