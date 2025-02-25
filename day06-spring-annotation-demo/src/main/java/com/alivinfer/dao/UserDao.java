package com.alivinfer.dao;

import org.springframework.stereotype.Repository;

/**
 * @author Fer
 * @version 1.0
 * @description 数据访问层
 * @date 2025/2/25
 */
@Repository
public class UserDao {
    public String findUserById(int id) {
        return "User_" + id;
    }
}
