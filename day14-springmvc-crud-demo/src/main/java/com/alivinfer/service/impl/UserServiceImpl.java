package com.alivinfer.service.impl;

import com.alivinfer.dao.RoleDao;
import com.alivinfer.dao.UserDao;
import com.alivinfer.domain.Role;
import com.alivinfer.domain.User;
import com.alivinfer.service.UserService;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 用户实现类
 * @date 2025/3/30
 */

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        // 封装 userList 中的每一个 User 的 roles 数据
        for (User user : userList) {
            //获得user的id
            Long id = user.getId();
            // 将 id 作为参数 查询当前 userId 对应的 Role 集合数据
            List<Role> roles = roleDao.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;

    }

    @Override
    public void save(User user, Long[] roleIds) {
        //第一步 向sys_user表中存储数据
        Long userId = userDao.save(user);
        //第二步 向 sys_user_role 关系表中存储多条数据
        userDao.saveUserRoleRel(userId, roleIds);
    }

    @Override
    public void del(Long userId) {
        userDao.del(userId);
    }
}
