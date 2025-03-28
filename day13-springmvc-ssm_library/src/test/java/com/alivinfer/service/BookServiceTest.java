package com.alivinfer.service;

import com.alivinfer.config.SpringConfig;
import com.alivinfer.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description BookService 测试类
 * @date 2025/3/25
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testGetById() {
        Book book = bookService.getBookById(1);
        System.out.println(book);
    }

    @Test
    public void testGetAll() {
        List<Book> books = bookService.getBooks();
        System.out.println(books);
    }

    @Test
    public void testAdd() {
        boolean isSuccess = bookService.saveBook(new Book(null, "金融", "经济学", "从入门到大师"));
        if (isSuccess) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    @Test
    public void testUpdate() {
        boolean isSuccess = bookService.updateBook(new Book(13, "金融", "世界经济学", "先赚一个小目标"));
        if (isSuccess) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void testDelete() {
        boolean isSuccess = bookService.deleteBook(13);
        if (isSuccess) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }
}
