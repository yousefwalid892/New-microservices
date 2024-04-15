package com.task.Book.Service.exception;

public class BookNotFoundException extends BookException {
    public BookNotFoundException(String message) {
        super(message);
    }
}