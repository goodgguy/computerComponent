package com.computer.computerConponents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"com.computer"})
@EntityScan(basePackages = {"com.computer.entity"})
public class ComputerConponentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerConponentsApplication.class, args);
	}

}
