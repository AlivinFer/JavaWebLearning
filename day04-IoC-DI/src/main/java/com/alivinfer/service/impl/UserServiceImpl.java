package com.alivinfer.service.impl;

import com.alivinfer.dao.UserDao;
import com.alivinfer.dao.impl.UserDaoImpl;
import com.alivinfer.service.UserService;

/**
 * @author Fer
 * @version 1.0
 * @description 用户服务实现类
 * @date 2025/2/23
 */

public class UserServiceImpl implements UserService {

    // 5.删除业务层中使用 new 创建的 dao 对象
//    private UserDao userDao = new UserDaoImpl();

    private UserDao userDao;

    @Override
    public void save() {
        System.out.println("UserService save  method running");
        userDao.save();
    }

    // 6.提供对应的 set 方法提供 dao 对象
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
