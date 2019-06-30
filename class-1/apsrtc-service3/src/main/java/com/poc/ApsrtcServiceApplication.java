package com.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApsrtcServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApsrtcServiceApplication.class, args);
	}

}
