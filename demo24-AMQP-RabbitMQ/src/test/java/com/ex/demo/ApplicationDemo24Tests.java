package com.ex.demo;


import com.ex.demo.bean.User;
import com.ex.demo.component.AmqpComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

// 需要创建好数据库，没有做自动创建的设置
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationDemo24Tests {
	@Autowired
	private AmqpComponent amqpComponent;

	@Test
	public void sendDirect() {
		amqpComponent.send(1);
		amqpComponent.send("Hello World!!!");
	}
}
