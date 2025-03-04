package com.alivinfer.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author Fer
 * @version 1.0
 * @description Spring 配置类
 * @date 2025/3/4
 */

@Configuration
@ComponentScan(basePackages = "com.alivinfer")  // 自动扫描组件
@PropertySource("classpath:jdbc.properties")  // 读取数据库配置
@EnableTransactionManagement  // 开启事务管理
@MapperScan("com.alivinfer.mapper")  // MyBatis 扫描 Mapper
public class SpringConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    /**
     * 配置数据源事务管理器的 Bean
     *
     * @param dataSource 数据源对象
     * @return 返回一个 DataSourceTransactionManager 实例
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        // 创建并返回一个DataSourceTransactionManager实例，使用提供的数据源进行事务管理
        return new DataSourceTransactionManager(dataSource);
    }

    // 配置 MyBatis SqlSessionFactory
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }
}
