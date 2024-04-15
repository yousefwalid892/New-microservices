package com.task.Book.Service.CustomError;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private Integer StatusCode;
    private String Message;
    private Date Timestamp;
}
