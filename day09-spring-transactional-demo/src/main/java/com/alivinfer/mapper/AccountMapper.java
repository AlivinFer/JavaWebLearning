package com.alivinfer.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author Fer
 * @version 1.0
 * @description mapper
 * @date 2025/3/4
 */
public interface AccountMapper {
    @Update("UPDATE account SET balance = balance - #{amount} WHERE name = #{from}")
    void withdraw(@Param("from") String from, @Param("amount") double amount);

    @Update("UPDATE account SET balance = balance + #{amount} WHERE name = #{to}")
    void deposit(@Param("to") String to, @Param("amount") double amount);
}
