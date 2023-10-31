package com.example.gigacf.v2.user;

import org.springframework.stereotype.Repository;

import com.example.gigacf.comm.AbstractDAO;

/**
 ** DAO 설정(feat @Repository)
 * @Repository를 사용하여 class로 DAO를 만듦(@Mapper의 경우 Interface임)
 * 이 경우, UserVo를 통해 encapsulted 상태로 로직을 관리하기 좋고,
 * 가독성도 상대적으로 더 좋음.
 * 또한, Mapper.xml에 접근할 때 namespace를 @Repository "userDao"로 하여도 접근할 수 있음.
 * 이 밖에도 아래처럼 Mapper.xml의 namespace를 먼저 지정하고, selectOne("user.selectByEmail", email)처럼 augument를 지정하여 접근 할 수 있음.
 * */
@Repository("userDao") // 서비스에 DI 주입할 때 사용할 이름 지정
public class UserDao extends AbstractDAO {
	public UserVo selectByEmail(String email) {
		/** return문 분석
		 * 1. selectOne은 AbstractDAO에서 상속받은 메소드를 사용한 것 
		 * 2. Augument 설명 
		 * - user는 mapper.xml의 namespace, 
		 * - selectByEmail는 mapper.xml의 queryId 
		 * - 위 두개의 일종의 주소를 통해서 email값을 퀴리로 전달해 준다.
		 * - interface(@Mapper사용)의 경우와 mapper.xml과 연결하는 방식이 상이하다. 
		 */
		return (UserVo) selectOne("user.selectByEmail", email);
	}

	
	public UserVo selectById(String phone) { return
	(UserVo)selectOne("user.selectByPhone", phone); }
	
	public void insertUser(RegisterRequest registerRequest) {
		insert("user.register", registerRequest);
	}
}
