package com.mwave.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailApplication implements ApplicationRunner {

    @Autowired
	MailService mailService;

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Executando...");
		
		mailService.sendMail();

	}
}
