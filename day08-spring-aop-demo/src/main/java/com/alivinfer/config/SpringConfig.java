package com.alivinfer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Fer
 * @version 1.0
 * @description Spring 配置类
 * @date 2025/2/28
 */

@Configuration
@ComponentScan("com.alivinfer")
@EnableAspectJAutoProxy
public class SpringConfig {
}
