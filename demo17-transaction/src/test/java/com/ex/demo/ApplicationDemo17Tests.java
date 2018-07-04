package com.ex.demo;

import com.ex.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// 需要创建好数据库，没有做自动创建的设置
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationDemo17Tests {

    @Autowired
    private UserService userService;

    @Test
    public void register() {
        try{
            String result = userService.register("无境", "192.168.1.1");
            System.out.println("====>");
            System.out.println(result);
        }catch (Exception e){
            System.out.println("====>error:");
            e.printStackTrace();
        }
    }
}
