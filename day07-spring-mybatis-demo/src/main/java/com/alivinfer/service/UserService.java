package com.alivinfer.service;

import com.alivinfer.entity.User;
import com.alivinfer.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 用户服务类
 * @date 2025/2/27
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查找所有用户信息
     *
     * @return user 列表
     */
    public List<User> getAllUsers() {
        return userMapper.findAll();
    }

    /**
     * 根据用户ID查找用户。
     *
     * @param id 用户的唯一标识符
     * @return 返回找到的用户对象，如果未找到则返回null
     */
    public User findUserById(long id) {
        return userMapper.findById(id);
    }

    /**
     * 插入用户信息到数据库。
     *
     * @param user 要插入的用户对象
     */
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    /**
     * 删除指定ID的用户。
     *
     * @param id 要删除的用户的ID
     */
    public void deleteUser(long id) {
        userMapper.deleteUser(id);
    }

    /**
     * 更新用户信息的方法。
     * 该方法通过调用userMapper的updateUser方法来更新用户信息。
     *
     * @param user 要更新的用户对象
     */
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

}
