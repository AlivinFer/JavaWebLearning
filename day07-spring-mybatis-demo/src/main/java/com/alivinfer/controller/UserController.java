package com.alivinfer.controller;

import com.alivinfer.entity.User;
import com.alivinfer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Fer
 * @version 1.0
 * @description controller 层
 * @date 2025/2/27
 */

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 显示所有用户信息的方法。
     */
    public void displayUsers() {
        // 获取所有用户信息
        userService.getAllUsers().forEach(System.out::println);
    }

    public User showUserById(long id) {
        return userService.findUserById(id);
    }

    public void addUser(User user) {
        userService.insertUser(user);
    }

    public void delete(long id) {
        userService.deleteUser(id);
    }

    public void updateUser(User user) {
        userService.updateUser(user);
    }
}
