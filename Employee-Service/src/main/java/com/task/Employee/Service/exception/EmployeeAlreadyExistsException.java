package com.task.Employee.Service.exception;

public class EmployeeAlreadyExistsException extends EmployeeException {
    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }
}
