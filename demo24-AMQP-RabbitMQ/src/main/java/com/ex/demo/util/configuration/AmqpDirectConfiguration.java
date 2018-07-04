package com.ex.demo.util.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息队列
 */
@Configuration
public class AmqpDirectConfiguration {

    @Bean
    public Queue queue(){
        return new Queue("demo.queue");
    }
}