package com.alivinfer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Fer
 * @version 1.0
 * @description userController
 * @date 2025/3/9
 */

@Controller
public class UserController {

    /**
     * 处理保存用户的请求
     * 该方法用于处理 HTTP GET 请求，保存用户信息，并返回 JSON 格式的响应
     *
     * @return 返回包含保存信息的 JSON 字符串
     */
    @GetMapping("/save")
    @ResponseBody
    public String save() {
        // 打印保存用户信息的日志
        System.out.println("user save...");

        // 返回包含保存信息的JSON字符串
        return "{'info': 'springmvc'}";
    }

}
