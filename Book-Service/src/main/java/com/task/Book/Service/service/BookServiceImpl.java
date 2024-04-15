package com.task.Book.Service.service;

import com.task.Book.Service.exception.BookAlreadyExistsException;
import com.task.Book.Service.exception.BookNotFoundException;
import com.task.Book.Service.mapper.BookMapper;
import com.task.Book.Service.model.dto.BookDto;
import com.task.Book.Service.model.entity.Book;
import com.task.Book.Service.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    private final BookRepo bookRepo;
    @Autowired
    private final BookMapper bookMapper;

    @Override
    public Book createBook(BookDto bookDto) {
        Optional<Book> book = bookRepo.findById(bookDto.getId());
        if (book.isEmpty()) {
            return bookRepo.save(bookMapper.toEntity(bookDto));
        } else {
            log.info("Book is already existing");
            throw new BookAlreadyExistsException("Book is already existing");
        }
    }

    @Query(value = "SELECT books.author FROM books ORDER BY id")
    @Override
    public List<BookDto> getAllBooks(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Book> pages = bookRepo.findAll(pageable);
        List<Book> bookList = pages.getContent();
        return bookList.stream().map(s -> bookMapper.toDto(s)).collect(Collectors.toList());
    }

    @Override
    public BookDto viewBook(int id) {
        Optional<Book> book = bookRepo.findById(id);
        if (book.isPresent()) {
            return bookMapper.toDto(book.get());
        } else {
            log.error("book is not found");
            throw new BookNotFoundException("book with this id not found");
        }
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        Book existingBook = bookRepo.findById(bookDto.getId()).get();
        existingBook.setId(bookDto.getId());
        existingBook.setTitle(bookDto.getTitle());
        existingBook.setAuthor(bookDto.getAuthor());
        Book updatedBook = bookRepo.save(existingBook);
        return bookMapper.toDto(updatedBook);
    }

    @Override
    public void deleteBook(int id) {
        bookRepo.deleteById(id);
    }
}
