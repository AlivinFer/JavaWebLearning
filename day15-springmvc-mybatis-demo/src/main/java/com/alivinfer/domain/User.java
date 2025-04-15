package com.alivinfer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description User 实体类
 * @date 2025/4/7
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;

    private String userName;

    private String password;

    private LocalDate birthday;

    /**
     * 当前用户有哪些订单
     */
    private List<Order> orders;

    /**
     * 当前用户有哪些角色
     */
    private List<Role> roles;
}
