package com.ex.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ApplicationDemo12 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDemo12.class, args);
	}
}
