package com.example.gigacf.v2.user;

import com.example.gigacf.v2.user.login.LoginSessionVo;
import com.example.gigacf.v2.user.login.LoginVo;
import com.example.gigacf.v2.user.register.RegisterVo;

public interface UserService {
	void register(RegisterVo registerVo) throws Exception;
	
	LoginSessionVo login(LoginVo loginVo) throws Exception;
}
