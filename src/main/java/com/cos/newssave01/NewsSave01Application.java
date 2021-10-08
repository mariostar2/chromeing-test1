package com.cos.newssave01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class NewsSave01Application {

	public static void main(String[] args) {
		SpringApplication.run(NewsSave01Application.class, args);
	}

}
