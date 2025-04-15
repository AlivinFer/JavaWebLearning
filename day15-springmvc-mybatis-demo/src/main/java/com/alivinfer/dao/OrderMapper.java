package com.alivinfer.dao;

import com.alivinfer.domain.Order;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 订单 Mapper
 * @date 2025/4/12
 */
public interface OrderMapper {

    public List<Order> findAllOrder();
}
