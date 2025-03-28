package com.alivinfer.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Fer
 * @version 1.0
 * @description 业务异常
 * @date 2025/3/27
 */

@Setter
@Getter
public class BusinessException extends RuntimeException{

    private Integer code;

    public BusinessException(Integer code) {
        this.code = code;
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
