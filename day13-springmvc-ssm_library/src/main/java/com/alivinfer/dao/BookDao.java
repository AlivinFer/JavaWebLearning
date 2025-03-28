package com.alivinfer.dao;

import com.alivinfer.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 操作数据库
 * @date 2025/3/25
 */
public interface BookDao {

    /**
     * mybatis 注解 sql
     * @param book 图书类
     * @return 当 SQL 执行成功后，影响行数大于 0，当 SQL 执行失败时，影响行数为 0
     */
    @Insert("insert into tbl_book (type, name, description) values (#{type}, #{name}, #{description})")
    public int saveBook(Book book);

    @Delete("delete from tbl_book where id = #{id}")
    public int deleteBook(Integer id);

    @Update("update tbl_book set type = #{type}, name = #{name}, description = #{description} where id = #{id}")
    public int updateBook(Book book);

    @Select("select * from tbl_book where id = #{id}")
    public Book getBookById(Integer id);

    @Select("select * from tbl_book")
    public List<Book> getBooks();
}
