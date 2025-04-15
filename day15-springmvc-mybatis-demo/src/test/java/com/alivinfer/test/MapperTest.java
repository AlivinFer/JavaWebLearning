package com.alivinfer.test;

import com.alivinfer.dao.OrderMapper;
import com.alivinfer.dao.UserMapperTest;
import com.alivinfer.domain.Order;
import com.alivinfer.domain.Role;
import com.alivinfer.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 测试动态 SQL
 * @date 2025/4/9
 */

public class MapperTest {

    @Test
    public void test() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapperTest mapperTest = sqlSession.getMapper(UserMapperTest.class);

        User condition = new User();
        condition.setId(3);
        condition.setUserName("Ha");

        // 模拟条件查询
        List<User> userList = mapperTest.findByCondition(condition);
        System.out.println("findByCondition: " + userList);

        // 模拟 idList
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);

        List<User> users = mapperTest.findByIds(idList);
        System.out.println("findByIds: " + users);
    }

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapperTest mapperTest = sqlSession.getMapper(UserMapperTest.class);

        System.out.println("当前时间：" + LocalDate.now());
        User user = new User(null, "Li", "asddad", LocalDate.now(), null, null);
        mapperTest.save(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapperTest mapperTest = sqlSession.getMapper(UserMapperTest.class);

        User user = mapperTest.findById(6);
        System.out.println("user 中的 birthday: " + user.getBirthday());

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapperTest mapperTest = sqlSession.getMapper(UserMapperTest.class);

        // 设置分页参数(作用范围仅限于紧随其后的第一个查询操作，中间如果插入代码可能会导致分页失效)
        PageHelper.startPage(3, 3);

        List<User> userList = mapperTest.findAll();
        for (User user : userList) {
            System.out.println(user);
        }

        //获得与分页相关参数
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println("当前页：" + pageInfo.getPageNum());
        System.out.println("每页显示条数：" + pageInfo.getPageSize());
        System.out.println("总条数：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("上一页：" + pageInfo.getPrePage());
        System.out.println("下一页：" + pageInfo.getNextPage());
        System.out.println("是否是第一个：" + pageInfo.isIsFirstPage());
        System.out.println("是否是最后一个：" + pageInfo.isIsLastPage());

        sqlSession.close();
    }

    @Test
    public void test4() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> orderList = orderMapper.findAllOrder();
        for (Order order : orderList) {
            System.out.println(order);
        }

        sqlSession.close();
    }

    @Test
    public void test5() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapperTest mapperTest = sqlSession.getMapper(UserMapperTest.class);

        List<User> users = mapperTest.findAllOrder();
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void test6() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapperTest mapperTest = sqlSession.getMapper(UserMapperTest.class);

        List<User> users = mapperTest.findAllWithRoles();
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
