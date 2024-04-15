package com.task.Employee.Service.handler;

import com.task.Employee.Service.CustomError.ErrorMessage;
import com.task.Employee.Service.exception.EmployeeAlreadyExistsException;
import com.task.Employee.Service.exception.EmployeeNotFoundException;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@Builder
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleBookNotFound(EmployeeNotFoundException ex){
        ErrorMessage error = new ErrorMessage();
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setMessage("Book with this id is not exist");
        error.setTimestamp(new Date());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EmployeeAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> handleBookAlreadyExists(EmployeeAlreadyExistsException ex){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatusCode(HttpStatus.FOUND.value());
        errorMessage.setMessage("Book is already existing");
        errorMessage.setTimestamp(new Date());
        return new ResponseEntity<>(errorMessage,HttpStatus.FOUND);
    }
}

