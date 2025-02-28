package com.alivinfer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Fer
 * @version 1.0
 * @description Spring 配置类
 * @date 2025/2/27
 */

@Configuration
@ComponentScan(basePackages = "com.alivinfer")
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {
}
