package com.task.Employee.Service.exception;

public class EmployeeException extends RuntimeException{
    String message;
    public EmployeeException(String message) {
        this.message = message;
    }
}
