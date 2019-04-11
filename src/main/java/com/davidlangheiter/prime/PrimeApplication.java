package com.davidlangheiter.prime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeApplication.class, args);
	}

	@Bean
	public Searcher searcher() {
		return new Searcher();
	}

}
