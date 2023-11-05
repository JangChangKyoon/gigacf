package com.example.gigacf.v2.user.login;

import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.gigacf.comm.exception.NotExistingPhoneException;
import com.example.gigacf.comm.exception.NotMatchingPasswordException;
import com.example.gigacf.v2.user.UserService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/v2/user/login")
public class LoginCon {

	@Resource(name = "userService")
	private UserService userServce;

	/** 로그인 페이지 이동
	 * + 아이디 저장 쿠키가 있는지 확인해서 input value 자동 채우기 기능
	 */
	@GetMapping("/loginForm")
	public ModelAndView loginForm(LoginVo loginVo,
			@CookieValue(value = "RememberLoginInfo", required = false) Cookie rememberCookie) throws Exception {

		/**
		 * 쿠키에 저장된 정로를 이용하여 View form에 value 입력해주기 phone 입력, 아이디 저장에 체크
		 */
		if (rememberCookie != null) {
			log.info("login Controller__________________exist : " + rememberCookie.getValue());
			loginVo.setPhone(rememberCookie.getValue());
			loginVo.setRememberPhone(true);
		}

		ModelAndView mv = new ModelAndView("/v2/user/login/loginForm");
		return mv;
	}

	/** 로그인(세션쿠키 사용)
	 * 로그인폼에 입력된 내용 유효성 검사
	 * 세션과 쿠시 생성
	 */
	@PostMapping("/loginForm")
	public ModelAndView loginSuccess(@Valid LoginVo loginVo, Errors errors, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("/v2/user/login/loginForm");
			return mv;
		}

		LoginSessionVo loginSessionVo = null;
		try {
			/** 세션 사용 */
			log.info("------Session Creation--------");
			loginSessionVo = userServce.login(loginVo);
		    HttpSession httpSession = httpServletRequest.getSession(); // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성
			httpSession.setAttribute("loginSessionVo", loginSessionVo);  // 세션에 로그인 회원 정보 보관
			httpSession.getAttributeNames().asIterator().forEachRemaining(name -> log.info("session name={}, value={}", name, httpSession.getAttribute(name))); // 세션 정보
			httpSession.setMaxInactiveInterval(30 * 60); // 마지막 세션 접근 기준 30*60초로 세션의 유효시간을 지정 -> 이 시간이 지나면 세션은 만료되어 서버의 메모리에서 사라진다.
			
			/**
			 * 쿠키 사용
			 */
			// 쿠키 객체 생성
			Cookie rememberPhoneCookie = new Cookie("RememberLoginInfo", loginVo.getPhone());
			Cookie identifyLoginCookie = new Cookie("identifyLoginCookie", loginVo.getPhone());
			// 쿠키를 사용가능한 url 범위
			rememberPhoneCookie.setPath("/v2/user/login"); // 로그인 화면에서 아이디 기억하는 용도
			identifyLoginCookie.setPath("/v2"); // 브라우저 화면에서 로그인 여부를 식별하여 로그인버튼과 로그아웃버튼을 구분하여 보여주기 위한 용도
			// 쿠키의 유효기간 설정 
			identifyLoginCookie.setMaxAge(30 * 60);	// 30분으로 설정
			if (loginVo.isRememberPhone()) { // 로그인아이디 기억 쿠키 유효기간 설정
				rememberPhoneCookie.setMaxAge(60 * 60 * 24 * 7); // 7일
			} else {
				rememberPhoneCookie.setMaxAge(0);
			}
			// 쿠키를 브라우저에 등록
			httpServletResponse.addCookie(rememberPhoneCookie); // Response.addCookie : 이걸 해주어야 cookie에 등록이 된다.
			httpServletResponse.addCookie(identifyLoginCookie); // Response.addCookie : 이걸 해주어야 cookie에 등록이 된다.
		} catch (NotMatchingPasswordException e) {
			/**
			 * 에러메시지 view 출력하기 jsp spring form인 <form:errors path="password"/>에 매칭
			 */
			errors.rejectValue("password", "notMatch", "비밀번호 오류가 발생합니다");
			ModelAndView mv = new ModelAndView("/v2/user/login/loginForm");
			return mv;
		} catch (NotExistingPhoneException e) {
			errors.rejectValue("phone", "bad", "phone 오류가 발생합니다");
			ModelAndView mv = new ModelAndView("/v2/user/login/loginForm");
			return mv;
		}

		ModelAndView mv = new ModelAndView("/v2/user/login/loginSuccess");
		Optional<String> email = Optional.ofNullable(loginSessionVo.getEmail());
		email.ifPresent(v -> mv.addObject("email", v));

		return mv;
	}

	/** 로그아웃 
	 * 세션과 쿠키를 삭제하는 페이지 */
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletResponse response, HttpServletRequest request) {
		
		HttpSession httpSession = request.getSession(false); // 세션이 없으면 세션을 생성해주지 않는다.
		   if (httpSession != null) {
			   httpSession.invalidate();
		    }
		   
		// 로그인, 로그아웃 버튼 구분하는 용도의 쿠키 삭제   
		Cookie[] requestCookies = request.getCookies();
	    if (requestCookies != null) {
	        for (Cookie cookie : requestCookies) {
	            if ("identifyLoginCookie".equals(cookie.getName())) {
	                log.info("identifyLoginCookie will be deleted... : " + cookie.getName());
	                cookie.setMaxAge(0); 
	                cookie.setPath("/v2");
	        		response.addCookie(cookie);
	                break; 
	            }
	        }
	    }



		ModelAndView mv = new ModelAndView("/v2/user/login/logout");

		return mv;
	}

}
