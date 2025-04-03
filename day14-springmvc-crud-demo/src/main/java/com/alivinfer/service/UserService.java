package com.alivinfer.service;

import com.alivinfer.domain.User;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 用户服务类
 * @date 2025/3/30
 */
public interface UserService {

    List<User> list();

    void save(User user, Long[] roleIds);

    void del(Long userId);
}
