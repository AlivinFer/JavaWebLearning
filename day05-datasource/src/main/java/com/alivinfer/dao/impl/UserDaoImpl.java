package com.alivinfer.dao.impl;

import com.alivinfer.dao.UserDao;

/**
 * @author Fer
 * @version 1.0
 * @description TODO
 * @date 2025/2/24
 */

public class UserDaoImpl implements UserDao {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void save() {
        System.out.println("userDao save\n" + name);
    }
}
