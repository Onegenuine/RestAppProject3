package ru.falaleev.pets.RestAppProject3;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestAppProject3Application {

	public static void main(String[] args) {
		SpringApplication.run(RestAppProject3Application.class, args);
	}

//внедрили бин ModelMapper в прогармму через спринг
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
