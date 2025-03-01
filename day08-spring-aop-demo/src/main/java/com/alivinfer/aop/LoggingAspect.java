package com.alivinfer.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Fer
 * @version 1.0
 * @description 日志切面类
 * @date 2025/3/1
 */

@Component
@Aspect
public class LoggingAspect {

    // 定义切点：匹配所有 service 包下的方法
    @Pointcut("execution(* com.alivinfer.service.*.*(..))")
    public void serviceMethods() {}

    // Before 通知：在目标方法执行前执行
    @Before("serviceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[日志] Before executing method: " + methodName);
    }

    // After 通知：在目标方法执行后执行
    @After("serviceMethods()")
    public void logAfter() {
        System.out.println("[日志] 方法执行后");
    }

    // Around 通知：环绕目标方法执行
    @Around("serviceMethods()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        // 获取方法参数
        for (Object arg : proceedingJoinPoint.getArgs()) {
            System.out.println("获取参数：" + arg);
        }
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println("Around method: " + methodName + " - before execution");
        // 执行目标方法
        Object result = proceedingJoinPoint.proceed();
        System.out.println("Around method: " + methodName + " - after execution");
        return result;
    }

    // AfterReturning 通知：在目标方法成功返回后执行
    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("After returning from method: " + methodName + ", result: " + result);
    }

    // AfterThrowing 通知：在目标方法抛出异常后执行
    @AfterThrowing(pointcut = "serviceMethods()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Exception in method: " + methodName + ", exception: " + exception.getMessage());
    }
}
