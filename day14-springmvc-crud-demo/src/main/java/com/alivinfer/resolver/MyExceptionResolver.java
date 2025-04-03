package com.alivinfer.resolver;

import com.alivinfer.exception.MyException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Fer
 * @version 1.0
 * @description 异常处理器
 * @date 2025/4/2
 */

public class MyExceptionResolver implements HandlerExceptionResolver {
    /**
     * 处理异常并返回一个 ModelAndView 对象
     * 该方法根据异常类型将不同的信息添加到  ModelAndView 对象中，并设置视图名称为 "error"
     *
     * @param request HTTP请求对象
     * @param response HTTP响应对象
     * @param handler 处理请求的处理器对象
     * @param ex 发生的异常对象
     * @return 返回包含异常信息的 ModelAndView 对象
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 创建一个新的ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();

        // 判断异常类型并添加相应的信息
        if (ex instanceof MyException) {
            // 如果是自定义异常，添加"自定义异常"信息
            modelAndView.addObject("info","自定义异常");
        } else if(ex instanceof ClassCastException){
            // 如果是类转换异常，添加"类转换异常"信息
            modelAndView.addObject("info","类转换异常");
        }

        // 设置视图名称为"error"
        modelAndView.setViewName("error");

        // 返回包含异常信息的ModelAndView对象
        return modelAndView;
    }

}
