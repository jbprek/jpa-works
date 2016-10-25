package org.bagab.simpleshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EnableAutoConfiguration
public class SimpleShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleShopApplication.class, args);
	}
}
