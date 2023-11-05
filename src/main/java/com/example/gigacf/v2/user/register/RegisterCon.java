package com.example.gigacf.v2.user.register;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.gigacf.comm.exception.AlreadyExistingEmailException;
import com.example.gigacf.comm.exception.AlreadyExistingPhoneException;
import com.example.gigacf.v2.user.UserService;

import lombok.extern.log4j.Log4j2;


@Log4j2
@Controller
@RequestMapping("/v2/user")
public class RegisterCon {
	
	@Resource(name = "userService")
	private UserService userService;

	
	/* 1. 약관동의 페이지 */
	@RequestMapping("/register/step1")
	public String getRegisterUser() throws Exception {
		return "/v2/user/register/step1";
	}

	/* 2. 약관동의(true)할 경우 form 입력 화면으로 이동 */
	@RequestMapping("register/step2")
	public ModelAndView step2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree) throws Exception {
		if (!agree) {
			/** ModelAndView 간략 설명
			 * 1. view의 경로를 설정
			 * 2. model의 alias와 key, value를 설정
			 * */
			ModelAndView mv = new ModelAndView("user/register/step1");
			return mv;
		}
		ModelAndView mv = new ModelAndView("/v2/user/register/step2");

		/** 스프링폼과 컨트롤러 매핑 방법
		 * ModelAndView의 메소드인 addObject를 통해서 아래 스프링 form과 연결이 가능하다. 
		 * <form:form modelAttribute="registerVo" ...>
		 */
		mv.addObject("registerVo", new RegisterVo()); // 이렇게 이름을 지정해주어 
		log.info("[UserCon_step2_ModelAttribute - registerVo] : " + mv.getModel().toString());
		return mv;
	}

	/** 3. form에 입력한 데이터 유효성 검사  
	 * view에서 action은 post, url은 /step3로 설정한 경우이다.
	 * formdata 입력한 데이터들은 헨들러에 의해서 이 메소드로 들어오게 된다.
	 * 따라서, 들어온 데이터를 이 메소드에서 유효성 검사하게 된다.
	 * */
	@RequestMapping("register/step3")
	public ModelAndView step3(RegisterVo registerVo, Errors errors) throws Exception {
		// Validation
		new RegisterVoValidator().validate(registerVo, errors); // registerRequest 객체 생성 후 검증
		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("/v2/user/register/step2");
			return mv;
		}

		// 중복검사
		try {
			userService.register(registerVo);
			// 1. 이메일 중복검사
		} catch (AlreadyExistingEmailException e) {
			errors.rejectValue("email", "duplicate", "이미 이메일이 있는거야");
			ModelAndView mv = new ModelAndView("/v2/user/register/step2");
			return mv;
			// 2. 아이디 중복검사
		} catch (AlreadyExistingPhoneException e) {
			errors.rejectValue("phone", "duplicate", "이미 있는 번호야");
			ModelAndView mv = new ModelAndView("/v2/user/register/step2");
			return mv;
		}

		ModelAndView mv = new ModelAndView("/v2/user/register/step3");
		return mv;
	}

}
