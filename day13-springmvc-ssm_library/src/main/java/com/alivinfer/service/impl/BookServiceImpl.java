package com.alivinfer.service.impl;

import com.alivinfer.dao.BookDao;
import com.alivinfer.domain.Book;
import com.alivinfer.exception.BusinessException;
import com.alivinfer.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description TODO
 * @date 2025/3/25
 */

@Service
public class BookServiceImpl implements BookService {

    // 由于 bookDao 是通过代理实现的，没有引入 bean，因此会有警告
    @Autowired
    private BookDao bookDao;

    @Override
    public boolean saveBook(Book book) {
        return bookDao.saveBook(book) > 0;
    }

    @Override
    public boolean deleteBook(Integer id) {
        return bookDao.deleteBook(id) > 0;
    }

    @Override
    public boolean updateBook(Book book) {
        return bookDao.updateBook(book) > 0;
    }

    @Override
    public Book getBookById(Integer id) {
        // 模拟业务异常
       /* try {
            int a = 5 / 0;
        } catch (Exception e) {
            throw new BusinessException(555, "业务异常，请重试！");
        }*/
        return bookDao.getBookById(id);
    }

    @Override
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }
}
