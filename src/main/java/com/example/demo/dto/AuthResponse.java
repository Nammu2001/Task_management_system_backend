package com.example.demo.dto;

import lombok.Data;

@Data
public class AuthResponse {
    private Long id;
    private String email;

    public AuthResponse(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
