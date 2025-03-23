package com.alivinfer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Fer
 * @version 1.0
 * @description SpringMvc 配置类
 * @date 2025/3/20
 */

@Configuration
@ComponentScan({"com.alivinfer.controller", "com.alivinfer.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
