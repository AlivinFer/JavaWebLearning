package com.alivinfer.mapper;

import com.alivinfer.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description userMapper
 * @date 2025/2/27
 */

public interface UserMapper {

    @Select("SELECT * FROM users")
    List<User> findAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(long id);

    @Insert("INSERT INTO users (name, email) VALUES (#{name}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteUser(long id);

    @Update("UPDATE users SET name = #{name}, email = #{email} WHERE id = #{id}")
    void updateUser(User user);
}
