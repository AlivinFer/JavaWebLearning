package com.alivinfer.dao.impl;

import com.alivinfer.dao.UserDao;

/**
 * @author Fer
 * @version 1.0
 * @description UserDao 实现类
 * @date 2025/2/23
 */

public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("UserDao save method running");
    }
}
