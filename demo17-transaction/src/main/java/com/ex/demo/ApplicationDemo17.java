package com.ex.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// 需要创建好数据库，没有做自动创建的设置
@ServletComponentScan
@SpringBootApplication
public class ApplicationDemo17 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDemo17.class, args);
	}
}
