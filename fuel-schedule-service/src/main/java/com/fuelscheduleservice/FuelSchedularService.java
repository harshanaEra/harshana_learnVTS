package com.fuelscheduleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FuelSchedularService {

	public static void main(String[] args) {
		SpringApplication.run(FuelSchedularService.class, args);
	}

}
