package com.example.gigacf.v2.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.gigacf.comm.exception.customException.*;
import com.example.gigacf.v2.user.login.LoginSessionVo;
import com.example.gigacf.v2.user.login.LoginVo;
import com.example.gigacf.v2.user.register.RegisterVo;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

	/* @Resource
	 * - 자바에서 지원하는 어노테이션 
	 * - 특정 프레임워크에 종성되지 않는다. 
	 * - name 속성의 이름을 기준으로 찾습니다. 없으면 타입,
	 * 없으면@Qualifier 어노테이션의 유무를 찾아 그 어노테이션이 붙은 속성에 의존성을 주입
	 */
	@Resource(name = "userDao") 
	private UserDao userDao;

	 
	/* @Autowired
	 * - Spring에서 지원
	 * - 객체의 타입이 일치하는지를 찾고 객체를 자동으로 주입
	 * - @Qualifier name을 설정해 줄 수 있다. 
	 */
	 //@Autowired @Qualifier("m1") private UserDao userDao;


	/*회원가입*/
	@Override
	public void register(RegisterVo registerVo) throws Exception {

		// 이메일 중복 확인
		UserVo email = userDao.selectByEmail(registerVo.getEmail());
		if (email != null) {
			throw new AlreadyExistingEmailException(registerVo.getEmail() + " Already Existing");
		}

		UserVo phone = userDao.selectByPhone(registerVo.getPhone());
		if (phone != null) {
			throw new AlreadyExistingPhoneException(registerVo.getPhone() + " Already Existing");
		}

		userDao.insertUser(registerVo);
	}
	
	/*로그인*/
	@Override
	public LoginSessionVo login(LoginVo loginVo) throws Exception {
		UserVo user = userDao.selectByPhone_entireOneRow(loginVo.getPhone());
		if(user == null) {
			throw new NotExistingPhoneException("휴대폰이 존재하지 않습니다");
		}
		if(!user.matchPassword(loginVo.getPassword())) {
			throw new NotMatchingPasswordException("비밀번호가 일치하지 않습니다");
		}
		return new LoginSessionVo(user.getPhone(), user.getEmail(), user.getRole());
	}
}
