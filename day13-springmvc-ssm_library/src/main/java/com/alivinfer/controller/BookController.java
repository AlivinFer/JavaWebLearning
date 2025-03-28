package com.alivinfer.controller;

import com.alivinfer.domain.Book;
import com.alivinfer.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description TODO
 * @date 2025/3/25
 */

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Result saveBook(@RequestBody Book book) {
        boolean flag = bookService.saveBook(book);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag, flag ? "操作成功" : "操作失败");
    }

    @DeleteMapping("/{id}")
    public Result deleteBook(@PathVariable("id") Integer id) {
        boolean flag = bookService.deleteBook(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag, flag ? "操作成功" : "操作失败");
    }

    @PutMapping
    public Result updateBook(@RequestBody Book book) {
        boolean flag = bookService.updateBook(book);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, flag ? "操作成功" : "操作失败");
    }

    @GetMapping("/{id}")
    public Result getBookById(@PathVariable("id") Integer id) {
        Book book = bookService.getBookById(id);
        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        String msg = book != null ? "操作成功" : "操作失败";
        return new Result(code, book, msg);
    }

    @GetMapping
    public Result getBooks() {
        List<Book> bookList = bookService.getBooks();
        Integer code = bookList != null ? Code.GET_ALL_OK : Code.GET_ALL_ERR;
        String msg = bookList != null ? "操作成功" : "操作失败";
        return new Result(code, bookList, msg);
    }
}
