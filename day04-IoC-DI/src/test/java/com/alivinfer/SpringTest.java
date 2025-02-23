package com.alivinfer;

import com.alivinfer.dao.UserDao;
import com.alivinfer.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Fer
 * @version 1.0
 * @description Sping 测试类
 * @date 2025/2/23
 */

public class SpringTest {

    @Test
    public void test() {

        // 获取 IoC 容器
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        // 获取 bean
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }

    @Test
    public void test1() {

        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        // bean 默认是单例模式，获取到的对象是同一个
        // 通过配置文件中的 scope = prototype 设置原型模式，可创建不同的对象
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        UserDao userDao1 = (UserDao) applicationContext.getBean("userDao");
        System.out.println(userDao);
        System.out.println(userDao1);
    }
}
