package com.alivinfer.handle;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * @author Fer
 * @version 1.0
 * @description 日期类型处理器
 * @date 2025/4/10
 */

public class DateTypeHandler extends BaseTypeHandler<LocalDate> {
    /**
     * 设置非空参数到预编译的 SQL 语句中
     * 该方法将 LocalDate 转换为基于 UTC 的毫秒值，并将其设置到指定的参数位置
     *
     * @param ps 预编译的 SQL 语句
     * @param i 参数位置
     * @param parameter 要设置的 LocalDate 参数
     * @param jdbcType JDBC 类型
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, LocalDate parameter, JdbcType jdbcType) throws SQLException {
        // 将 LocalDate 转换为毫秒值（基于 UTC）
        System.out.println("----setNonNullParameter---");
        long milliseconds = parameter.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        // 将毫秒值设置到预编译的 SQL 语句的指定位置
        ps.setLong(i, milliseconds);
    }

    /**
     * 从结果集中获取指定列的日期值
     * 如果结果集中的值为 NULL，则返回 null；否则，将毫秒值转换为LocalDate
     *
     * @param rs 结果集
     * @param columnName 列名
     * @return 返回指定列的日期值，如果值为 NULL 则返回 null
     */
    @Override
    public LocalDate getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // 从结果集中获取指定列的毫秒值
        long milliseconds = rs.getLong(columnName);

        // 如果结果集中的值为NULL，返回null；否则，将毫秒值转换为LocalDate
        return rs.wasNull() ? null : Instant.ofEpochMilli(milliseconds).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 从结果集中获取指定列的日期值
     * 如果结果集中的值为 NULL，则返回 null；否则，将毫秒值转换为 LocalDate
     *
     * @param rs 结果集
     * @param columnIndex 列索引
     * @return 返回指定列的日期值，如果结果集中的值为 NULL，则返回 null
     */
    @Override
    public LocalDate getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        // 从结果集中获取指定列的毫秒值
        long milliseconds = rs.getLong(columnIndex);

        // 如果结果集中的值为NULL，返回null；否则，将毫秒值转换为LocalDate
        return rs.wasNull() ? null : Instant.ofEpochMilli(milliseconds).atZone(ZoneId.systemDefault()).toLocalDate();
    }


    /**
     * 从 CallableStatement 中获取指定列的 LocalDate 值
     * 如果该列的值为NULL，则返回null；否则，将毫秒值转换为LocalDate
     *
     * @param cs CallableStatement对象，用于执行数据库调用
     * @param columnIndex 列的索引
     * @return 返回指定列的 LocalDate值，如果该列的值为 NULL，则返回 null
     */
    @Override
    public LocalDate getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        // 从CallableStatement中获取指定列的毫秒值
        long milliseconds = cs.getLong(columnIndex);

        // 检查该列的值是否为NULL
        // 如果为NULL，返回null；否则，将毫秒值转换为LocalDate
        return cs.wasNull() ? null : Instant.ofEpochMilli(milliseconds).atZone(ZoneId.systemDefault()).toLocalDate();
    }

}
