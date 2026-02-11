package com.neptune.cbawrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class CbawrapperApplication {
	public static void main(String[] args) {
		String formattedDate = LocalDate.now().toString();
		System.out.println(formattedDate);
		SpringApplication.run(CbawrapperApplication.class, args);
	}

}
