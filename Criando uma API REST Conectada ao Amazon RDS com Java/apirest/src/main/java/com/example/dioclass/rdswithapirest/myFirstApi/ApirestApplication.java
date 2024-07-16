package com.example.dioclass.rdswithapirest.myFirstApi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApirestApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApirestApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (PersonRepository repository) {
		return args -> {
			repository.save(new Person("Lucas", "Silva"));
			repository.save(new Person("Juliana", "Silva"));
		};
	}
	/*
	@Bean
	public CommandLineRunner commandLineRunner(PersonRepository personRepository) {
		return args -> {
			personRepository.save(new Person("João","Silva"));
			personRepository.save(new Person("Maria","Antonieta"));
			personRepository.save(new Person("Ada","Lovace"));
		};
	}
	 */




}
