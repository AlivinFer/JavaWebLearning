package com.alivinfer;

import com.alivinfer.config.SpringConfig;
import com.alivinfer.controller.UserController;
import com.alivinfer.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Fer
 * @version 1.0
 * @description 测试
 * @date 2025/2/27
 */

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController userController = context.getBean(UserController.class);

        System.out.println("根据 id 查询用户: ");
        System.out.println(userController.showUserById(1));
        System.out.println("-------------------------");

        User adduser = new User();
        adduser.setName("lakesi");
        adduser.setEmail("9464w@163.com");
        userController.addUser(adduser);
        System.out.println("新增用户：");
        userController.displayUsers();
        System.out.println("-------------------------");

        User user1 = userController.showUserById(2);
        System.out.println(user1);
        user1.setName("newName");
        userController.updateUser(user1);
        System.out.println("更新后的用户信息：");
        System.out.println(user1);
        System.out.println("-------------------------");

        System.out.println("根据用户 id 删除用户信息：");
        userController.delete(adduser.getId());
        System.out.println("-------------------------");

        userController.displayUsers();

        context.close();
    }
}
