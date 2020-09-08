package com.mani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieRatingInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRatingInfoApplication.class, args);
	}

}
