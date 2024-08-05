package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("sql.properties")

public class SpringBootRestApiProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiProject1Application.class, args);
	}

}
