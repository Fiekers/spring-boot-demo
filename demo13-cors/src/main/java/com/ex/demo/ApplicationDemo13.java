package com.ex.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ApplicationDemo13 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDemo13.class, args);
	}
}
