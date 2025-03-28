package com.alivinfer.service;

import com.alivinfer.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description Book 业务
 * @date 2025/3/25
 */
@Transactional
public interface BookService  {

    /**
     * 保存图书
     * @return 成功或失败
     */
    public boolean saveBook(Book book);

    /**
     * 根据 id 删除图书
     * @param id 图书 id
     * @return 成功或失败
     */
    public boolean deleteBook(Integer id);

    /**
     * 更新图书
     * @param book 图书
     * @return 成功或失败
     */
    public boolean updateBook(Book book);

    /**
     * 根据 id 查询图书
     * @param id 图书 id
     * @return 图书信息
     */
    public Book getBookById(Integer id);

    /**
     * 查询所有图书
     * @return 所有图书信息
     */
    public List<Book> getBooks();
}
