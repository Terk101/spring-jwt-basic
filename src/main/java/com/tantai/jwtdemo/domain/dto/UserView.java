package com.tantai.jwtdemo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserView {
    private String id;

    private String username;
    private String fullName;
}
