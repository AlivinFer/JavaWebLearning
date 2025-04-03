package com.alivinfer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 用户实体类
 * @date 2025/3/29
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * 用户 id
     */
    private Long id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户手机号
     */
    private String phoneNum;

    /**
     * 当前用户具备哪些角色
     */
    private List<Role> roles;
}
