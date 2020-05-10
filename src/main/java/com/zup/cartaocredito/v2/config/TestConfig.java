package com.zup.cartaocredito.v2.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zup.cartaocredito.v2.service.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDataBase() throws ParseException {
		
		dbService.instanciateTestDatabase();
		
		return true;
	}
	
//	@Bean
//	public EmailService emailService() {
//		return new SmtpEmailService();
//	}
}

