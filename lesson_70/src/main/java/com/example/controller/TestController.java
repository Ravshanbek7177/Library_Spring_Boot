package com.example.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public String currentTime() {
        System.out.println("mazgi");
        return LocalDateTime.now().toString();
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String initMethod() {
        return "Init";
    }


}
