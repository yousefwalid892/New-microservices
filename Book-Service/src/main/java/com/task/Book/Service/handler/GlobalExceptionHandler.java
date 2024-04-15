package com.task.Book.Service.handler;

import com.task.Book.Service.CustomError.ErrorMessage;
import com.task.Book.Service.exception.BookAlreadyExistsException;
import com.task.Book.Service.exception.BookNotFoundException;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@Builder
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleBookNotFound(BookNotFoundException ex){
        ErrorMessage error = new ErrorMessage();
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setMessage("Book with this id is not exist");
        error.setTimestamp(new Date());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BookAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> handleBookAlreadyExists(BookAlreadyExistsException ex){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatusCode(HttpStatus.FOUND.value());
        errorMessage.setMessage("Book is already existing");
        errorMessage.setTimestamp(new Date());
        return new ResponseEntity<>(errorMessage,HttpStatus.FOUND);
    }
}

