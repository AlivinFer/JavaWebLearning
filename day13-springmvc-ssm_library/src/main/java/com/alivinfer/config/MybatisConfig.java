package com.alivinfer.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author Fer
 * @version 1.0
 * @description Mybatis 配置类
 * @date 2025/3/23
 */

public class MybatisConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("com.alivinfer.domain");
        return factoryBean;
    }

    /**
     * 配置MyBatis的 MapperScannerConfigurer，用于扫描并注册 Mapper 接口
     *
     * @return 返回配置好的 MapperScannerConfigurer 实例
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        // 创建 MapperScannerConfigurer 实例
        MapperScannerConfigurer msc = new MapperScannerConfigurer();

        // 设置基础包路径，MyBatis 将扫描该路径下的所有 Mapper 接口
        msc.setBasePackage("com.alivinfer.dao");

        // 返回配置好的MapperScannerConfigurer实例
        return msc;
    }

}
