package com.task.Employee.Service.exception;

public class EmployeeNotFoundException extends EmployeeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}