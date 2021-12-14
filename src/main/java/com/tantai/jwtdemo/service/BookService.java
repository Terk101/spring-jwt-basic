package com.tantai.jwtdemo.service;

import com.tantai.jwtdemo.domain.Book;
import com.tantai.jwtdemo.domain.dto.BookRequest;
import com.tantai.jwtdemo.domain.mapper.BookMapper;
import com.tantai.jwtdemo.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Transactional
    public void saveBook(BookRequest bookRequest) {
        Book book = bookMapper.create(bookRequest);
        bookRepository.save(book);
    }
}
