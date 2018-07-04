package com.ex.demo.component;

import com.ex.demo.bean.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


// Direct：direct 类型的行为是"先匹配, 再投送". 即在绑定时设定一个 routing_key, 消息的routing_key 匹配时, 才会被交换器投送到绑定的队列中去 ,需要在配置Queue的时候,指定一个键,使其和交换机绑定.
// Topic：按规则转发消息（最灵活）
// Headers：设置header attribute参数类型的交换机
// Fanout：转发消息到所有绑定队列
@Component
public class AmqpComponent {
    @Autowired
    private AmqpTemplate amqpTemplate;

    // 同一个队列多个监听，可能会出现异常，不建议如下使用
    // direct
    // public void send(User user) {
    //     this.amqpTemplate.convertAndSend("demo.queue", user);
    // }
    // @RabbitListener(queues = "demo.queue")
    // public void receiveQueue(User user) {
    //     System.out.println("接受到：" + user.toString());
    // }

    // direct
    public void send(int i) {
        this.amqpTemplate.convertAndSend("demo.queue", i);
    }

    public void send(String msg) {
        this.amqpTemplate.convertAndSend("demo.queue", msg);
    }

    @RabbitListener(queues = "demo.queue")
    public void receiveQueue(String text) {
        System.out.println("接受到：" + text);
    }
}