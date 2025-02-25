package com.alivinfer.service;

import com.alivinfer.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Fer
 * @version 1.0
 * @description 业务逻辑层
 * @date 2025/2/25
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public String getUser(int id) {
        return userDao.findUserById(id);
    }
}
