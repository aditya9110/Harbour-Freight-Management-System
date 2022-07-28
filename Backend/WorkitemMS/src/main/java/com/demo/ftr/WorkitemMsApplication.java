package com.demo.ftr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WorkitemMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkitemMsApplication.class, args);
	}

}
