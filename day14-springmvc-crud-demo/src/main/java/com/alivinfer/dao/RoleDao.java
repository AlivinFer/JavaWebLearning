package com.alivinfer.dao;

import com.alivinfer.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 角色 Dao 接口
 * @date 2025/3/29
 */
public interface RoleDao {

    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUserId(Long id);
}
