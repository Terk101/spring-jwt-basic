package com.tantai.jwtdemo.domain.mapper;

import com.tantai.jwtdemo.domain.Book;
import com.tantai.jwtdemo.domain.dto.BookRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book create(BookRequest bookRequest);
}
