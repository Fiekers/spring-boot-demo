package com.ex.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

@ServletComponentScan
@SpringBootApplication
@ImportResource(locations = { "classpath:druid-bean.xml" })
public class ApplicationDemo31 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDemo31.class, args);
	}
}
