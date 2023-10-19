package com.example.gigacf.comm;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor()) // MyInterceptor을 객체로 인자로 전달
			.addPathPatterns("/**") // 적용한 경로
			.excludePathPatterns("/css/**", "/*.ico", "/error"); // 제외할 경로
		    //※ 참고시항 path : controller의 requestMapping에 설정된 경로..
	}
}
