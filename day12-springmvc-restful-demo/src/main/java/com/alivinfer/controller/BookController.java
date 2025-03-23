package com.alivinfer.controller;

import com.alivinfer.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description BookController
 * @date 2025/3/20
 */

@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping
    public String save(@RequestBody Book book) {
        System.out.println("book save ==> " + book);
        return "{'modules': 'book save success'}";
    }

    @GetMapping
    public List<Book> getAll() {
        List<Book> bookList = new ArrayList<>();

        Book book1 = new Book();
        book1.setType("计算机");
        book1.setName("SpringMvc 入门教程");
        book1.setDescription("从入门到放弃");

        Book book2 = new Book();
        book2.setType("计算机");
        book2.setName("SpringMvc 实战教程");
        book2.setDescription("一代宗师");

        bookList.add(book1);
        bookList.add(book2);

        return bookList;
    }
}
