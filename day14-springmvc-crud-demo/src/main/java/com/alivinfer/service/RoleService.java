package com.alivinfer.service;

import com.alivinfer.domain.Role;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 角色服务类
 * @date 2025/3/30
 */
public interface RoleService {

    public List<Role> list() ;

    void save(Role role);
}
