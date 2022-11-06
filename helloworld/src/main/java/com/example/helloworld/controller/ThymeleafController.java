package com.example.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import  javax.servlet.http.HttpServletRequest;

@Controller
public class ThymeleafController {
    //req: http://localhost:8080/thymeleaf
    @GetMapping("/thymeleaf")
    public String hello(HttpServletRequest request, @RequestParam(value = "description", required = false, defaultValue = "springboot-thymeleaf") String description){
        // 这个request就是html对象
        request.setAttribute("description", description);
        return "thymeleaf";
    }
}
