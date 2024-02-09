package com.qa.baetraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;


@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class BaeSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaeSpringApplication.class, args);
	}
}
