package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		Logger logger = Logger.getLogger(Application.class.getName());
		logger.log(Level.INFO, "API REST Start !");
	}	
}
