package com.alivinfer;

import com.alivinfer.config.AppConfig;
import com.alivinfer.controller.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Fer
 * @version 1.0
 * @description 启动类
 * @date 2025/2/25
 */

public class Main {
    public static void main(String[] args) {

        // 创建 Spring 应用程序上下文（使用反射技术）
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 获取 bean 实例
        UserController userController = context.getBean(UserController.class);

        userController.showUser(1);

        // 关闭应用程序上下文，释放所有资源
        context.close();

    }
}
