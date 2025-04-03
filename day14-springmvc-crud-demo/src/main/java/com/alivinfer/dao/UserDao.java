package com.alivinfer.dao;

import com.alivinfer.domain.User;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 用户 Dao 接口
 * @date 2025/3/29
 */
public interface UserDao {

    List<User> findAll();

    Long save(User user);

    void saveUserRoleRel(Long userId, Long[] roleIds);

    void delUserRoleRel(Long userId);

    void del(Long userId);
}
