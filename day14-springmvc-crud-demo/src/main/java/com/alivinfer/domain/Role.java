package com.alivinfer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fer
 * @version 1.0
 * @description 角色实体类
 * @date 2025/3/29
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    /**
     * 角色 id
     */
    private Long id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String roleDesc;
}
