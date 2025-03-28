package com.alivinfer.config;

import org.springframework.lang.NonNull;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Fer
 * @version 1.0
 * @description Servlet 配置
 * @date 2025/3/24
 */

public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 获取根配置类数组
     * 该方法返回一个包含 Spring 配置类的数组，用于初始化 Spring 应用上下文
     *
     * @return 返回包含 Spring 配置类的数组
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // 返回包含Spring配置类的数组
        return new Class[]{SpringConfig.class};
    }


    /**
     * 获取 Servlet 配置类数组。
     * 该方法用于返回 Spring MVC 配置类，以便在 Web 应用中进行配置。
     *
     * @return 返回包含Spring MVC配置类的数组
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        // 返回包含SpringMvcConfig类的数组
        return new Class[]{SpringMvcConfig.class};
    }


    /**
     * 获取 Servlet 的映射路径。
     * 该方法重写了父类的方法，并返回一个包含根路径的字符串数组
     *
     * @return 返回Servlet的映射路径数组
     */
    @Override
    @NonNull
    protected String[] getServletMappings() {
        // 返回一个包含根路径的字符串数组
        return new String[]{"/"};
    }
}
