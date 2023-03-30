package com.epicminds.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class SpringBootRestJpaDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestJpaDemoApplication.class, args);
	}

}
