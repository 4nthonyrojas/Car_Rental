package com.cibertec.carsystemconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class CarSystemConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarSystemConfigServerApplication.class, args);
	}

}
