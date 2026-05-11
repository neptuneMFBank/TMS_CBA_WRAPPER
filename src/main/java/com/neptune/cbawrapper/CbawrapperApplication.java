package com.neptune.cbawrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.DecimalFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class CbawrapperApplication {
	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startDate = LocalDate.parse("2025-09-31", formatter);
		LocalDateTime localDateTime = startDate.atTime(LocalTime.MIDNIGHT);
		ZoneId zone = ZoneId.of("UTC");
		ZonedDateTime zonedDateTime = localDateTime.atZone(zone);
		System.out.println("zonedDateTime = " + zonedDateTime);
		System.out.println("ZonedDateTime.now() = " + ZonedDateTime.now(ZoneId.of("UTC")));
		SpringApplication application = new SpringApplication(CbawrapperApplication.class);
		Environment environment = application.run(args).getEnvironment();
		System.out.println("customer url = " + environment.getProperty("grpc.customer.request.url"));
		System.out.println("customer port = " + environment.getProperty("grpc.customer.request.port"));
		System.out.println("LocalDate.now().toString() = " + LocalDate.now().toString());

		DecimalFormat df = new DecimalFormat("#.00");

		System.out.println("kkmk = " + df.format(4.18400003e+06));
	}

}
