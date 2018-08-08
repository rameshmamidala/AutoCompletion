/**
 * 
 */
package com.ramesh.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Ramesh
 * 
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.ramesh" })
public class Application {

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
