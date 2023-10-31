package com.example.gigacf.v2.user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/** 유효성 검사 절차
 * 1. 컨트롤러 메소드에서 formData를 바인딩
 * 2. 그리고, 그 컨트롤러 메소드가 Validator 객체를 생성(요렇게.. new RegisterRequestValidator().validate(registerRequest, errors);)
 * 3. 이로서, Validator 객체가 내부 메소드를 통해 RegisterRequest 객체 생성
 * 4. 이렇게 RegisterRequest 객체가 도매인 역할을 하며, 여기에 formData의 값들이 저장됨.
 * 5. validate 메소드가 RegisterRequest 객체에 저장된 값들을 꺼내와서 유효성 검사함.
 * */

public class RegisterRequestValidator implements Validator {

	private static final String EMAILREGEXP = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PHONEREGEXP = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
	private Pattern emailPattern;
	private Pattern phonePattern;
	public RegisterRequestValidator() {
		emailPattern = Pattern.compile(EMAILREGEXP);
		phonePattern = Pattern.compile(PHONEREGEXP);
	}

	/** 1단계
	 * 도메인 타입 검증
	 * RegisterRequest가 클래스인지 검증하는 메소드
	 * 클래스만 아래 formData를 검증하는 메소드로 검증 가능하기 때문. 
	 **/
	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterRequest.class.isAssignableFrom(clazz);
	}
	
	/** 2단계 
	 * formData 바인딩한 하여 RegisterRequest 저장된 값들 유효성 검사하는 메소드 
	 * 클라이언트가 작성한 formdata애 유효성 오류가 발생하면, Model과 함께 error 객체를 view로 보낼 수 있게해주며,
	 * 유효성 검사 실패로 인한 에러와 메시지를 view 출력할 수 있도록 해준다.
	 * */
	@Override
	public void validate(Object target, Errors errors) {
		// 1. Spring MVC가 parameter로 등로온 정보를 가지고 registerRequest(domain)의 객체를 만들고 필드를
		// setting 해줌
		// ※ target은 parameter로 받아온 formdata를 binding한 것
		RegisterRequest registerRequest = (RegisterRequest) target;

		// 2. formdata를 통해 등록된 registerRequest의 필드의 유효성을 검사 로직
		// 1) phone 검증
		if (registerRequest.getPhone() == null || registerRequest.getPhone().trim().isEmpty()) {
			errors.rejectValue("phone", "required", "필수 정보입니다.");
		} else {
			Matcher matcher = phonePattern.matcher(registerRequest.getPhone());
			if (!matcher.matches()) {
				errors.rejectValue("phone", "bad", "올바르지 않은 형식입니다.");
			}
		}

		// 2) email 검증
		if (registerRequest.getEmail() == null || registerRequest.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required", "필수 정보입니다.");
		} else {
			Matcher matcher = emailPattern.matcher(registerRequest.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "bad", "올바르지 않은 형식입니다^^;");
			}
		}

		// 3) name 검증
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required", "필수 정보입니다.");

		// 4) password 검증
		ValidationUtils.rejectIfEmpty(errors, "password", "required", "필수 정보임..!");
		ValidationUtils.rejectIfEmpty(errors, "passwordConfirm", "required", "필수 정보임..!");
		if (!registerRequest.getPassword().isEmpty()) {
			if (!registerRequest.isPwEqualToCheckPw()) {
				errors.rejectValue("passwordConfirm", "nomatch", "비번 미일치");
			}
		}

	}
}
