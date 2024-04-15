package com.task.Book.Service.mapper;

import com.task.Book.Service.model.dto.BookDto;
import com.task.Book.Service.model.entity.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {
    BookDto toDto(Book book);
    Book toEntity(BookDto bookDto);
}
