package com.alivinfer.service.impl;

import com.alivinfer.dao.RoleDao;
import com.alivinfer.domain.Role;
import com.alivinfer.service.RoleService;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 角色实现类
 * @date 2025/3/30
 */

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> list() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
