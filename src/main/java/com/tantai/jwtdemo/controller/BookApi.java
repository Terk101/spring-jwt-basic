package com.tantai.jwtdemo.controller;

import com.tantai.jwtdemo.domain.dto.BookRequest;
import com.tantai.jwtdemo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/book")
@RequiredArgsConstructor
public class BookApi {
    private final BookService bookService;

    @PostMapping
    public void create(@RequestBody @Valid BookRequest request) {
        bookService.saveBook(request);
    }
}
