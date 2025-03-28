package com.alivinfer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Fer
 * @version 1.0
 * @description
 * @date 2025/3/24
 */

@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    /**
     * 重写父类的 addResourceHandlers方法，用于添加资源处理器
     * 该方法配置了 Spring MVC 的资源处理器，使得可以通过指定的URL访问静态资源文件
     *
     * @param registry 资源处理器注册表，用于注册资源处理器
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 添加资源处理器，处理以"/pages/**"开头的URL请求
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
    }

}
