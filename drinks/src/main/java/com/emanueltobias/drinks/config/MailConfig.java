package com.emanueltobias.drinks.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource(value = { "file://${HOME}/.drinks-mail.properties" }, ignoreResourceNotFound = true)
public class MailConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.sendgrid.net");
		mailSender.setPort(587);
		mailSender.setUsername(env.getProperty("drinks.mail.username"));
		mailSender.setPassword(env.getProperty("drinks.mail.password"));
		
	/*	System.out.println(mailSender.getUsername());
		System.out.println("senha: " + env.getProperty("password"));
		*/
		
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.debug", false);
		props.put("mail.smtp.connectiontmeout", 10000);
		
		mailSender.setJavaMailProperties(props);
		
		
		return mailSender;
	}

}
