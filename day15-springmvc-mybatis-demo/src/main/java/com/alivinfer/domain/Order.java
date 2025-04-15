package com.alivinfer.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author Fer
 * @version 1.0
 * @description 订单
 * @date 2025/4/12
 */

@Data
public class Order {

    private int id;

    /**
     * 订单时间
     */
    private Date orderTime;

    /**
     * 订单总数
     */
    private double total;

    /**
     * 当前订单属于哪一个用户
     */
    private User user;
}
