package com.tantai.jwtdemo.domain.dto;

import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private String about;
    private String language;
    private String isbn;
}
