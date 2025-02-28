package com.alivinfer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fer
 * @version 1.0
 * @description 用户实体类
 * @date 2025/2/27
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;
}
