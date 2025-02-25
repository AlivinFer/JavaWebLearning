package com.alivinfer;

import com.alivinfer.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @author Fer
 * @version 1.0
 * @description 测试数据库连接类
 * @date 2025/2/24
 */

public class SpringTest {

    /**
     * 测试 xml 配置 druid 数据源
     */
    @Test
    public void test() {

        // 获取 IoC 容器
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        // 测试 druid 数据源
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource);
    }

    /**
     * 测试 xml 配置 c3p0 数据源
     */
    @Test
    public void test2() {

        // 获取 IoC 容器
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource2");
        System.out.println(dataSource);
    }
    @Test
    public void test3() {
        // 获取 IoC 容器
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContextPro.xml");

        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource);
    }

    @Test
    public void test4() {
        // 获取 IoC 容器
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContextPro.xml");

        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.save();
    }
}
