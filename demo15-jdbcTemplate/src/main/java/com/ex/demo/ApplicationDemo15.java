package com.ex.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ApplicationDemo15 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDemo15.class, args);
	}
}
