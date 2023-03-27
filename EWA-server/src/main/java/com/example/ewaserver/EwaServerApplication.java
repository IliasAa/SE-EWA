package com.example.ewaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class EwaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EwaServerApplication.class, args);
	}

}
