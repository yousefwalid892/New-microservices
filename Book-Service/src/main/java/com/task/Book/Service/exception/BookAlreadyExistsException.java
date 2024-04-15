package com.task.Book.Service.exception;

//@Builder
public class BookAlreadyExistsException extends BookException {
    public BookAlreadyExistsException(String message) {
        super(message);
    }
}
