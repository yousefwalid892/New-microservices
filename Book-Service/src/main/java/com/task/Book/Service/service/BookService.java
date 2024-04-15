package com.task.Book.Service.service;

import com.task.Book.Service.model.dto.BookDto;
import com.task.Book.Service.model.entity.Book;

import java.util.List;

public interface BookService {
    Book createBook(BookDto bookDto);
    List<BookDto> getAllBooks(int pageNo , int pageSize);
    BookDto viewBook(int id);
    BookDto updateBook(BookDto bookDto);
    void deleteBook(int id);

}
