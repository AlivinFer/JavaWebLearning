package com.alivinfer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fer
 * @version 1.0
 * @description controller 测试
 * @date 2025/3/6
 */

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello(Model model) {
        model.addAttribute("message", "Hello, Spring MVC on Java 21!");
        // 返回 WEB-INF/views/hello.jsp
        return "hello";
    }
}
