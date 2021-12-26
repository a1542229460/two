package com.example.testgit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("test")
public class Test {
    @GetMapping("index")
    public String test(){
        return "success";
    }

    @GetMapping("index2")
    public String test2(){
        return "success";
    }
}
