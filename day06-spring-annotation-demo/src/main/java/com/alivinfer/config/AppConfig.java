package com.alivinfer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Fer
 * @version 1.0
 * @description Spring 配置类
 * @date 2025/2/25
 */

// @Configuration 代替之前的 xml 配置，@ComponentScan 指定扫描组件的位置
@Configuration
@ComponentScan(basePackages = "com.alivinfer")
public class AppConfig {
}
