package com.ex.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class ApiController {

    @CrossOrigin(origins = "http://192.168.10.1:8080")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public HashMap<String, Object> get(@RequestParam String name) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title", "hello world");
        map.put("name", name);
        return map;
    }
}