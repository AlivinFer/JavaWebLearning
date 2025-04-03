package com.alivinfer.interceptor;

import com.alivinfer.domain.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Fer
 * @version 1.0
 * @description 拦截器
 * @date 2025/4/1
 */

public class PrivilegeInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前进行预处理
     * 该方法检查用户是否已登录，如果未登录则重定向到登录页面
     *
     * @param request HTTP请求对象
     * @param response HTTP响应对象
     * @param handler 请求处理程序
     * @return 如果用户已登录返回 true，否则返回 false
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        System.out.println("拦截的请求：" + uri);

        // 放行的请求列表
        if (uri.endsWith("/user/login") || uri.endsWith("/login.jsp") || uri.endsWith("/login.asp") ||
                uri.startsWith("/css/") || uri.startsWith("/js/") || uri.startsWith("/img/") || uri.startsWith("/plugins/")) {
            return true;
        }

        // 获取当前会话
        HttpSession session = request.getSession();

        // 从会话中获取用户对象
        User user = (User) session.getAttribute("user");

        // 如果用户未登录，重定向到登录页面
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false;
        }

        // 用户已登录，继续处理请求
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Interceptor: 方法执行完毕");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Interceptor: 视图渲染完成");
    }
}
