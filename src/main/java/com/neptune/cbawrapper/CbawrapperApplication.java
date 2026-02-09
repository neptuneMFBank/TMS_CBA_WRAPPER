package com.neptune.cbawrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class CbawrapperApplication {
	public static void main(String[] args) {
		System.out.println("Hello world 1");
		SpringApplication.run(CbawrapperApplication.class, args);
	}

}
