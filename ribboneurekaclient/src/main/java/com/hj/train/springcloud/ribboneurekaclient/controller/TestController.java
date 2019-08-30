package com.hj.train.springcloud.ribboneurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/testRibbon")
    public String testRibbon(){

        return "hello";
    }
    @GetMapping("/testRibbonTemplate")
    public String testRibbonTemplate(){

        return restTemplate.getForEntity("http://testeureka/hello",String.class).getBody();
    }

}
