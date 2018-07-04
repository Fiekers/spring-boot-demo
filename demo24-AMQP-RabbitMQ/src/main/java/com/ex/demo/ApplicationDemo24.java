package com.ex.demo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

// 需要创建好数据库，没有做自动创建的设置
@EnableRabbit
@EnableCaching
@ServletComponentScan
@SpringBootApplication
public class ApplicationDemo24 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDemo24.class, args);
	}
}
