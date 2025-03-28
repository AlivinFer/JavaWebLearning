package com.alivinfer.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fer
 * @version 1.0
 * @description 封装返回给前端的协议结构体
 * @date 2025/3/26
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 数据
     */
    private Object data;

    /**
     * 信息说明
     */
    private String msg;
}
