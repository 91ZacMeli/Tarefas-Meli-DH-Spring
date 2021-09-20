package com.example.desafiospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EndPointPing {

    @ResponseBody
    @GetMapping("/ping")
    public String ping() {
        return "Pong";
    }
}
