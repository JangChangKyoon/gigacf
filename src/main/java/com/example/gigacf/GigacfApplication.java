package com.example.gigacf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 필터에서 URL인식할 수 있도록 해줌
@SpringBootApplication
public class GigacfApplication {

	public static void main(String[] args) {
		SpringApplication.run(GigacfApplication.class, args);
	}

}
