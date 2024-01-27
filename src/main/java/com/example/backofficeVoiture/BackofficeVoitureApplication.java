package com.example.backofficeVoiture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class BackofficeVoitureApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackofficeVoitureApplication.class, args);
	}

}
