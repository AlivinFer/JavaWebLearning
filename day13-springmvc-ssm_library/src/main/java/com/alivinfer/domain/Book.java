package com.alivinfer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fer
 * @version 1.0
 * @description 实体类
 * @date 2025/3/24
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    /**
     * id 主键
     */
    private Integer id;

    /**
     * 图书类型
     */
    private String type;

    /**
     * 图书名称
     */
    private String name;

    /**
     * 图书信息描述
     */
    private String description;
}
