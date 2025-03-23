package com.alivinfer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fer
 * @version 1.0
 * @description book 类
 * @date 2025/3/20
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    /**
     * id
     */
    private Integer id;

    /**
     * 类型
     */
    private String type;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;
}
