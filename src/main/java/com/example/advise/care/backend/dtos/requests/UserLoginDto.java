package com.example.advise.care.backend.dtos.requests;

import lombok.Data;

@Data
public class UserLoginDto {
    String email;
    String password;
}
