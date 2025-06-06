package com.alivinfer.controller;

/**
 * @author Fer
 * @version 1.0
 * @description 请求状态码
 * @date 2025/3/26
 */

public class Code {

    public static final Integer SAVE_OK= 20011;
    public static final Integer DELETE_OK = 20021;
    public static final Integer UPDATE_OK = 20031;
    public static final Integer GET_OK = 20041;
    public static final Integer GET_ALL_OK = 20051;

    public static final Integer SAVE_ERR = 20010;
    public static final Integer DELETE_ERR = 20020;
    public static final Integer UPDATE_ERR = 20030;
    public static final Integer GET_ERR = 20040;
    public static final Integer GET_ALL_ERR = 20050;

    public static final Integer SYSTEM_UNKNOWN_ERR = 404;
    public static final Integer SYSTEM_ERR = 50001;
    public static final Integer SYSTEM_TIMEOUT_ERR = 50002;

    public static final Integer BUSINESS_ERR = 60003;

}
