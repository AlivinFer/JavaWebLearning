package com.alivinfer.dao.impl;

import com.alivinfer.dao.UserDao;
import com.alivinfer.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.lang.NonNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 * @author Fer
 * @version 1.0
 * @description 用户角色实现类
 * @date 2025/3/30
 */

public class UserRoleImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<>(User.class));
    }

    /**
     * 保存用户信息到数据库，并返回生成的用户 ID
     *
     * @param user 要保存的用户对象
     * @return 返回生成的用户 ID
     */
    @Override
    public Long save(User user) {
        // 创建一个 PreparedStatementCreator 对象，用于生成 PreparedStatement
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            /**
             * 创建并返回一个PreparedStatement对象
             *
             * @param con 数据库连接对象
             * @return 返回生成的PreparedStatement对象
             */
            @Override
            @NonNull
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                // 使用原始 jdbc 完成 PreparedStatement 的组建
                PreparedStatement preparedStatement = con.prepareStatement("insert into sys_user values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                // 设置PreparedStatement的参数
                preparedStatement.setObject(1, null);
                preparedStatement.setString(2, user.getUserName());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getPhoneNum());
                return preparedStatement;
            }
        };

        // 创建一个 GeneratedKeyHolder 对象，用于获取生成的主键
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        // 使用 jdbcTemplate 执行更新操作，并将生成的主键保存到keyHolder中
        jdbcTemplate.update(creator, keyHolder);
        //获得生成的主键
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    /**
     * 一个用户可能对应多个角色
     * @param userId 用户 id
     * @param roleIds 角色 id
     */
    @Override
    public void saveUserRoleRel(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values(?,?)", userId, roleId);
        }
    }

    @Override
    public void delUserRoleRel(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId = ?", userId);
    }

    @Override
    public void del(Long userId) {
        jdbcTemplate.update("delete from sys_user where id = ?", userId);
    }
}
