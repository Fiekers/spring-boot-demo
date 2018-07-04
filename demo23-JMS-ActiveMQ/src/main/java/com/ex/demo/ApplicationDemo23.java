package com.ex.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jms.annotation.EnableJms;

// 需要创建好数据库，没有做自动创建的设置
@EnableJms
@EnableCaching
@ServletComponentScan
@SpringBootApplication
public class ApplicationDemo23 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDemo23.class, args);
	}
}
