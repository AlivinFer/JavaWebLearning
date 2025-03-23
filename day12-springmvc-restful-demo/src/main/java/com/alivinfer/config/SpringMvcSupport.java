package com.alivinfer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Fer
 * @version 1.0
 * @description 资源过滤配置
 * @date 2025/3/23
 */

@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    /**
     * addResourceHandler：定义 URL 路径模式（即客户端访问的路径）
     * addResourceLocations：定义实际的文件系统路径或类路径（即服务器上的资源位置）
     * 该方法配置了 Spring MVC的资源处理器，使得静态资源文件可以通过指定的 URL 路径访问
     *
     * @param registry 资源处理器注册表，用于注册资源处理器
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 添加资源处理器，处理以 "/pages/**" 开头的请求，映射到 "/pages/" 路径下的静态资源文件
        registry.addResourceHandler("/pages/**")
                .addResourceLocations("/pages/");
        registry.addResourceHandler("/js/")
                .addResourceLocations("/js/");
    }

}
