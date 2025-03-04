package com.alivinfer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fer
 * @version 1.0
 * @description 账户实体类
 * @date 2025/3/4
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    /**
     * id
     */
    private int id;

    /**
     * 账户名称
     */
    private String name;

    /**
     * 账户余额
     */
    private double balance;
}
