package com.task.Book.Service.exception;

public class BookException extends RuntimeException{
    String message;
    public BookException(String message) {
        this.message = message;
    }
}
