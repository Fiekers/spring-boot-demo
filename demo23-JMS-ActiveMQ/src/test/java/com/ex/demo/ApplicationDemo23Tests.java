package com.ex.demo;


import com.ex.demo.component.JmsComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// 需要创建好数据库，没有做自动创建的设置
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationDemo23Tests {
	@Autowired
	private JmsComponent jmsComponent;

	@Test
	public void send() {
		jmsComponent.send("hello world");
	}
}
