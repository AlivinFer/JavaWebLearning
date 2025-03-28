package com.alivinfer.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Fer
 * @version 1.0
 * @description 系统异常
 * @date 2025/3/27
 */

@Setter
@Getter
public class SystemException extends RuntimeException{

    private Integer code;

    public SystemException(Integer code) {
        this.code = code;
    }

    public SystemException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
