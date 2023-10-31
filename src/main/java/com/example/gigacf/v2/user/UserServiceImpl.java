package com.example.gigacf.v2.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.gigacf.comm.exception.AlreadyExistingEmailException;
import com.example.gigacf.comm.exception.AlreadyExistingPhoneException;

@Service("userService")
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
	 * @Autowired @Qualifier("m1") private UserDao userDao;
	 */

	@Override
	public void register(RegisterRequest registerRequest) throws Exception {

		// 이메일 중복 확인
		UserVo email = userDao.selectByEmail(registerRequest.getEmail());
		if (email != null) {
			throw new AlreadyExistingEmailException(registerRequest.getEmail() + " Already Existing");
		}

		UserVo phone = userDao.selectById(registerRequest.getPhone());
		if (phone != null) {
			throw new AlreadyExistingPhoneException(registerRequest.getPhone() + " Already Existing");
		}

		userDao.insertUser(registerRequest);
	}
}
