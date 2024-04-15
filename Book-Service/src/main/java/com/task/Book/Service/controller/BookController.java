package com.task.Book.Service.controller;

import com.task.Book.Service.model.dto.BookDto;
import com.task.Book.Service.model.entity.Book;
import com.task.Book.Service.service.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    @Autowired
    private final BookServiceImpl bookService;

    @PostMapping("/create")
    public Book createBook(@RequestBody BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @GetMapping("/view/{id}")
    public BookDto viewBook(@PathVariable int id) {
        return bookService.viewBook(id);
    }

    @GetMapping("/getAll")          //localhost:9090/book/getAll?pageNo=0&pageSize=5
    public List<BookDto> getAllBooks(@RequestParam int pageNo ,@RequestParam int pageSize){
        return bookService.getAllBooks(pageNo, pageSize);
    }

    @PutMapping("/update")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return bookService.updateBook(bookDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }
}
