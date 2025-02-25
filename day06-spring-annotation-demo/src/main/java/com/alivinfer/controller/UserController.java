package com.alivinfer.controller;

import com.alivinfer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Fer
 * @version 1.0
 * @description 控制层
 * @date 2025/2/25
 */

@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    public void showUser(int id) {
        logger.info("这是 INFO 级别的日志信息");
        logger.debug("这是 DEBUG 级别的日志信息");
        System.out.println("执行具体的业务: " + userService.getUser(id));
    }
}
