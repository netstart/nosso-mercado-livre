package com.github.nossomercadolivre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NossomercadolivreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NossomercadolivreApiApplication.class, args);
	}

}
