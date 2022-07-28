package com.terminalMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.terminalMS.Controller.FtrTerminalsController;
import com.terminalMS.Service.FtrTerminalsService;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = { "com"})
public class TerminalMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerminalMsApplication.class, args);
		
	}

}
