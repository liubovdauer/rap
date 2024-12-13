package de.dauer.rap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "de.dauer.rap.antrag")
public class RapApplication {

	public static void main(String[] args) {
		SpringApplication.run(RapApplication.class, args);
		System.out.println("Hello world!");
	}
}




