package com.alivinfer;

import com.alivinfer.config.SpringConfig;
import com.alivinfer.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Fer
 * @version 1.0
 * @description Main 测试
 * @date 2025/3/4
 */

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountService accountService = context.getBean(AccountService.class);

        try {
            accountService.transfer("Alice", "Bob", 200);
        } catch (Exception e) {
            System.out.println("转账失败，事务已回滚：" + e.getMessage());
        }

        context.close();
    }
}
