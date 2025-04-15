package com.alivinfer.dao;

import com.alivinfer.domain.Order;
import com.alivinfer.domain.User;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description UserMapper 接口
 * @date 2025/4/8
 */
public interface UserMapperTest {

    /**
     * @return 查找所有用户西悉尼
     * @throws IOException 异常
     */
    public List<User> findAll() throws IOException;

    /**
     * @param id 用户 id
     * @return 用户信息
     */
    public User findById(int id);

    /**
     * @param user 用户实体类
     * @return 用户列表
     */
    public List<User> findByCondition(User user);

    /**
     * @param idList id 集合
     * @return 用户列表
     */
    public List<User> findByIds(@Param("idList") List<Integer> idList);

    /**
     * 保存用户信息
     * @param user 用户
     */
    public void save(User user);

    /**
     * 查找用户所有订单
     */
    public List<User> findAllOrder();

    public List<User> findAllWithRoles();

}
