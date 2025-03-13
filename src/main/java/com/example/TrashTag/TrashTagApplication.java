package com.example.TrashTag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class})
public class TrashTagApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrashTagApplication.class, args);
	}

}
