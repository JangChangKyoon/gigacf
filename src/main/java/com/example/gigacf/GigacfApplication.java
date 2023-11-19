package com.example.gigacf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ServletComponentScan // 필터에서 URL인식할 수 있도록 해줌
@SpringBootApplication
@ComponentScan(
        basePackages = "com.example.gigacf",
        	    excludeFilters = {
        	            @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.example\\.gigacf\\.v1\\..*"),
        	            @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.example\\.gigacf\\.comm\\..*")
        	        })
public class GigacfApplication {

	public static void main(String[] args) {
		SpringApplication.run(GigacfApplication.class, args);
	}

}
