package com.han.cloudconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * han
 * 2021/11/1
 */
@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/test01")
    public Object test01(){
        return restTemplate.getForEntity("http://localhost:8080/test01",String.class).getBody()+"springCloud消费者";
    }
}
