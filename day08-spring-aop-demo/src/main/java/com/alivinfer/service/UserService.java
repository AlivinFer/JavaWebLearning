package com.alivinfer.service;

import org.springframework.stereotype.Service;

/**
 * @author Fer
 * @version 1.0
 * @description 用户服务类
 * @date 2025/3/1
 */

@Service
public class UserService {

    public String getUserById(long id) {
        System.out.println("execution getUserById.");
        return "User_ " + id;
    }

    public void throwException() {
        throw new RuntimeException("Test exception");
    }
}
