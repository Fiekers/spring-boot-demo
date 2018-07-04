package com.ex.demo.util.configuration;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * jms 队列配置
 *
 */
@Configuration
public class JmsConfiguration {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("demo.queue");
    }

}