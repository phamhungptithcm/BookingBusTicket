package com.bookingbusticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
@PropertySource("classpath:/properties/mail.properties")
@PropertySource("classpath:/properties/database.properties")
@PropertySource("classpath:/properties/secure.properties")
@PropertySource("classpath:/properties/service-path.properties")
@ComponentScan
@EnableTransactionManagement
@SpringBootApplication
public class BookingbusticketsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingbusticketsystemApplication.class, args);
		System.out.println("System started");
	}
}
