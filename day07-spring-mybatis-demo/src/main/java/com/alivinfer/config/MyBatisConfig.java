package com.alivinfer.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Fer
 * @version 1.0
 * @description Mybatis 配置
 * @date 2025/2/28
 */

@Configuration
@MapperScan("com.alivinfer.mapper")
public class MyBatisConfig {

    /**
     * 创建并配置一个 SqlSessionFactoryBean 实例
     * 通过设置数据源，确保 SqlSessionFactory 能够正确地连接和管理数据库会话
     * Spring 容器会管理这个 Bean，使其在应用程序中可用
     * 这种方法的使用提高了代码的模块化和可维护性，同时简化了 MyBatis 与 Spring 的集成
     * @param dataSource 数据源
     * @return SqlSessionFactoryBean 实例
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean;
    }
}
