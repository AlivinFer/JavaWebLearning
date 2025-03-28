package com.alivinfer.controller;

import com.alivinfer.exception.BusinessException;
import com.alivinfer.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Fer
 * @version 1.0
 * @description 工程异常处理
 * @date 2025/3/26
 */

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(BusinessException.class)
    public Result businessException(BusinessException businessException) {
        //开发过程中发生业务异常需要进行如下操作
        //1.记录日志
        //2.发送消息给运维
        //3.发送邮件给开发人员，ex对象发送给开发人员
        return new Result(Code.BUSINESS_ERR, null, businessException.getMessage());
    }

    @ExceptionHandler(SystemException.class)
    public Result systemException(SystemException systemException) {
        return new Result(Code.SYSTEM_ERR, null, systemException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex) {
        return new Result(Code.SYSTEM_UNKNOWN_ERR, null, "系统繁忙，请稍后再试！");
    }
}
