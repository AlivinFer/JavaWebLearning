package com.alivinfer.service;

import com.alivinfer.dao.UserMapperTest;
import com.alivinfer.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description User 服务类测试
 * @date 2025/4/8
 */

public class UserService {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapperTest mapper = sqlSession.getMapper(UserMapperTest.class);
        List<User> list = mapper.findAll();
        System.out.println(list);

        User user = mapper.findById(1);
        System.out.println(user);

    }

}
