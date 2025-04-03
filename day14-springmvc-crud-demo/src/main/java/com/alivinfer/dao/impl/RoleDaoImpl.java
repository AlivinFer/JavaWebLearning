package com.alivinfer.dao.impl;

import com.alivinfer.dao.RoleDao;
import com.alivinfer.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 用户实现类
 * @date 2025/3/30
 */

public class RoleDaoImpl implements RoleDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> findAll() {
        return jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<>(Role.class));
    }

    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values(?, ?, ?)", null, role.getRoleName(), role.getRoleDesc());
    }

    @Override
    public List<Role> findRoleByUserId(Long id) {
        return jdbcTemplate.query("select * from sys_user_role ur, sys_role r where ur.roleId = r.id and ur.userId = ?", new BeanPropertyRowMapper<>(Role.class), id);
    }
}
