package com.alivinfer.config;

import jakarta.servlet.Filter;
import org.springframework.lang.NonNull;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Fer
 * @version 1.0
 * @description servlet 配置类
 * @date 2025/3/20
 */

public class ServletContainerInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    /**
     * 获取 Servlet 的映射路径
     * 将 tomcat 服务器上的请求拦截到 MVC 中指定路径
     *
     * @return 返回Servlet的映射路径数组
     */
    @Override
    @NonNull
    protected String[] getServletMappings() {
        // 返回一个包含根路径的字符串数组
        return new String[]{"/"};
    }


    // 乱码处理
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UT-8");
        return new Filter[]{filter};
    }
}
