package com.alivinfer.service;

import com.alivinfer.mapper.AccountMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Fer
 * @version 1.0
 * @description 账户服务类
 * @date 2025/3/4
 */

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    // 开启事务
    @Transactional
    public void transfer(String from, String to, double amount) {
        accountMapper.withdraw(from, amount);
        // 模拟异常，测试事务回滚
        int error = 1 / 0;
        accountMapper.deposit(to, amount);
    }
}
