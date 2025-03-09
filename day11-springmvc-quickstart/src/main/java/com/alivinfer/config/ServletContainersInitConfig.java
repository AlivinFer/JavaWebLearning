package com.alivinfer.config;

import org.springframework.lang.NonNull;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * @author Fer
 * @version 1.0
 * @description 初始化 servlet 容器，加载 SpringMVC 环境，并设置 SpringMVC 技术处理的请求
 * @date 2025/3/9
 */

public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {

    /**
     * 创建并配置 Servlet 的 WebApplicationContext
     * 该方法用于初始化 Spring MVC的配置类，并将其注册到 WebApplicationContext 中
     *
     * @return 返回配置好的 WebApplicationContext 实例
     */
    @Override
    @NonNull
    protected WebApplicationContext createServletApplicationContext() {
        // 创建一个基于注解的WebApplicationContext实例
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

        // 注册Spring MVC配置类
        ctx.register(SpringMvcConfig.class);

        // 返回配置好的WebApplicationContext实例
        return ctx;
    }


    /**
     * 获取 Servlet 的映射路径
     * 该方法重写了父类的方法，返回一个包含根路径（"/"）的字符串数组
     *
     * @return 返回一个包含 Servlet 映射路径的字符串数组
     */
    @Override
    @NonNull
    protected String[] getServletMappings() {
        // 返回一个包含根路径（"/"）的字符串数组
        return new String[]{"/web"};
    }


    /**
     * 创建根应用上下文的方法
     * 该方法需要被子类重写以提供具体的实现
     *
     * @return 返回创建的根应用上下文
     */
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        // 返回null，子类需要重写该方法以提供具体的实现
        return null;
    }

}
